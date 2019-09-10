package com.example.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	private List<Customer> list =new ArrayList<Customer>(); 

	@PostConstruct
	public void setSession() {
		session = sessionFactory.openSession();
	}

	@Transactional
	public void createCustomer(Customer customer) {
		session.saveOrUpdate(customer);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Customer> viewCustomers() {
		list = session.createQuery("from Customer").getResultList();
		return list;

	}

	@Transactional
	public void deleteCustomer(int id) {
		Customer e = session.get(Customer.class, id);
			//session.delete(e);
		session.getTransaction().begin();
			session.remove(e);
			session.getTransaction().commit();
	}

	@Transactional
	public Customer getCustomer(int id) {
		Customer e = session.get(Customer.class, id);
		return e;
	}
	
	@Transactional
	public void update( Customer customer) {
		Customer c = new Customer(customer.getFirstName(),customer.getLastName(),customer.getEmail());
		session.getTransaction().begin();
		session.merge(c);
		session.getTransaction().commit();

	}

	

	
}
