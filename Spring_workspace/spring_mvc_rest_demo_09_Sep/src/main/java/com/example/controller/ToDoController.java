package com.example.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.ToDo;

@RestController
@RequestMapping("/api")
public class ToDoController {

	private List<ToDo> list =null;
	
	@PostConstruct
	public void createList() {
		list=new ArrayList<ToDo>();
	}
	@GetMapping("/todos")
	public List<ToDo> getAllToDo(){
		list.add(new ToDo("Practice spring core",new Date()));
		list.add(new ToDo("learn spring",new Date()));
		return list;
	}
	
}
