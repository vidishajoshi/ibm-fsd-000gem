package com.example.spring.service;

import java.util.List;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.spring.dto.CreateLeagueRequestModel;
import com.example.spring.dto.CreatePlayerRequest;

public interface CommonService {
	 public List<?> getPlayers();

	 public List<?> getLeagues();
	 
	 public ResponseEntity<?> addPlayer(@RequestBody CreatePlayerRequest cr);
	 
	 public ResponseEntity<?> addLeague(@RequestBody CreateLeagueRequestModel cr);
}
