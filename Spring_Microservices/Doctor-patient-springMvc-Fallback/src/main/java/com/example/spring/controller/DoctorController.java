package com.example.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.model.DoctorResponseModel;
import com.example.spring.service.CommonService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.spring.dto.DoctorClient;

@RestController
public class DoctorController {

	@Autowired CommonService commonService;
	
	@GetMapping("/getdoctor/{special}")
	public List<?> getDoctor(@PathVariable("special") String special){
		List<?> list= commonService.getDoctor(special);
		return list;
		
	}
}
