package com.ljw.spring.mybits.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


/**
 * 拦截器
 * @author ljw
 * 
 *
 */
public class Interceptor1 implements HandlerInterceptor{

	private static Logger log = Logger.getLogger(Interceptor1.class);
	/**
	 * 前置方法
	 * preHandle返回为true，继续执行，false，进行拦截
	 * 进入控制器方法之前运行
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("preHandle1-----------------拦截器1起效");
		return true;
	}

	/**
	 * 后置方法
	 * 控制器方法执行结束，DispatcherServlet执行结果匹配ModelAndView之前
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info("postHandle1-----------------拦截器1起效");
		
	}

	/**
	 * 完成方法
	 * DispatcherServlet执行结果匹配modelandview之后执行
	 * 
	 */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		log.info("afterCompletion1-----------------拦截器1起效");
		
	}


}
