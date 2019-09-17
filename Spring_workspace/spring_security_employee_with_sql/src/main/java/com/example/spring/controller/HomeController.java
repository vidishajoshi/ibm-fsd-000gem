package com.example.spring.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.spring.model.*;
import java.util.*;
import com.example.spring.service.EmployeeService;

@Controller
public class HomeController {

	@Autowired
	EmployeeService es;
	
	@RequestMapping("/")
	public String tryAuthenticate(ModelMap theModel, HttpServletRequest request) {
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		theModel.addAttribute("uri",request.getRequestURI());
		theModel.addAttribute("user", auth.getName());
		theModel.addAttribute("roles",auth.getAuthorities());
		
		return "home";
		
	}
	
	@RequestMapping("/view")
	public String viewEmployee(Model theModel) {
		List<Employee> list=new ArrayList<Employee>();
		list=es.viewEmployee();
		theModel.addAttribute("emp", list);
		return "list_employee";
		
	}
	
	
    public String addSaveEmployee(Model theMap) {
		return "view";
    	
    }
}
