package src.comm.example.dao;

import java.util.List;

import src.comm.example.model.Employee;

public interface EmployeeDao {
	
	public void createEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(int id);
	public void getConnectionInfo();
	public void deletebyid(int id);


}
