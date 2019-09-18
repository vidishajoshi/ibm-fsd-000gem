package com.example.spring.dto;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import com.example.spring.model.PatientResponseModel;

@FeignClient("patient-service")
public interface PatientClient {
	
	@GetMapping("/patient/get/{disease}")
	public List<ResponseEntity<PatientResponseModel>> getPatient(@PathVariable("disease") String special);

}
