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

import com.example.spring.dto.CreateLeagueRequestModel;
import com.example.spring.service.CommonService;

@RestController
@RequestMapping("/league")
public class LeagueController {

	@Autowired CommonService commonService;
	
	@GetMapping("/view")
	public List<?> getAllLeagues(){
		return commonService.getLeagues();
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addLeague(@RequestBody CreateLeagueRequestModel cr){
		return commonService.addLeague(cr);
	}
}
