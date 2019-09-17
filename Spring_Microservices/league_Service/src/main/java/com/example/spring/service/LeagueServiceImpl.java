package com.example.spring.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.example.spring.data.League;
import com.example.spring.data.LeagueRepo;

import com.example.spring.dto.LeagueDto;

@Service
public class LeagueServiceImpl implements LeagueService{

	private Environment env;
	private LeagueRepo leagueRepo;
	
	@Autowired
	public LeagueServiceImpl(Environment env, LeagueRepo leagueRepo) {
		super();
		this.env = env;
		this.leagueRepo = leagueRepo;
	}

	@Override
	public LeagueDto createLeague(LeagueDto l) {
		ModelMapper mapper=new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		League userEntity=mapper.map(l, League.class);
		leagueRepo.save(userEntity);
		LeagueDto uDto=mapper.map(l, LeagueDto.class);
		return uDto;
		
	}

	@Override
	public List<League> getAllLeague() {
		java.util.List<League> users =leagueRepo.findAll();
		return users;
	}

}
