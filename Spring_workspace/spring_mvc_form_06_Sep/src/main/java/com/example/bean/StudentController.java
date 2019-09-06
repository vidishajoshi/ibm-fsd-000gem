package com.example.bean;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/student")
public class StudentController {

	@GetMapping("/")
	public String viewPage() {
		return "index";
	}
	
	@RequestMapping("/showView")
	public String goForward(Model theModel)
	{
		Student student=new Student();
		theModel.addAttribute("student",student);
		return "student_form";
	}
	
	@RequestMapping("/showViewDisplay")
	public String goForwardDisplay(Model theModel) {
		Student student=new Student();
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(StudentConfig.class);
	      StudentDao dao= context.getBean("studentDao",StudentDao.class);
		List<Student> list=new ArrayList<Student>();
		list=dao.getAllStudent();
		theModel.addAttribute("student",list);
		return "student_disp";
		
	}
	@RequestMapping("/searchView")
	public String goSearch() {
		
		return "search_student";
		
	}
	
	@RequestMapping("/searchProcess")
	public String processSearch(@RequestParam("data") String text,@RequestParam("but") String type, Model theModel) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(StudentConfig.class);
	      StudentDao dao= context.getBean("studentDao",StudentDao.class);
	      List<Student> st=new ArrayList<Student>();
	      st=dao.searchStudent(text, type);
	      theModel.addAttribute("student",st);
		
		return "display_search";
	}
	@PostMapping("/processForm")
	public String processPage(@ModelAttribute("student") Student theStudent,Model theModel) {
		theModel.addAttribute("tempStudent",theStudent);
		 AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(StudentConfig.class);
	      StudentDao dao= context.getBean("studentDao",StudentDao.class);
	      dao.createStudent(theStudent);
		return "hello_world";
	}
}
 