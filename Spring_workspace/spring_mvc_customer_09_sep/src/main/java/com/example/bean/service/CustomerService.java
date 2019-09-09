package com.example.bean.service;

import java.util.List;

import com.example.bean.entity.Customer;


public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);
    
	public void deleteCustomer(int id);
	public Customer getCustomer(int id);
	public void editCustomer(Customer customer);
	public List<Customer> searchByName(String type, String text);
	public List<Customer> searchByEmail(String text);
}