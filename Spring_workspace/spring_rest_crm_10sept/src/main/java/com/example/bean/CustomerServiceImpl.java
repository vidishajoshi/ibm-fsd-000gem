package com.example.bean;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerDao dao;
	private List<Customer> list =new ArrayList<Customer>(); 
	public void createCustomer(Customer customer) {
		dao.createCustomer(customer);
		
	}

	public List<Customer> viewCustomers() {
		list=dao.viewCustomers();
		return list;
	}

	public void deleteCustomer(int id) {
		dao.deleteCustomer(id);
		
	}

	public Customer getCustomer(int id) {
		Customer c = dao.getCustomer(id);
		return c;
	}
	public void update(Customer customer) {
		dao.update(customer);

	}


}
