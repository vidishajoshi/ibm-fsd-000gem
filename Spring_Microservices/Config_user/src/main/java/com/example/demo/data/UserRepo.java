package com.example.demo.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserDetails, Integer> {

	public List<UserDetails> findByFname(String fname);
	public List<UserDetails> findByLname(String lname);
	public List<UserDetails> findByEmail(String email);
}
