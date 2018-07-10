package com.ljw.spring.mybits.conf.dev;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import com.ljw.spring.mybits.conf.env.CheckCondition;
import com.ljw.spring.mybits.vo.Flower;

@Configuration
public class MyDataBase {

	private static Logger log = Logger.getLogger(MyDataBase.class);
	
	@Bean("rose")
	@Conditional(CheckCondition.class)
	public Flower getFlower(){
		Flower flower = new Flower();
		flower.setColor("red");
		flower.setDate(new Date());
		flower.setName("rose");
		flower.setDesc("means love");
		log.fatal("Flower rose init success!");
		return flower;
	} 
}
