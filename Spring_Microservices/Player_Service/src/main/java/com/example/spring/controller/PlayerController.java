package com.example.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.data.Player;
import com.example.spring.dto.PlayerDto;
import com.example.spring.model.CreatePlayerRequest;
import com.example.spring.model.CreatePlayerResponse;
import com.example.spring.service.PlayerService;

@RestController
@RequestMapping("/")
public class PlayerController {

	
	@Autowired
	private PlayerService service;
	
	@PostMapping("/addplayer")
	public ResponseEntity<CreatePlayerResponse> create(@RequestBody CreatePlayerRequest user)
	{
		ModelMapper mapper=new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		PlayerDto uDto=mapper.map(user, PlayerDto.class);
		
		PlayerDto tempDto=service.createPlayer(uDto);
		CreatePlayerResponse model=mapper.map(tempDto, CreatePlayerResponse.class);;
		return ResponseEntity.status(HttpStatus.CREATED).body(model);

	}
	@GetMapping("/players")
	public List<ResponseEntity<CreatePlayerResponse>> find(){
		List<Player> list = service.findPlayer();
		ModelMapper mapper = new ModelMapper();
		List<ResponseEntity<CreatePlayerResponse>> listResponse = new ArrayList<ResponseEntity<CreatePlayerResponse>>();
		for(Player u : list) {
			CreatePlayerResponse cr = mapper.map(u, CreatePlayerResponse.class);
			listResponse.add(ResponseEntity.status(HttpStatus.CREATED).body(cr));
		}
		return listResponse;
		
	}
	
	@SuppressWarnings("rawtypes")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseMessage> delete(@PathVariable("id") Integer id){
		service.deletePlayer(id);
		ResponseMessage rs = new ResponseMessage("Delete completed!",200l);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(rs);
		
	}
}
