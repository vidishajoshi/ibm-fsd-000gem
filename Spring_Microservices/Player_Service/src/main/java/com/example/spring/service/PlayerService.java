package com.example.spring.service;

import java.util.List;

import com.example.spring.data.Player;
import com.example.spring.dto.PlayerDto;

public interface PlayerService {
	
	public PlayerDto createPlayer(PlayerDto player);

	List<Player> findPlayer();

	void deletePlayer(Integer id);
	
	public Player findUserById(Integer id);

	public java.util.List<Player> findByfirstName(String name);
	
	public java.util.List<Player> findBylastName(String name);
	
	

}
