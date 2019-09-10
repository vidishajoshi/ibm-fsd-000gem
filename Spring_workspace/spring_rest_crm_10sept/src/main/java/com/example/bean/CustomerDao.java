package com.example.bean;

import java.util.List;

public interface CustomerDao {
	public void createCustomer(Customer customer);
	public List<Customer> viewCustomers();
	public void deleteCustomer(int id);
	public Customer getCustomer(int id);
	public void update( Customer customer);
}
