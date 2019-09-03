package com.ibm.fsd.oper;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ibm.fsd.Model.Student;



public class CreateStudent {

	//public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Student.class).buildSessionFactory();
try {
			
			Session session=factory.openSession();
			session.getTransaction().begin();
			session.persist(new Student(1,"mark","john","mark@g.com"));
			System.out.println("student inserted!!");
			session.getTransaction().commit();
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}


