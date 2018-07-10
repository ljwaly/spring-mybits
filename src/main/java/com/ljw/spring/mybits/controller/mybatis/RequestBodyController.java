package com.ljw.spring.mybits.controller.mybatis;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ljw.spring.mybits.cache.son.FirstCacheManager;

import com.ljw.spring.mybits.dao.entity.Empe;

@Controller
@RequestMapping("/test")
public class RequestBodyController {
	
	@Autowired
	private FirstCacheManager firstCacheManager;
	
	
	@RequestMapping("/test")
	@ResponseBody
	public Empe test(@RequestParam String id){
		Empe empe = firstCacheManager.get(id);
		return empe;
		
	}
	

	@RequestMapping("/test1")
	@ResponseBody
	public boolean test1(){
		return true;
		
	}
	
	
	@RequestMapping("/test2")
	@ResponseBody
	public Map<String, Object> test2(@RequestHeader HttpHeaders header){
		
		
		String name = header.getFirst("name");
		String pwd = header.getFirst("pwd");
		String sal = header.getFirst("sal");
		
		
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", 6);
		map.put("name", name);
		map.put("pwd", pwd);
		map.put("sal", sal);
		return map;
	}
	
}
