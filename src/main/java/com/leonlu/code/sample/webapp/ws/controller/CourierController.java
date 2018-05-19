package com.leonlu.code.sample.webapp.ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leonlu.code.sample.webapp.ws.domain.Courier;
import com.leonlu.code.sample.webapp.ws.domain.Customer;
import com.leonlu.code.sample.webapp.ws.service.CourierService;

@RestController
@RequestMapping("/api/courier")
public class CourierController {
	
	@Autowired
	private CourierService courierService;

	@RequestMapping("/couriers")
	public List<Courier> findAllCourier(){
		List<Courier> couriers = courierService.findAllCourier();
		return couriers;
	}
	
	/**
	 * 返回true表示快递员登陆成功，返回false表示登陆失败
	 * @param name
	 * @param phone
	 * @return
	 */
	@RequestMapping(value="/login")
	public boolean loginCourier(String name,String phone) {
		return courierService.findCourierByNameAndPhone(name,phone);
	}
	
	/**
	 * 快递员注册
	 * @param name
	 * @param phone
	 * @param address
	 * @return
	 */
	//http://localhost:8080/api/courier/register?name=zx&phone=13127879080
	@RequestMapping(value = "/register",method=RequestMethod.GET)
	public boolean registerCourier(String name,String phone) {
		//根据用户名查找用户是否存在
		Courier courier = courierService.findCourierByCourierName(name);
		if(courier==null) {
			Integer maxID = courierService.getMaxID()+50001;
			courierService.addCourier(maxID.toString(),name,phone);
			return true;
		}else {
			return false;
		}
	}
	
}
