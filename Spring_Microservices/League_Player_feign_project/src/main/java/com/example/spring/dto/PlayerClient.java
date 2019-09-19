package com.example.spring.dto;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@FeignClient("player-service")
public interface PlayerClient {
	
	@GetMapping("/players")
	public List<?> find();
	
	@PostMapping("/addplayer")
	public ResponseEntity<?> create(@RequestBody CreatePlayerRequest cr);

}
