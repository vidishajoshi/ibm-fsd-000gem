package com.ibm.fsd.spring_jdbc_templet_5_sep;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import bean.EmployeeDao;
import bean.Employee;
import bean.EmployeeService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException
    {
    	 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
         bean.EmployeeService dao=context.getBean("employeeService",bean.EmployeeService.class);
         bean.Employee emp = context.getBean("employee", bean.Employee.class);
         Scanner sc=new Scanner(System.in);
         System.out.println("Welcome to the Employee Crud with Jdbc Template !!");
         System.out.println("1. Create new Employee");
         System.out.println("2. Get employee by id");
         System.out.println("3. Delete an employee");
         System.out.println("4. Display all employee");
         System.out.println("Enter your choice : ");
         int choice = sc.nextInt();
         switch(choice) {
         case 1:{
                  dao.createEmployee(emp);
                  break;
               }
         case 2: {
        	 System.out.println("enter the id :");
        	 int id=sc.nextInt();
             dao.getEmployeeById(id);
             
         }
         case 3:
         {
        	 System.out.println("enter the id :");
        	 int id=sc.nextInt();
             dao.deleteEmployee(id);
             break;
         }
         case 4:{
        	 List<bean.Employee> lemp=new ArrayList<bean.Employee>();
        	 lemp=dao.getAllEmployee();
        	 for(bean.Employee s:lemp) {
        		 System.out.println(s.getFname()+","+s.getLname()+","+s.getEmail());
        	 }
         }
         default:{
        	 System.out.println("Enter correct choice!!");
         }
         }
        
        
         
    }
}
