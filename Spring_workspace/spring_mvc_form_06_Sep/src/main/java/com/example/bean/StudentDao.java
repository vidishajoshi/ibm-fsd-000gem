package com.example.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.bean.*;
import com.example.bean.connection.*;
@Component(value="studentDao")
public class StudentDao {
	

		@Autowired
		private MyJdbcTemplate jdbc1;
		
		private String query;
		
		
		public MyJdbcTemplate getJdbc1() {
			return jdbc1;
		}
		public void setJdbc1(MyJdbcTemplate jdbc1) {
			this.jdbc1 = jdbc1;
		}
		public void createStudent(Student emp) {
			query="insert into student(fname,lname,email,country,lang,os) values(?,?,?,?,?,?)";
			Object[] obj= {emp.getFname(),emp.getLname(),emp.getEmail(),emp.getCountry(),emp.getLang(),emp.getOs()};
			jdbc1.update(query,obj);
			System.out.println("student added!!");
			
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
		

