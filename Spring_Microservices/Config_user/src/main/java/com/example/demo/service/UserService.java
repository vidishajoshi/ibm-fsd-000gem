package com.example.demo.service;

import java.util.List;

import com.example.demo.data.UserDetails;
import com.example.demo.dto.UserDetailsDto;

public interface UserService {

	public UserDetailsDto createUser(UserDetailsDto user);

	List<UserDetails> finduser();

	void deleteUser(Integer id);
	
	public UserDetails findUserById(Integer id);

	public java.util.List<UserDetails> findUserByfname(String name);
	
}
