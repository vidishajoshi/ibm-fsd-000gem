package com.example.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.spring.dto.PatientClient;

import com.example.spring.model.PatientResponseModel;
import com.example.spring.service.CommonService;

@Controller
public class PatientController {
	
	@Autowired CommonService commonService;
	
	@GetMapping("/getpatient/{disease}")
	public List<PatientResponseModel> getDoctor(@PathVariable("disease") String special){
		List<ResponseEntity<PatientResponseModel>> list= new ArrayList<ResponseEntity<PatientResponseModel>>();
		list=commonService.getPatient(special);
		List<PatientResponseModel> listR=new ArrayList<PatientResponseModel>();
		ModelMapper mapper=new ModelMapper();
		for(ResponseEntity<PatientResponseModel> u: list) {
			PatientResponseModel d= mapper.map(u,PatientResponseModel.class);
			listR.add(d);
			
		}
		return listR ;
		
	}

}
