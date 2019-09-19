package com.example.spring.data;

import javax.persistence.*;

@Entity
@Table(name="league_table")
public class League {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="league_name")
	private String leagueName;
	@Column(name="season")
	private String season;
	@Column(name="year")
	private String year;
	public League() {
		super();
	}
	public League(String leagueName, String season, String year) {
		super();
		this.leagueName = leagueName;
		this.season = season;
		this.year = year;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
