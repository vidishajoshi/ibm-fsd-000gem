package com.example.spring.demo;


import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.spring.controller.ResponseMessage;
import com.example.spring.data.Player;
import com.example.spring.dto.PlayerDto;
import com.example.spring.model.CreatePlayerRequest;
import com.example.spring.model.CreatePlayerResponse;

@FeignClient(name="player-service")
public interface PlayerServiceClient {
	
	@RequestMapping(value="/addplayer", method=RequestMethod.POST)
	public void create(@RequestBody CreatePlayerRequest user);
	
	@RequestMapping(value="/players", method=RequestMethod.GET)
	public List<?> findPlayer();
		
		
	}


