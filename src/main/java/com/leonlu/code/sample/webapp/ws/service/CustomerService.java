package com.leonlu.code.sample.webapp.ws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonlu.code.sample.webapp.ws.domain.Customer;
import com.leonlu.code.sample.webapp.ws.repository.CustomerRepository;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findAllCustomer() {
        List<Customer> customers = customerRepository.findAll();
        return customers;
    }

    public Customer findCustomerByCustomerName(String name) {
        Customer customer = customerRepository.findCustomerByCustomerName(name);
        return customer;
    }

    public Integer getMaxID() {
        Integer id = customerRepository.getMaxID();
        return id;
    }

    public void addCustomer(String id, String name, String phone, String address) {
        customerRepository.insertCustomer(id, name, phone, address);
    }

    public boolean findCustomerByNameAndPhone(String name, String phone) {
        Customer customer = customerRepository.findCustomerByNameAndPhone(name, phone);
        if (customer == null) {
            return false;
        } else {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            HttpSession session = request.getSession();
            session.setAttribute("customerId", customer.getId());
            return true;
        }
    }
}
