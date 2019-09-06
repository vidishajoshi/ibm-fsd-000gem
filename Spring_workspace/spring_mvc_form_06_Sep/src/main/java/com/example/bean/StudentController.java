package com.example.bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



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
	
	@PostMapping("/processForm")
	public String processPage(@ModelAttribute("student") Student theStudent,Model theModel) {
		theModel.addAttribute("tempStudent",theStudent);
		 AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(StudentConfig.class);
	      StudentDao dao= context.getBean("studentDao",StudentDao.class);
	      dao.createStudent(theStudent);
		return "hello_world";
	}
}
 