package com.example.spring.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.dto.PatientDto;

@Repository
public interface PatientRepo extends JpaRepository<Patient,Integer> {

	public List<Patient> findByDisease(String disease);
}
