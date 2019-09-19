package com.example.spring.service;

import java.util.List;

import com.example.spring.data.League;
import com.example.spring.dto.LeagueDto;

public interface LeagueService {

	public LeagueDto createLeague(LeagueDto l);
	public List<League> getAllLeague();
}
