package com.greatness.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController{
	
	@RequestMapping("/")
	public String welcome() {            
	    return "redirect:/swagger-ui.html";
	}

}
