package com.ljw.spring.mybits.conf.env;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class CheckCondition implements Condition{
	private static Logger log = Logger.getLogger(CheckCondition.class);

	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		Environment environment = context.getEnvironment();
		
		boolean condition = environment.containsProperty("flower");
	
		String[] beanDefinitionNames = context.getRegistry().getBeanDefinitionNames();
		
		
		for (String string : beanDefinitionNames) {
			System.out.println(string);
		}
		log.fatal(condition);
		
		return condition;
		
	}

}
