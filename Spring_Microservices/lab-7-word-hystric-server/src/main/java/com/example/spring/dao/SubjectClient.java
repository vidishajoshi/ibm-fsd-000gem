package com.example.spring.dao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.spring.domain.Word;

@FeignClient("SUBJECT")
public interface SubjectClient {

	@GetMapping("/")
	Word getWord();
	
}