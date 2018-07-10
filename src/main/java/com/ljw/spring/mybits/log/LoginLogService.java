package com.ljw.spring.mybits.log;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


/**
 * 切面
 */
@Aspect
public class LoginLogService {
	private Logger log = Logger.getLogger(LoginLogService.class);

	/**
	 * 切点
	 */
	@Pointcut("execution(* com.ljw.spring.mybits.controller.MyJsonController.*(..))")
	public void qiedian(){
	}
	
	
	/**
	 * Advice
	 * 通知：Before,After,Around,AfterThrowing,AfterReturning
	 * 
	 * @param jp
	 * @return
	 * @throws Throwable
	 */
	@Around("qiedian()")
	public Object setLog(ProceedingJoinPoint jp) throws Throwable{
		
		//返回结果
		Object resultValue = jp.proceed();
		
		//方法名字
		String methodName = jp.getSignature().getName();
		
		
		//输入参数
		String argString="";
		Object[] args = jp.getArgs();
		if(args != null){
			StringBuilder sb =new StringBuilder();
			for (Object object : args) {
				if (object==null) {
					sb.append("%null");
				}else{
					sb.append("%"+object.toString());
				}
			}
			argString =sb.toString();
		}
		
		
		
		log.fatal("methodName:"+methodName
				+", args:"+argString
				+", reslut:"+resultValue
				);
		return resultValue;
		
	}
}
