package com.leonlu.code.sample.webapp.ws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonlu.code.sample.webapp.ws.domain.Customer;
import com.leonlu.code.sample.webapp.ws.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customer> findAllCustomer(){
		List<Customer> customers = customerRepository.findAll();
		return customers;
	}

}
