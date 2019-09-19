package com.example.spring.model;

public class CreateLeagueResponseModel {

	private String leagueName;
	private String season;
	private String year;
	public CreateLeagueResponseModel(String leagueName, String season, String year) {
		super();
		this.leagueName = leagueName;
		this.season = season;
		this.year = year;
	}
	public CreateLeagueResponseModel() {
		super();
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
