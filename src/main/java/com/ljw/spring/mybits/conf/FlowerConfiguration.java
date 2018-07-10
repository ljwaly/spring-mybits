package com.ljw.spring.mybits.conf;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.ljw.spring.mybits.vo.Flower;

@Configuration
public class FlowerConfiguration {
	
	private static Logger log = Logger.getLogger(FlowerConfiguration.class);

	@Bean("sunflower")
	@Primary
	public Flower getFlower(){
		
		Flower flower = new Flower();
		flower.setColor("yellow");
		flower.setDate(new Date());
		flower.setName("sunFlower");
		flower.setDesc("Face to the sun!");
		log.fatal("Flower sunflower init success!");
		return flower;
		
	}
}
