package com.ibm.fsd.StudentCrud;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ibm.fsd.Dao.StudentDao;
import com.ibm.fsd.Dao.StudentDaoImpl;
import com.ibm.fsd.model.Student;

public class StudentTester {

	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Student.class).buildSessionFactory();
		StudentDao stDao=new StudentDaoImpl();
		List<Student> stList=new ArrayList<Student>();
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome to this student crud portal!!");
		System.out.println("1. Add new Student");
		System.out.println("2. Display all Student");
        int i=sc.nextInt();
		switch(i) {
		case 1:{
			   stDao.createEmployee(new Student(1,"mark","john","mark@g.com"));
		       break;
		       }
		case 2:{
			   stList=stDao.getAllEmployees();
			   for(Student s:stList) {
				   System.out.println(s);
			   }
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