package com.example.spring.service;

import java.util.ArrayList;
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
	public List<?> getDoctor(String special) {
		List<?> list=doctorClient.getDoctor(special);
		return list;
	}
	
	public String getFallbackDoctor(String special) {
		return "oops! Doctor"+special;
	}

	@Override
	@HystrixCommand(fallbackMethod="getFallbackPatient")
	public List<?> getPatient(String special) {
		List<?> list=patientClient.getPatient(special);
		return list;
	}


	public List<?> getFallbackPatient(String special) {
		List<String> list = new ArrayList<String>();
		list.add(" dsd");
		return list;
	}
}
