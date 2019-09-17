package com.example.spring.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.dao.EmployeeDao;
import com.example.spring.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeDao ed;
	@Override
	public void createEmployee(Employee emp) {
		
		
	}

	@Override
	public List<Employee> viewEmployee() {
		List<Employee> list=ed.viewEmployee();
		return list;
	}

	@Override
	public void deleteIEmployee(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee getEmployee(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Employee emp) {
		// TODO Auto-generated method stub
		
	}

	
}
