package com.example.bean.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.bean.entity.Customer;
import com.example.bean.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping("/")
	public String mainFun() {
		return "index";
	}
	
	@GetMapping("/showCustomers")
	public String listCustomers(Model theModel) {
		List<Customer> list=customerService.getCustomers();
		theModel.addAttribute("customer",list);
		return "list_cutomers";
		
		
	}
	
	@GetMapping("/addCustomer")
	public String showFormForAdd(Model theModel) {
		
		
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		customerService.saveCustomer(theCustomer);
	    System.out.println("customer added");
		return "index";
		}
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("id") int id) {
		customerService.deleteCustomer(id);
		System.out.println("customer is deleted");
		return "redirect:/showCustomers";
		
	}
	@GetMapping("/edit")
	public String getCustomerById(@RequestParam("id") int id,Model theModel) {
		Customer customer=customerService.getCustomer(id);
		theModel.addAttribute("customer", customer);
		return "edit_customer";
		
	}
	@RequestMapping("/editCustomer")
	public String editCustomer(@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName,@RequestParam("email") String email) {
	
		Customer theCustomer=new Customer(firstName,lastName,email);
		System.out.println(",controller, "+theCustomer.toString());
		customerService.editCustomer(theCustomer);
		return "redirect:/showCustomers";
		
	}
	
	@RequestMapping("/searchByFname")
	public String searchByfname(@RequestParam("sf") String text,Model theModel) {
		String type="firstName";
		List<Customer> list=customerService.searchByName(type, text);
		theModel.addAttribute("list",list);
		return "search_result";
		
	}
	
	@RequestMapping("/searchByLname")
	public String searchBylname(@RequestParam("lf") String text,Model theModel) {
		String type="lastName";
		List<Customer> list=customerService.searchByName(type, text);
		theModel.addAttribute("list",list);
		return "search_result";
		
	}
	
	
	@RequestMapping("/searchByEmail")
	public String searchByemail(@RequestParam("ef") String text,Model theModel) {
		
		List<Customer> list=customerService.searchByEmail(text);
		theModel.addAttribute("list",list);
		return "search_result";
		
	}
	
}




