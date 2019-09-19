package com.example.spring.dto;

public class CreatePlayerRequest {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String league_name;
	public CreatePlayerRequest() {
		super();
	}
	public CreatePlayerRequest(String firstName, String lastName, String email, String password, String league_name) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLeague_name() {
		return league_name;
	}
	public void setLeague_name(String league_name) {
		this.league_name = league_name;
	}
	
	
	

}
