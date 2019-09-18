package com.example.spring.service;

import java.util.List;

import com.example.spring.data.Doctor;

public interface DoctorService {

	public List<Doctor> getAllDoctor(String special);
}
