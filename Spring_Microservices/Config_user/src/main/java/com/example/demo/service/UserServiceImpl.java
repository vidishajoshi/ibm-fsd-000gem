package com.example.demo.service;

import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.data.UserDetails;
import com.example.demo.data.UserRepo;
import com.example.demo.dto.UserDetailsDto;
import com.sun.xml.bind.v2.schemagen.xmlschema.List;


@Service
public class UserServiceImpl implements UserService {
	
	private Environment env;
	private UserRepo userRepo;

	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	public UserServiceImpl(Environment env, UserRepo userRepo,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		super();
		this.env = env;
		this.userRepo = userRepo;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	public UserDetailsDto createUser(UserDetailsDto user) {
		// TODO Auto-generated method stub
		user.setuId(UUID.randomUUID().toString());
		String bPass=bCryptPasswordEncoder.encode(user.getPassword());
		user.setbCryptpassword(bCryptPasswordEncoder.encode(user.getPassword()));
		ModelMapper mapper=new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		UserDetails userEntity=mapper.map(user, UserDetails.class);
		user.setPassword(user.getbCryptpassword());
		userRepo.save(userEntity);
		UserDetailsDto uDto=mapper.map(user, UserDetailsDto.class);
		
		return uDto;
	}

	@Override
	public java.util.List<UserDetails> finduser(){
		java.util.List<UserDetails> users = userRepo.findAll();
		return users;
	}
	
	@Override
	public void deleteUser(Integer id) {
		UserDetails user= new UserDetails();
		Optional<UserDetails> u=userRepo.findById(id);
		
		if(u.isPresent()==true) {
			user=u.get();
		}else {
			System.out.println("result is not present");
		}
		userRepo.delete(user);
	
	
	}

	@Override
	public UserDetails findUserById(Integer id) {
		UserDetails ud=new UserDetails();
		Optional<UserDetails> list=userRepo.findById(id);
		if(list.isPresent()==true) {
			ud=list.get();
		}
		else {
			System.out.println("result is not persent");
		}
		return ud;
	}

	@Override
	public java.util.List<UserDetails> findUserByfname(String name) {
		java.util.List<UserDetails> ud=userRepo.findByFname(name);
		return ud;
	}
	
}
