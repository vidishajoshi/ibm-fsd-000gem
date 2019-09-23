package com.example.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.dto.CreatePlayerRequest;
import com.example.spring.service.CommonService;

@Controller
@RequestMapping("/player")
public class PlayerController {
	
	@Autowired CommonService commonService;
	
	@GetMapping("/")
	public String goHome() {
		return "pservice/home";
	}
	
	@GetMapping("/view")
	public String getAllPlayers(Model theModel){
		List<?> list= commonService.getPlayers();
		theModel.addAttribute("player", list);
	return "pservice/showPlayer";	
	}
	
	
	@PostMapping("/adding")
	public ResponseEntity<?> createPlayer(@RequestBody CreatePlayerRequest ce){
		return commonService.addPlayer(ce);
	}
	

}
