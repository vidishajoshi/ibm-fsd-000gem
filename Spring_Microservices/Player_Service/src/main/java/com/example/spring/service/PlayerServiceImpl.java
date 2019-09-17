package com.example.spring.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.spring.data.Player;
import com.example.spring.data.PlayerRepo;
import com.example.spring.dto.PlayerDto;

@Service
public class PlayerServiceImpl implements PlayerService {
	private Environment env;
	private PlayerRepo playerRepo;
	

	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	public PlayerServiceImpl(Environment env,PlayerRepo playerRepo ,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		super();
		this.env = env;
		this.playerRepo=playerRepo;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	public PlayerDto createPlayer(PlayerDto user) {
		// TODO Auto-generated method stub
		user.setPlayer_id(UUID.randomUUID().toString());
		String bPass=bCryptPasswordEncoder.encode(user.getPassword());
		user.setbCryptpassword(bCryptPasswordEncoder.encode(user.getPassword()));
		ModelMapper mapper=new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		Player userEntity=mapper.map(user, Player.class);
		user.setPassword(user.getbCryptpassword());
		playerRepo.save(userEntity);
		PlayerDto uDto=mapper.map(user, PlayerDto.class);
		
		return uDto;
	}

	@Override
	public java.util.List<Player> findPlayer(){
		java.util.List<Player> users =playerRepo.findAll();
		return users;
	}
	
	@Override
	public void deletePlayer(Integer id) {
		Player user= new Player();
		Optional<Player> u=playerRepo.findById(id);
		
		if(u.isPresent()==true) {
			user=u.get();
		}else {
			System.out.println("result is not present");
		}
		playerRepo.delete(user);
	
	
	}

	@Override
	public Player findUserById(Integer id) {
		Player ud=new Player();
		Optional<Player> list=playerRepo.findById(id);
		if(list.isPresent()==true) {
		ud=list.get();		}
		else {
			System.out.println("result is not persent");
		}		return ud;
	}

	@Override
	public java.util.List<Player> findByfirstName(String name) {
		java.util.List<Player> ud=playerRepo.findByFirstName(name);
		return ud;
}

	@Override
	public java.util.List<Player> findBylastName(String name) {
		java.util.List<Player> ud=playerRepo.findByLastName(name);
		return ud;
	}


	
}        