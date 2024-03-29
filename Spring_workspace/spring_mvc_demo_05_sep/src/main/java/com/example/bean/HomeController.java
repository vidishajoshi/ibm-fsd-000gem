package com.example.bean;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class HomeController {
	@RequestMapping("/")
	public String goHome()
	{
		return "main_menu";
	}
	
	@RequestMapping("/showView")
	public String goForward()
	{
		return "student_form";
	}

	
	@RequestMapping("/processForm")
	public String studentProcess() {
		return "hello_world";
	}
	
	@RequestMapping("/processFormVersionTwo")
	public String processStudentFormVersionTwo(HttpServletRequest request,
			Model theModel)
	
	{
	String fname=request.getParameter("fname");
	String lname=request.getParameter("lname");
	String email=request.getParameter("email");
	Student student=new Student(fname,lname,email);
	theModel.addAttribute("student_value", student);
	return "hello_world";
			}
	
	
	
	@RequestMapping( "/processFormVersionThree")
	public String processStudentFormVersionThree(@RequestParam("studentName") String studentName,
			Model theModel)
	
	{
		String message="Yo!!"+(studentName.toUpperCase());
theModel.addAttribute("M", message);
		return "hello-world";
	}
}
