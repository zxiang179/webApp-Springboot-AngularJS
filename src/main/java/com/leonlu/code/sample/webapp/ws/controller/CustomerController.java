package com.leonlu.code.sample.webapp.ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leonlu.code.sample.webapp.ws.domain.Customer;
import com.leonlu.code.sample.webapp.ws.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/customers")
	public List<Customer> findAllCustomer(){
		List<Customer> customers = customerService.findAllCustomer();
		return customers;
	}

}
