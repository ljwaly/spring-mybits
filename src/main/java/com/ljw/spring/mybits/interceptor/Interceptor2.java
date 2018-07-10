package com.ljw.spring.mybits.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ljw.spring.mybits.util.Configuration;


public class Interceptor2 implements HandlerInterceptor{
	
	
	private static Logger log = Logger.getLogger(Interceptor2.class);
	
	private static Configuration conf= null;

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("preHandle2-----------------拦截器2起效");
		
		conf = Configuration.getInstance();
		String interceptor2_key = conf.getProperties("interceptor2_key");
		if (interceptor2_key == null||"".equals(interceptor2_key)) {//如果配置文件没有配置，则正常执行url方法
			return true;
		}
		
		if (interceptor2_key.equals(request.getParameter("clientKey"))) {//如果进行配置，则判断有无传递，如果传递复合条件，则正常执行url方法
			return true;
		}
		log.error("preHandle2-----------------params need clientKey, clientKey can not be null!");
		return false;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info("postHandle2-----------------拦截器2起效");
		
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		log.info("afterCompletion2-----------------拦截器2起效");
		
	}
	

}
