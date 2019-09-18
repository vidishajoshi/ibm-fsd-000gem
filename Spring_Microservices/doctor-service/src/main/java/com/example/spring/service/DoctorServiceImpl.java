package com.example.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.data.Doctor;
import com.example.spring.data.DoctorRepo;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired DoctorRepo doctorRepo;

	@Override
	public List<Doctor> getAllDoctor(String special) {
		List<Doctor> list=doctorRepo.findBySpecial(special);
		return list;
	}
	

}
