package com.example.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.data.Patient;
import com.example.spring.dto.PatientDto;
import com.example.spring.model.PatientRequestModel;
import com.example.spring.model.PatientResponseModel;
import com.example.spring.service.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private PatientService patientService;
	
	@GetMapping("/get/{disease}")
	public List<ResponseEntity<PatientResponseModel>> getPatient(@PathVariable("disease") String disease){
		java.util.List<Patient> pDto=patientService.getAllPatient(disease);
		ModelMapper mapper = new ModelMapper();
		java.util.List<ResponseEntity<PatientResponseModel>> listResponse=new ArrayList<ResponseEntity<PatientResponseModel>>();
		for(Patient u : pDto) {
			PatientResponseModel cr = mapper.map(u, PatientResponseModel.class);
			listResponse.add(ResponseEntity.status(HttpStatus.CREATED).body(cr));
		}
		return listResponse;
		
	}
}
