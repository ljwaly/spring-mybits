package com.ljw.spring.mybits.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ljw.spring.mybits.cache.MyCacheManager;
import com.ljw.spring.mybits.dao.EmpDao;
import com.ljw.spring.mybits.dao.entity.Emp;
import com.ljw.spring.mybits.util.Configuration;
import com.ljw.spring.mybits.util.ServerApplicationContextUtil;
import com.ljw.spring.mybits.vo.Flower;
import com.ljw.spring.mybits.vo.Garden;
import com.ljw.spring.mybits.vo.Response;
import com.ljw.spring.mybits.vo.response.MyResponse;




/**
 * 路径http://localhost:8080/sdfsdf/query
 * @author PC
 *
 */
@Controller
public class MyJsonController {
	
	
	@Autowired
	@Qualifier("sunflower")
	private Flower flower;
	
	@Autowired
	@Qualifier("flowerProperty")
	private Flower flowerProperty;
	
	@Autowired
	private Garden garden;
	
	
	@Autowired
	private EmpDao empDap;
	
	
	public static Logger log =Logger.getLogger(MyJsonController.class);

	@RequestMapping("/query")
	@ResponseBody
	public Response querydata(){
		
		Response response = new Response();
		
		response.setResultCode("success");
		response.setResultDesc("成功");
		List<Emp> findAll = empDap.findAll();
		for (Emp emp : findAll) {
			System.out.println(emp);
		}
		return response;
		
	}
	
	@RequestMapping("/queryMy")
	@ResponseBody
	public MyResponse<Long,String> queryMydata(){
		
		MyResponse<Long,String> response = new MyResponse<Long,String>();
		
		response.setResultCode("success");
		response.setResultDesc("成功");
		List<String> resultList=new ArrayList<String>();
		
		MyCacheManager myCacheManager = (MyCacheManager) ServerApplicationContextUtil.getApplicationContext().getBean("myCacheManager");
		String value = myCacheManager.getValue(1);
		resultList.add(value);
		
		Configuration conf = Configuration.getInstance();
		String value1 = conf.getProperties("myCore");
		resultList.add(value1);
		log.info(resultList);
		
		
		
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("/spring-mvc.xml");// 读取spring-mvc.xml中的内容
//		//Flower bean = (Flower) ServerApplicationContextUtil.getApplicationContext().getBean("flower");
//		//此处会报找不到bean异常，为什么ServerApplicationContextUtil的类不识别@Configuration的@Bean
//		
//		Flower bean = (Flower) ctx.getBean("flower");
//		
//		System.out.println(bean);
		
		log.fatal("beanConfiguration-Flower:"+flower);
		log.fatal("beanConfiguration-FlowerProperty:"+flowerProperty);
		log.fatal("beanConfiguration-Garden:"+garden);
		response.setResultList(resultList);
		
		
		Emp emp=new Emp();
		emp.setEname("xiaohei100");
		empDap.save(emp);
		
		
		
		return response;
		
	}
	
	/**
	 * http://localhost:8080/sdfsdf/private/queryMy?clientKey=ljw
	 * 
	 * 
	 * clientKey由配置文件决定，在拦截器2中进行校验
	 * @return
	 */
	@RequestMapping("/private/queryMy")
	@ResponseBody
	public MyResponse<Long,String> privateQueryMydata(){
		
		MyResponse<Long,String> response = new MyResponse<Long,String>();
		
		response.setResultCode("success");
		response.setResultDesc("成功");
		List<String> resultList=new ArrayList<String>();
		
		MyCacheManager myCacheManager = (MyCacheManager) ServerApplicationContextUtil.getApplicationContext().getBean("myCacheManager");
		String value = myCacheManager.getValue(1);
		resultList.add(value);
		
		Configuration conf = Configuration.getInstance();
		String value1 = conf.getProperties("myCore");
		resultList.add(value1);
		
		
		
		
		response.setResultList(resultList);
		
		return response;
		
	}
	
	/**
	 * http://localhost:8080/sdfsdf/public/ljw
	 * @param keyId
	 * @return
	 */
	@RequestMapping("/public/{keyId}")
	@ResponseBody
	public MyResponse<Long,String> publicQueryMydata(@PathVariable(value="keyId")String keyId){
		
		MyResponse<Long,String> response = new MyResponse<Long,String>();
		
		response.setResultCode("success");
		response.setResultDesc("成功");
		List<String> resultList=new ArrayList<String>();
		
		MyCacheManager myCacheManager = (MyCacheManager) ServerApplicationContextUtil.getApplicationContext().getBean("myCacheManager");
		String value = myCacheManager.getValue(1);
		resultList.add(value);
		resultList.add(keyId);
		Configuration conf = Configuration.getInstance();
		String value1 = conf.getProperties("myCore");
		resultList.add(value1);
		
		response.setResultList(resultList);
		
		return response;
		
	}
	
	
}
