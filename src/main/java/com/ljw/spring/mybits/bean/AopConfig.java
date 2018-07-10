package com.ljw.spring.mybits.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.ljw.spring.mybits.log.LoginLogService;



/**
 * 
 * 使用javaConfig进行aop切面配置
 * 
 * LoginLogService是切面
 * 
 * 
 * @author PC
 *
 */

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class AopConfig {
	
	@Bean
	public LoginLogService loginLogService(){
		return new LoginLogService();
		
	}

}
