package com.example.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/kj")
	public String showHome() {
		return "home";
	}
	
	@RequestMapping("/")
	 public String handler(ModelMap model, HttpServletRequest request) {
	        Authentication auth = SecurityContextHolder.getContext()
	                                                   .getAuthentication();
	        model.addAttribute("uri", request.getRequestURI());
	        model.addAttribute("user", auth.getName());
	        model.addAttribute("roles", auth.getAuthorities());
	        return "home";
	    }
	
}
