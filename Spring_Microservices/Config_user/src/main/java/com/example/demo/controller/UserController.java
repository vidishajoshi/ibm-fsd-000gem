package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.UserDetails;
import com.example.demo.dto.UserDetailsDto;
import com.example.demo.model.CreateUserRequestModel;
import com.example.demo.model.CreateUserResponseModel;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/users")
	public ResponseEntity<CreateUserResponseModel> create(@RequestBody CreateUserRequestModel user)
	{
		ModelMapper mapper=new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		UserDetailsDto uDto=mapper.map(user, UserDetailsDto.class);
		
		UserDetailsDto tempDto=userService.createUser(uDto);
		CreateUserResponseModel model=mapper.map(tempDto, CreateUserResponseModel.class);;
		return ResponseEntity.status(HttpStatus.CREATED).body(model);

	}
	@GetMapping("/users")
	public List<ResponseEntity<CreateUserResponseModel>> find(){
		List<UserDetails> list = userService.finduser();
		ModelMapper mapper = new ModelMapper();
		List<ResponseEntity<CreateUserResponseModel>> listResponse = new ArrayList<ResponseEntity<CreateUserResponseModel>>();
		for(UserDetails u : list) {
			CreateUserResponseModel cr = mapper.map(u, CreateUserResponseModel.class);
			listResponse.add(ResponseEntity.status(HttpStatus.CREATED).body(cr));
		}
		return listResponse;
		
	}
	
	@SuppressWarnings("rawtypes")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseMessage> delete(@PathVariable("id") Integer id){
		userService.deleteUser(id);
		ResponseMessage rs = new ResponseMessage("Delete completed!",200l);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(rs);
		
	}
	
	@GetMapping("/getUser/{id}")
	public ResponseEntity<CreateUserResponseModel> findUserById(@PathVariable("id") Integer id){
	     UserDetails ud=userService.findUserById(id);
	     ModelMapper mapper=new ModelMapper();
	     CreateUserResponseModel cr=mapper.map(ud,CreateUserResponseModel.class);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(cr);
	}
   
	
	@GetMapping("/getUserByname/{fname}")
	public List<ResponseEntity<CreateUserResponseModel>> findUserByName(@PathVariable("fname") String fname){
		java.util.List<UserDetails> list= userService.findUserByfname(fname);
		ModelMapper mapper = new ModelMapper();
		List<ResponseEntity<CreateUserResponseModel>> listRes = new ArrayList<ResponseEntity<CreateUserResponseModel>>();
		for(UserDetails u : list) {
			CreateUserResponseModel cr = mapper.map(u, CreateUserResponseModel.class);
			listRes.add(ResponseEntity.status(HttpStatus.CREATED).body(cr));
		}
		return listRes;
	}
	
	@GetMapping("/getUserBylname/{lname}")
	public List<ResponseEntity<CreateUserResponseModel>> findUserByLName(@PathVariable("lname") String lname){
		java.util.List<UserDetails> list= userService.findUserBylname(lname);
		ModelMapper mapper = new ModelMapper();
		List<ResponseEntity<CreateUserResponseModel>> listRes = new ArrayList<ResponseEntity<CreateUserResponseModel>>();
		for(UserDetails u : list) {
			CreateUserResponseModel cr = mapper.map(u, CreateUserResponseModel.class);
			listRes.add(ResponseEntity.status(HttpStatus.CREATED).body(cr));
		}
		return listRes;
	}
	
	@GetMapping("/getUserByemail/{email}")
	public List<ResponseEntity<CreateUserResponseModel>> findUserByEmail(@PathVariable("email") String email){
		java.util.List<UserDetails> list= userService.findUserByemail(email);
		ModelMapper mapper = new ModelMapper();
		List<ResponseEntity<CreateUserResponseModel>> listRes = new ArrayList<ResponseEntity<CreateUserResponseModel>>();
		for(UserDetails u : list) {
			CreateUserResponseModel cr = mapper.map(u, CreateUserResponseModel.class);
			listRes.add(ResponseEntity.status(HttpStatus.CREATED).body(cr));
		}
		return listRes;
	}
	


}

   