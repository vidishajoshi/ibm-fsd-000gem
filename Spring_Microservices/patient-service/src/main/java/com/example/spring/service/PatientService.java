package com.example.spring.service;

import java.util.List;

import com.example.spring.data.Patient;


public interface PatientService {

	public List<Patient> getAllPatient(String disease);
	
}
