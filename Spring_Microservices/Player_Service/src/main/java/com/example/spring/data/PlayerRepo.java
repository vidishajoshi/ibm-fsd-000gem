package com.example.spring.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepo extends JpaRepository<Player, Integer> {

	public List<Player> findByFirstName(String fname);
	public List<Player> findByLastName(String lname);
	public List<Player> findByEmail(String email);
}
