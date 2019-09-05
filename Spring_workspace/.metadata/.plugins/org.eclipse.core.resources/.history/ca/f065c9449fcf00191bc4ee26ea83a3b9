package bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component(value="employeeService")
public class EmployeeService {
	@Autowired
	private JdbcTemplate jdbc;
	private String query;
	
	public void createEmployee(Employee emp) {
		query="insert into employee(fname,lname,email) values(?,?,?)";
		Object[] obj= {emp.getFname(),emp.getLname(),emp.getEmail()};
		jdbc.update(query,obj);
		System.out.println("Employee added!!");
		
	}
	public void getEmployeeById(int id) {
		
	}
	public void deleteEmployee(int id) {
		query="delete from employee where id=?";
		Object[] obj= {id};
		jdbc.update(query,obj);
		System.out.println("Employee deleted!!");
	}

}
