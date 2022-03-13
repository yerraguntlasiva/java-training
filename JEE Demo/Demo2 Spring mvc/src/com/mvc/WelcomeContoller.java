package com.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.DispatcherServlet;

@Controller
public class WelcomeContoller {
	
	public WelcomeContoller() {
		System.out.println("welcome controller initilize");
	}
	@RequestMapping("/welcome1")
	public String welcome() {
		System.out.println("welcome contro");
		return "welcome";
	}

}
