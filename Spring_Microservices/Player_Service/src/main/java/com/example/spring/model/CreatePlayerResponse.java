package com.example.spring.model;

public class CreatePlayerResponse {

	private String firstName;
	private String lastName;
	private String email;
	private String player_id;
	private String league_name;
	public CreatePlayerResponse() {
		super();
	}
	public CreatePlayerResponse(String firstName, String lastName, String email, String player_id, String league_name) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.player_id = player_id;
		this.league_name = league_name;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPlayer_id() {
		return player_id;
	}
	public void setPlayer_id(String player_id) {
		this.player_id = player_id;
	}
	public String getLeague_name() {
		return league_name;
	}
	public void setLeague_name(String league_name) {
		this.league_name = league_name;
	}


	

}
