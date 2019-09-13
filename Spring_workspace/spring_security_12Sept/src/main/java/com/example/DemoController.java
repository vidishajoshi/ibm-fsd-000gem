package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	@GetMapping("/")
	public String showHome() {
		
		return "home";
	}
	
	@GetMapping("/hello")
	public String showForm() {
		return "home_login";
		
	}
}

