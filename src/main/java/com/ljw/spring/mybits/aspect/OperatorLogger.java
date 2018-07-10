package com.ljw.spring.mybits.aspect;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


/**
 * AOP面向切面方面组件
 * @author ljw
 *
 */
@Component
@Aspect
public class OperatorLogger {
	
	private static Logger log = Logger.getLogger(OperatorLogger.class);

	/**
	 * 前置方法
	 */
	@Before("within(com.ljw.spring.mybits.controller..*)")
	public void logBefore(){
		log.info("logBefore(前置)-----------------------------AOP面向切面生效");
		
	}
	
	/**
	 * 后置方法
	 */
	@After("within(com.ljw.spring.mybits.controller..*)")
	public void logAfter(){
		log.info("logAfter(后置)-----------------------------AOP面向切面生效");
	}
	
	/**
	 * 环绕方法
	 */
	@Around("within(com.ljw.spring.mybits.controller..*)")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable{
		
		Object target = joinPoint.getTarget();
		String className = target.getClass().getName();
		
		Signature signature = joinPoint.getSignature();
		String methodName = signature.getName();
		
		String date= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
		String msg = "-->用户在"+date+",执行了"+className+"."+methodName+"()";
		
		log.info(msg);
		
		Object proceed = joinPoint.proceed();
		
		
		return proceed;
		
	}
	
	/**
	 * 
	 * @param e
	 */
	@AfterThrowing(value="within(com.ljw.spring.mybits.controller..*)", throwing="e")
	public void logException(Throwable e){
		StackTraceElement[] stackTrace = e.getStackTrace();
		log.info("@AfterThrowing-->"+stackTrace[0].toString());
	}
	
}
