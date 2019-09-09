package com.example.bean.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.bean.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	
	@Autowired
	private SessionFactory sessionFactory;

	public List<Customer> getCustomers() {
	
             Session currentSession = sessionFactory.openSession();
			Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);
	    	List<Customer> customers = theQuery.getResultList();

			return customers;
		}

	
		public void saveCustomer(Customer theCustomer) {

	    Session currentSession = sessionFactory.openSession();
			currentSession.save(theCustomer);

		}

       @Transactional
		public void deleteCustomer(int id) {
		Session currentSession=sessionFactory.openSession();
		currentSession.beginTransaction();
		    Customer customer=currentSession.get(Customer.class, id);
		    currentSession.remove(customer);
		    currentSession.getTransaction().commit();
		    currentSession.close();
		}


	public Customer getCustomer(int id) {
	Session currentSession=sessionFactory.openSession();
		Customer customer=currentSession.get(Customer.class,id);
		//System.out.println(customer+"getid");
		return customer;
		
		
	}

@Transactional
	public void editCustomer(Customer theCustomer) {
	   Session currentSession=sessionFactory.openSession();
			   System.out.println("dao" +theCustomer.toString());
		currentSession.beginTransaction();
			   currentSession.merge(theCustomer);
			   currentSession.getTransaction().commit();
      	System.out.println("customer edited");
      	currentSession.close();
		
	}


public List<Customer> searchByName(String type, String text) {
    Session currentSession = sessionFactory.openSession();
	Query<Customer> theQuery = currentSession.createQuery("from Customer where "+type+" like '%"+text+"%'", Customer.class);
	List<Customer> customers = theQuery.getResultList();

	return customers;
}


public List<Customer> searchByEmail(String text) {
	Session currentSession = sessionFactory.openSession();
	Query<Customer> theQuery = currentSession.createQuery("from Customer where email='"+text+"'", Customer.class);
	List<Customer> customers = theQuery.getResultList();

	return customers;
}


}