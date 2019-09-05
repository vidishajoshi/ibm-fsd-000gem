package com.ibm.fsd.spring_datasource_05_Sep;

import java.sql.SQLException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import bean.Employee;
import bean.EmployeeDao;

public class App 
{
    public static void main( String[] args ) throws SQLException
    {
      ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
      EmployeeDao dao=context.getBean("employeeDao",EmployeeDao.class);
      Employee emp = context.getBean("employee", Employee.class);
      dao.createEmployee(emp);
     System.out.println("Employee added!!");
      //int id=1;
     // dao.getEmployeeById(id);
      //System.out.println("Employee fetched");
      
    }
}
