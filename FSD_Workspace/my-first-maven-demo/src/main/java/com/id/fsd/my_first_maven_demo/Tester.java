package com.id.fsd.my_first_maven_demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Tester {

	public static void main(String[] args) {
		try {
		SessionFactory factory =(SessionFactory) new Configuration().
				configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		Session session=factory.openSession();
		/*Employee employee=new Employee("sachine","Tendulkar","sachine@g.com");
		session.getTransaction().begin();
		session.persist(employee);
		System.out.println("Inserted>>>");
		session.getTransaction().commit();*/
        Query query = session.createQuery("from Employee");
        List<Employee> list=query.getResultList();
        for(Employee e:list) {
        	System.out.println(e);
        }
		
	}catch(Exception e) {
		e.printStackTrace();
	}

}
}
