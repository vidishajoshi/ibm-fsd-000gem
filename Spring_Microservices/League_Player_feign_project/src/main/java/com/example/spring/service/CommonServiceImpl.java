package com.example.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.spring.dto.CreateLeagueRequestModel;
import com.example.spring.dto.CreatePlayerRequest;
import com.example.spring.dto.LeagueClient;
import com.example.spring.dto.PlayerClient;

@Service
public class CommonServiceImpl implements CommonService {

	@Autowired PlayerClient playerClient;
	@Autowired LeagueClient leagueClient;
	
	@Override
	public List<?> getPlayers() {
		
		return playerClient.find();
	}

	@Override
	public List<?> getLeagues() {
		return leagueClient.find();
	}

	@Override
	public ResponseEntity<?> addPlayer(CreatePlayerRequest cr) {
	
		return playerClient.create(cr);
	}

	@Override
	public ResponseEntity<?> addLeague(CreateLeagueRequestModel cr) {
		return leagueClient.create(cr);
	}

}
