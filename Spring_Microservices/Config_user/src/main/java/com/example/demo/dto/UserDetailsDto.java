package com.example.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDetailsDto {

	private String fname;
	private String lname;
	private String email;
	private String password;
	private String uId;
	private String bCryptpassword;
	public String getuId() {
		return uId;
	}
	
	
	
	public UserDetailsDto() {
		super();
	}



	public UserDetailsDto(String fname, String lname, String email, String password) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
	}


	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
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
	public String getbCryptpassword() {
		return bCryptpassword;
	}
	public void setbCryptpassword(String bCryptpassword) {
		this.bCryptpassword = bCryptpassword;
	}
	
	
	

	}
