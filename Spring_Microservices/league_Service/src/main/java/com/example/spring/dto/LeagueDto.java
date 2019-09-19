package com.example.spring.dto;

public class LeagueDto {

	
	private String leagueName;
	private String season;
	private String year;
	public LeagueDto() {
		super();
	}
	public LeagueDto(String leagueName, String season, String year) {
		super();
		this.leagueName = leagueName;
		this.season = season;
		this.year = year;
	}
	
	public String getLeagueName() {
		return leagueName;
	}
	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
}
