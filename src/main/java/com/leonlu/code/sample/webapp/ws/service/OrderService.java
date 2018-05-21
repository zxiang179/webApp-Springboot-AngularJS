package com.leonlu.code.sample.webapp.ws.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonlu.code.sample.webapp.ws.domain.Order;
import com.leonlu.code.sample.webapp.ws.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	public Integer getMaxID() {
		Integer id = orderRepository.getMaxID();
		return id;
	}

	public void createOrder(String orderID, String customerID, String foodID, Double amount) {
		orderRepository.createOrder(orderID, foodID, customerID, amount);
	}
	
	public List<Order> findAllCreatedOrders(){
		List<Order> allCreatedOrders = orderRepository.findAllCreatedOrders();
		return allCreatedOrders;
	}
	
	public void acceptOrder(String courierID,String orderID){
		orderRepository.updateOrderByOrderID(courierID,orderID);
		//餐厅销量
		//菜品
	}
	
	public Object findTopFoodOrder(){
		Object topFoodOrder = orderRepository.findTopFoodOrder();
		return topFoodOrder;
	}
	
	public Object findTopRestaurantOrder(){
		Object topRestaurantOrder = orderRepository.findTopRestaurantOrder();
		return topRestaurantOrder;
	}

}
