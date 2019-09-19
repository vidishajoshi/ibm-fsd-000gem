package com.example.spring.dto;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.spring.domain.Doctor;
import com.example.spring.model.DoctorResponseModel;

@FeignClient("doctor-service")
public interface DoctorClient {

	@GetMapping("/doctor/getD/{special}")
	public List<?> getDoctor(@PathVariable("special") String special);
}
