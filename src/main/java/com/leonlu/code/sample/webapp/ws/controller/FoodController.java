package com.leonlu.code.sample.webapp.ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leonlu.code.sample.webapp.ws.domain.Food;
import com.leonlu.code.sample.webapp.ws.service.FoodService;


@RestController
@RequestMapping("/api/food")
public class FoodController {
	
	@Autowired
	private FoodService foodService;
	
	@RequestMapping("/foods")
	public List<Food> findAllFood(){
		List<Food> allFood = foodService.findAllFood();
		return allFood;
	}
	
	/**
	 * 根据餐厅名称查找食物
	 * @param restaurantName
	 * @return
	 */
	@RequestMapping("/{restaurantName}/foods")
	public List<Food> findFoodByRestaurantName(@PathVariable String restaurantName){
		List<Food> allFood = foodService.findFoodByRestaurantName(restaurantName);
		return allFood;
	}



	
}
