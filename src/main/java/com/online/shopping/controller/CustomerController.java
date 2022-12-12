package com.online.shopping.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.online.shopping.entity.Customer;
import com.online.shopping.service.CustomerServices;

@RestController
public class CustomerController 
{
	@Autowired(required = true)
	private  CustomerServices service;
	
	@PostMapping("/save/customer")
	public Customer saveCustomer(@RequestBody Customer customer)
	{
		return service.saveCustomer(customer);
	}
	
	@GetMapping("/getCustomerById/{id}")
	public Optional<Customer> getCustById(@PathVariable Long id)
	{
		Optional<Customer> c= service.getCustomerById(id);
		
		return c;
		 
	}
	
	@GetMapping("/getAllCustomers")
	public List<Customer> getAllCustomers()
	{
		return service.getAllCustomer();
	}
}
