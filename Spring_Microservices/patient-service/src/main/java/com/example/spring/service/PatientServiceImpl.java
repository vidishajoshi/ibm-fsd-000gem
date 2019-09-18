package com.example.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.data.Patient;
import com.example.spring.data.PatientRepo;


@Service
public class PatientServiceImpl implements PatientService {


	@Autowired
	private PatientRepo patientRepo;

	@Override
	public List<Patient> getAllPatient(String disease) {
		List<Patient> pd=patientRepo.findByDisease(disease);
		return pd;
	}

}
