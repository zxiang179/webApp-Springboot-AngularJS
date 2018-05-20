package com.leonlu.code.sample.webapp.ws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonlu.code.sample.webapp.ws.domain.Restaurant;
import com.leonlu.code.sample.webapp.ws.repository.RestaurantRepository;

@Service
public class RestaurantService {
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	
	public List<Restaurant> findAllRestaurant(){
		List<Restaurant> restaurants = restaurantRepository.findAll();
		return restaurants;
	}
	
	public Restaurant findRestaurantByRestaurantName(String name) {
		Restaurant restaurant = restaurantRepository.findRestaurantByRestaurantName(name);
		return restaurant;
	}
	
	public Integer getMaxID() {
		Integer id = restaurantRepository.getMaxID();
		return id;
	}
	
	public void addRestaurant(String name, String id, String address, String phone, String saleNum, Long credits) {
		restaurantRepository.insertRestaurant(name, id, address, phone, saleNum, credits);
	}

	public boolean findRestaurantByNameAndPhone(String name,String phone) {
		Restaurant restaurant = restaurantRepository.findRestaurantByNameAndPhone(name,phone);
		if(restaurant==null) {
			return false;
		}else {
			return true;
		}
	}

}
