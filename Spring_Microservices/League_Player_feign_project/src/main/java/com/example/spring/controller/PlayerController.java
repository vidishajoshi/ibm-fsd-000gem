package com.example.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.dto.CreatePlayerRequest;
import com.example.spring.service.CommonService;

@RestController
@RequestMapping("/player")
public class PlayerController {
	
	@Autowired CommonService commonService;
	
	@GetMapping("/view")
	public List<?> getAllPlayers(){
		return commonService.getPlayers();
	}
	
	
	@PostMapping("/adding")
	public ResponseEntity<?> createPlayer(@RequestBody CreatePlayerRequest ce){
		return commonService.addPlayer(ce);
	}
	

}
