package com.example.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.spring.domain.Doctor;
import com.example.spring.dto.DoctorClient;
import com.example.spring.dto.PatientClient;
import com.example.spring.model.DoctorResponseModel;
import com.example.spring.model.PatientResponseModel;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class CommonServiceImpl implements CommonService {

	@Autowired DoctorClient doctorClient;
	@Autowired PatientClient patientClient;
	
	@Override
	@HystrixCommand(fallbackMethod="getFallbackDoctor")
	public List<ResponseEntity<DoctorResponseModel>> getDoctor(String special) {
		List<ResponseEntity<DoctorResponseModel>> list=doctorClient.getDoctor(special);
		return list;
	}
	
	public String getFallbackDoctor() {
		return "oops! Doctor";
	}

	@Override
	@HystrixCommand(fallbackMethod="getFallbackPatient")
	public List<ResponseEntity<PatientResponseModel>> getPatient(String special) {
		List<ResponseEntity<PatientResponseModel>> list=patientClient.getPatient(special);
		return list;
	}


	public String getFallbackPatient() {
		return "oops! Patient";
	}
}
