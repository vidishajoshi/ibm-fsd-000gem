package com.example.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.data.League;

import com.example.spring.dto.LeagueDto;
import com.example.spring.model.CreateLeagueRequestModel;
import com.example.spring.model.CreateLeagueResponseModel;

import com.example.spring.service.LeagueService;

@RestController
@RequestMapping("/")
public class LeagueController {

	@Autowired
	LeagueService service;
	
	@PostMapping("/addleague")
	public ResponseEntity<CreateLeagueResponseModel> create(@RequestBody CreateLeagueRequestModel user)
	{
		ModelMapper mapper=new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		LeagueDto uDto=mapper.map(user, LeagueDto.class);
		
	    LeagueDto tempDto=service.createLeague(uDto);
		CreateLeagueResponseModel model=mapper.map(tempDto, CreateLeagueResponseModel.class);;
		return ResponseEntity.status(HttpStatus.CREATED).body(model);

	}
	@GetMapping("/leagues")
	public List<ResponseEntity<CreateLeagueResponseModel>> find(){
		List<League> list = service.getAllLeague();
		ModelMapper mapper = new ModelMapper();
		List<ResponseEntity<CreateLeagueResponseModel>> listResponse = new ArrayList<ResponseEntity<CreateLeagueResponseModel>>();
		for(League u : list) {
			CreateLeagueResponseModel cr = mapper.map(u, CreateLeagueResponseModel.class);
			listResponse.add(ResponseEntity.status(HttpStatus.CREATED).body(cr));
		}
		return listResponse;
		
	}
	
	
}
