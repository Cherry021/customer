package com.online.shopping.service;

import java.util.List;
import java.util.Optional;

import com.online.shopping.entity.Customer;

public interface CustomerServices 
{
	public Customer saveCustomer(Customer c);
	public Optional<Customer> getCustomerById(Long id);
	public List<Customer> getAllCustomer();
}
