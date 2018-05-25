package com.leonlu.code.sample.webapp.ws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonlu.code.sample.webapp.ws.domain.Courier;
import com.leonlu.code.sample.webapp.ws.domain.Customer;
import com.leonlu.code.sample.webapp.ws.repository.CourierRepository;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class CourierService {

	@Autowired
	private CourierRepository courierRepository;
	
	public List<Courier> findAllCourier(){
		List<Courier> customers = courierRepository.findAll();
		return customers;
	}
	
	public Courier findCourierByCourierName(String name) {
		Courier courier = courierRepository.findCourierByCourierName(name);
		return courier;
	}
	
	public Integer getMaxID() {
		Integer id = courierRepository.getMaxID();
		return id;
	}
	
	public void addCourier(String id,String name,String phone) {
		courierRepository.insertCourier(id, name, phone);
	}
	
	public boolean findCourierByNameAndPhone(String name,String phone) {
		Courier courier = courierRepository.findCourierByNameAndPhone(name, phone);
		if(courier == null) {
			return false;
		}else {
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
			HttpSession session = request.getSession();
			session.setAttribute("courierId", courier.getId());
			return true;
		}
	}
	
}
