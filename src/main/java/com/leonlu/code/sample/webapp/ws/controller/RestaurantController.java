package com.leonlu.code.sample.webapp.ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leonlu.code.sample.webapp.ws.domain.Restaurant;
import com.leonlu.code.sample.webapp.ws.service.RestaurantService;

@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@RequestMapping("/restaurants")
	public List<Restaurant> findAllRestaurant(){
		List<Restaurant> restaurants = restaurantService.findAllRestaurant();
		return restaurants;
	}
	
	/**
	 * 返回true表示登陆成功，返回false表示登陆失败
	 * @param name
	 * @param phone
	 * @return
	 */
	@RequestMapping(value="/login")
	public boolean loginRestaurant(String name,String phone) {
		return restaurantService.findRestaurantByNameAndPhone(name,phone);
	}
	
	/**
	 * 用户注册
	 * @param name
	 * @param phone
	 * @param address
	 * @return
	 */
	//http://localhost:8080/api/restaurant/register?name=ZX&phone=13127879080&address=shanghai&saleNum=0&credits=5
	@RequestMapping(value = "/register",method=RequestMethod.GET)
	public boolean registerRestaurant(String name, String id, String address, String phone, String saleNum, Long credits) {
		//根据用户名查找用户是否存在
		Restaurant restaurant = restaurantService.findRestaurantByRestaurantName(name);
		if(restaurant==null) {
			Integer maxID = restaurantService.getMaxID()+20001;
			restaurantService.addRestaurant(name,maxID.toString(), address, phone, saleNum, credits);
			return true;
		}else {
			return false;
		}
	}

}
