package com.example.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.dto.PatientClient;

import com.example.spring.model.PatientResponseModel;
import com.example.spring.service.CommonService;

@RestController
public class PatientController {
	
	@Autowired CommonService commonService;
	
	@GetMapping("/getpatient/{disease}")
	public List<?> getPatient(@PathVariable("disease") String special){
		return commonService.getPatient(special);
		
		
		
	}

}
