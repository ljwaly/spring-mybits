package com.ljw.spring.mybits.conf;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.ljw.spring.mybits.vo.Flower;
import com.ljw.spring.mybits.vo.Garden;

@Configuration
@Import(FlowerConfiguration.class)
public class GardenConfiguration {
	private static Logger log = Logger.getLogger(GardenConfiguration.class);
	
	@Bean
	public Garden getGarden(Flower flower){
		log.fatal("Garden init success!");
		return new Garden(flower);
	}
}
