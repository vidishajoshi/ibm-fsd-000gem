package com.example.spring.dao;

import java.util.List;

import com.example.spring.model.*;;

public interface EmployeeDao {
	public void createEmployee(Employee emp);
	public List<Employee> viewEmployee();
	public void deleteIEmployee(int id);
	public Employee getEmployee(int id);
	public void update( Employee emp);
}
