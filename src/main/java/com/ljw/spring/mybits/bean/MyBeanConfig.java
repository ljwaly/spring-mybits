package com.ljw.spring.mybits.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.ljw.spring.mybits.vo.Flower;

@Configuration
@PropertySource(encoding="UTF-8", value = { "classpath:/com/resource/beantest.properties" })
public class MyBeanConfig {

	@Autowired
	private Environment env;
	
	
	@Bean("flowerProperty")
	public Flower getFlower(){
	    Flower f = new Flower();
		f.setColor(env.getProperty("flower.color"));
		f.setName(env.getProperty("flower.name"));
		f.setDesc(env.getProperty("flower.desc"));
		System.out.println(env.getProperty("flower.desc"));
		return f;
	}
	
	
}
	