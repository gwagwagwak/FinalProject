package com.paylog.project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class MainController {

	
	
	
	
	@RequestMapping(value="/")
	
	public String home(){
		
		
		
		return "index";
		
	}	
	
	@RequestMapping(value="/main.do")
	
	public String main(){
		
		
		
		return "index";
		
	}
	
	
	
	
	
}
