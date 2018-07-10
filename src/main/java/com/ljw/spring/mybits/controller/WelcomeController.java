	package com.ljw.spring.mybits.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

	public static Logger log = Logger.getLogger(WelcomeController.class);
	
	
	@RequestMapping("/main")
	public ModelAndView main(){
		ModelAndView mv = new ModelAndView("/main");
		
		String[] value = {"t", "y", "d", "m", "c", "b", "f", "z", "q", "g", "x"};
		mv.addObject("myl", value);
		//log.error("main请求");
		return mv;
	}
	
	
	@RequestMapping("/emp/{desPath}")
	public ModelAndView empPages(@PathVariable(value="desPath")String desPath){
		ModelAndView mv = new ModelAndView("/emp/"+desPath);
		return mv;
		
	}
	
}
