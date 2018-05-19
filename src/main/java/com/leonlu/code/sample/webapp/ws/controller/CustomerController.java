package com.leonlu.code.sample.webapp.ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	/**
	 * 返回true表示登陆成功，返回false表示登陆失败
	 * @param name
	 * @param phone
	 * @return
	 */
	@RequestMapping(value="/login")
	public boolean loginCustomer(String name,String phone) {
		return customerService.findCustomerByNameAndPhone(name,phone);
	}
	
	/**
	 * 用户注册
	 * @param name
	 * @param phone
	 * @param address
	 * @return
	 */
	//http://localhost:8080/api/customer/register?name=zx&phone=13127879080&address=shanghai
	@RequestMapping(value = "/register",method=RequestMethod.GET)
	public boolean registerCustomer(String name,String phone,String address) {
		//根据用户名查找用户是否存在
		Customer customer = customerService.findCustomerByCustomerName(name);
		if(customer==null) {
			Integer maxID = customerService.getMaxID()+10001;
			customerService.addCustomer(maxID.toString(),name,phone,address);
			return true;
		}else {
			return false;
		}
	}

}
