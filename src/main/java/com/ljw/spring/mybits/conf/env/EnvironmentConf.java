package com.ljw.spring.mybits.conf.env;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class EnvironmentConf {

	
	private static Logger log = Logger.getLogger(EnvironmentConf.class);
	
	@Autowired
	private Environment evn;
	
	@PostConstruct
	public void init(){
		
	}
	
}
