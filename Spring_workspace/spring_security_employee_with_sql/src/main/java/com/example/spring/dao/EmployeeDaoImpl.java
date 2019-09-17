package com.example.spring.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.spring.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

	@Autowired
	private EntityManager em;
	private Session session;
	
	private List<Employee> list =new ArrayList<Employee>(); 


	@Transactional
	public void createEmployee(Employee customer) {
		session=em.unwrap(Session.class);
		session.saveOrUpdate(customer);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Employee> viewEmployee() {
		session=em.unwrap(Session.class);
		list = session.createQuery("from Employee").getResultList();
		return list;

	}

	@Transactional
	public void deleteEmployee(int id) {
		session=em.unwrap(Session.class);
		Employee e = session.get(Employee.class, id);
			//session.delete(e);
		session.getTransaction().begin();
			session.remove(e);
			session.getTransaction().commit();
	}

	@Transactional
	public Employee getEmployee(int id) {
		session=em.unwrap(Session.class);
		Employee e = session.get(Employee.class, id);
		return e;
	}
	
	@Transactional
	public void update( Employee employee) {
		session=em.unwrap(Session.class);
		Employee emp = new Employee(employee.getfName(),employee.getlName(),employee.getEmail(),employee.getJobType(),
				employee.getHourlyPaid(),employee.getTimePeriod(),employee.getSalary(),employee.getCommission());
		session.getTransaction().begin();
		session.merge(emp);
		session.getTransaction().commit();

	}

	@Override
	public void deleteIEmployee(int id) {
		// TODO Auto-generated method stub
		
	}
}
