package com.online.shopping.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.shopping.entity.Customer;
import com.online.shopping.repository.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerServices
{

	@Autowired
	private CustomerRepo repo;
	// object
	
	public Customer saveCustomer(Customer customer) {
		return repo.save(customer);
	}

	public Optional<Customer> getCustomerById(Long id) {
		return repo.findById(id);
	}

	public List<Customer> getAllCustomer() {
		return repo.findAll();
	}
	
}
