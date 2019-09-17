package com.example.spring.service;

import java.util.List;

import com.example.spring.model.Employee;

public interface EmployeeService {
	public void createEmployee(Employee emp);
	public List<Employee> viewEmployee();
	public void deleteIEmployee(int id);
	public Employee getEmployee(int id);
	public void update( Employee emp);
}
