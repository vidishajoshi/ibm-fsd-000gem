package com.example.bean.dao;
import java.util.List;

import com.example.bean.entity.Customer;



public interface CustomerDao {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);
	
	public void deleteCustomer(int id);
	
	public Customer getCustomer(int id);
	public void editCustomer(Customer theCustomer);
	public List<Customer> searchByName(String type,String text);
	public List<Customer> searchByEmail(String text);
	
}