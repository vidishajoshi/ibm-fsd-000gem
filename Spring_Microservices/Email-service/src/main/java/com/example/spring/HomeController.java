package com.example.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class HomeController {

	@Autowired EmailService emailService;
	
	@PostMapping("/sendEmail")
	public String sendMailing(@RequestBody Email email) {
		String to=email.getTo();
		String subject=email.getSubject();
		String text=email.getText();
		emailService.sendSimpleMessage(to, subject, text);
		return "Mail sent";
	}
	
}
