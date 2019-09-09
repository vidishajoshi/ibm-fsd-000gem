package com.example.bean.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bean.dao.*;
import com.example.bean.entity.*;


@Service
public class CustomerServiceImpl implements CustomerService {

	// need to inject customer dao
	@Autowired
	private CustomerDao customerDao;
	
	@Transactional
	public List<Customer> getCustomers() {
		return customerDao.getCustomers();
	}


	public void saveCustomer(Customer theCustomer) {

		customerDao.saveCustomer(theCustomer);
	}
     @Transactional
	public void deleteCustomer(int id) {
		customerDao.deleteCustomer(id);
		
	}


	public Customer getCustomer(int id) {
		return customerDao.getCustomer(id);
		
	}


	public void editCustomer(Customer customer) {
		
		System.out.println(customer.toString() +" servivse");
		customerDao.editCustomer(customer);
		
	}


	public List<Customer> searchByName(String type, String text) {
		
		return customerDao.searchByName(type, text);
	}


	public List<Customer> searchByEmail(String text) {
		
		return customerDao.searchByEmail(text);
	}
}