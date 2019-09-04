package com.ibm.fsd.StudentCrud;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ibm.fsd.Dao.StudentDao;
import com.ibm.fsd.Dao.StudentDaoImpl;
import com.ibm.fsd.Model.Student;


public class StudentTester {

	
	
	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Student.class).buildSessionFactory();
		StudentDao stDao=new StudentDaoImpl();
		List<Student> stList=new ArrayList<Student>();
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome to this student crud portal!!");
		System.out.println("1. Add new Student");
		System.out.println("2. Display all Student");
		System.out.println("3. Display a student of specific id");
		System.out.println("4. Delete a student");
        int i=sc.nextInt();
		switch(i) {
		case 1:{
			   stDao.createEmployee(new Student("mark","john","mark@g.com"));
		       break;
		       }
		case 2:{
			   stList=stDao.getAllEmployees();
			   
			   break;
		       }
		case 3:{
			System.out.println("enter id: ");
			int j=sc.nextInt();
			Student dt=stDao.getEmployeeById(j);
			
			break;
		}case 4:{
			System.out.println("enter id: ");
			int j=sc.nextInt();
			stDao.deleteEmployee(j);
			System.out.println("student deleted");
			break;
		}
		default:
		       {
			    System.out.println("Choose a valid option!! ");
			    System.out.println("Thank you");
			    factory.close();
		       }
		}
	}
}