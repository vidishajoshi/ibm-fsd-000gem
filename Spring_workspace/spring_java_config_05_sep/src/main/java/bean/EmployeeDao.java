package bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value="employeeDao")
public class EmployeeDao {
	@Autowired
	private MyJdbcTemplate jdbc1;
	
	private String query;
	
	
	
	
	
	public MyJdbcTemplate getJdbc1() {
		return jdbc1;
	}
	public void setJdbc1(MyJdbcTemplate jdbc1) {
		this.jdbc1 = jdbc1;
	}
	public void createEmployee(Employee emp) {
		query="insert into employee(fname,lname,email) values(?,?,?)";
		Object[] obj= {emp.getFname(),emp.getLname(),emp.getEmail()};
		jdbc1.update(query,obj);
		System.out.println("Employee added!!");
		
	}
	public void getEmployeeById(int id) {
		
	}
	public void deleteEmployee(int id) {
		query="delete from employee where id=?";
		Object[] obj= {id};
		jdbc1.update(query,obj);
		System.out.println("Employee deleted!!");
	}
	
	
}