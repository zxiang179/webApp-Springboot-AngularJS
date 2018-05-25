package com.leonlu.code.sample.webapp.ws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonlu.code.sample.webapp.ws.domain.Food;
import com.leonlu.code.sample.webapp.ws.repository.FoodRepository;

@Service
public class FoodService {
	
	@Autowired
	private FoodRepository foodRepository;
	
	public List<Food> findAllFood(){
		List<Food> allFood = foodRepository.findAllFood();
		return allFood;
	}
	
	public List<Food> findFoodById(String id){
		List<Food> allFood = foodRepository.findFoodById(id);
		return allFood;
	}
	

}
