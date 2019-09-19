package com.example.spring.controller;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.data.Doctor;
import com.example.spring.model.DoctorResponseModel;
import com.example.spring.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
	@Autowired DoctorService doctorService;
	
	@GetMapping("/getD/{special}")
	public java.util.List<ResponseEntity<DoctorResponseModel>> getDoctor(@PathVariable("special") String special){
		java.util.List<Doctor> list=doctorService.getAllDoctor(special);
		ModelMapper mapper=new ModelMapper();
		java.util.List<ResponseEntity<DoctorResponseModel>> responseList=new ArrayList<ResponseEntity<DoctorResponseModel>>();
		for(Doctor d:list) {
			DoctorResponseModel dm=mapper.map(d,DoctorResponseModel.class);
			responseList.add(ResponseEntity.status(HttpStatus.CREATED).body(dm));
		}
		return responseList;
	
		
	}
}
