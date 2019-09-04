package com.ibm.fsd.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.ibm.fsd.Model.Student;



public class StudentDaoImpl implements StudentDao {

	SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").
			addAnnotatedClass(Student.class).buildSessionFactory();
	@Override
	public void createEmployee(Student student) {
		try {
			
			Session session=factory.openSession();
			session.getTransaction().begin();
			session.persist(student);
			System.out.println("student inserted!!");
			session.getTransaction().commit();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Student> getAllEmployees() {
		List<Student> list=new ArrayList<Student>();
		try {
			
			Session session= factory.openSession();
			Query query=session.createQuery("from Student");
			list=query.getResultList();
			for(Student s:list) {
				System.out.println(s);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
	}

	@Override
	public Student getEmployeeById(int id) {
		Student st=null;
		try {
			Session session = factory.openSession();
			st=session.get(Student.class,id);
			System.out.println("student retrived from given id: "+id);
			System.out.println(st.toString());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return st;
	}

	@Override
	public void deleteEmployee(int id) {
		Student st=null;
		try {
			Session session = factory.openSession();
			session.beginTransaction();
			st=session.get(Student.class,id);
			System.out.println("deleting the student from given id: "+id);
			session.delete(st);
			session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
		
	}




