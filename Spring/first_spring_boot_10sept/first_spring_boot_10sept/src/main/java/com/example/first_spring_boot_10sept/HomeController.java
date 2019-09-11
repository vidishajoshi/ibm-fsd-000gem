package com.example.first_spring_boot_10sept;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	
	@Autowired
	StudentDao dao;
	
	@RequestMapping("/welcome")
	public String goHome() {
		
		return "Welcome to spring boot";
		
		
	}
	
	@PostMapping("/create")
	public String createApplicant(@RequestBody Applicant applicant) {
		System.out.println(applicant.toString());
		dao.createApplicant(applicant);
		System.out.println("applicant added");
		return "done";
		
	}
	
	@GetMapping("/view")
	public List<Applicant> getApplicant() {
        List<Applicant> list=dao.getApplicants();
        
		return list;
		
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteApp(@PathVariable("id") int id) {
		dao.deleteApplicant(id);
		return "delete done";
	}
	
	@RequestMapping("/get/{id}")
	public Applicant getApplicantById(@PathVariable("id") int id) {
		Applicant app=dao.getApplicantById(id);
		return app;
		
	}
}
