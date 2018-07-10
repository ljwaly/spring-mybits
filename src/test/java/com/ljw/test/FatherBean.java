package com.ljw.test;

import org.junit.After;
import org.junit.Before;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FatherBean {

	//protected ApplicationContext app;
	protected AbstractApplicationContext ctx;
	protected AbstractApplicationContext appMvc;
	
	@Before
	public void init(){
		//app = new ClassPathXmlApplicationContext("spring-bean.xml");
		ctx = new ClassPathXmlApplicationContext("spring-bean.xml");
		appMvc=new ClassPathXmlApplicationContext("spring-mvc.xml");
		String[] beans = appMvc.getBeanDefinitionNames();
		for (String bean : beans) {
			System.out.println(bean);
		}
		
	}
	
	@After
	public void tearDown(){
		ctx.close();
		appMvc.close();
	}
}
