package com.example.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.spring.model.DoctorResponseModel;
import com.example.spring.service.CommonService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.spring.dto.DoctorClient;

@Controller
public class DoctorController {

	@Autowired CommonService commonService;
	
	@GetMapping("/getdoctor/{special}")
	public List<DoctorResponseModel> getDoctor(@PathVariable("special") String special){
		List<ResponseEntity<DoctorResponseModel>> list= new ArrayList<ResponseEntity<DoctorResponseModel>>();
		list=commonService.getDoctor(special);
		List<DoctorResponseModel> listR=new ArrayList<DoctorResponseModel>();
		ModelMapper mapper=new ModelMapper();
		for(ResponseEntity<DoctorResponseModel> u: list) {
			DoctorResponseModel d= mapper.map(u,DoctorResponseModel.class);
			listR.add(d);
			
		}
		return listR ;
		
	}
}
