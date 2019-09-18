package com.example.spring.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.spring.model.DoctorResponseModel;
import com.example.spring.model.PatientResponseModel;

public interface CommonService {

	 public List<ResponseEntity<DoctorResponseModel>> getDoctor(String special);

	 public List<ResponseEntity<PatientResponseModel>> getPatient( String special);
}
