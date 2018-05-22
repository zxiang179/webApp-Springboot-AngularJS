package com.leonlu.code.sample.webapp.ws.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonlu.code.sample.webapp.ws.domain.Order;
import com.leonlu.code.sample.webapp.ws.repository.OrderRepository;
import com.leonlu.code.sample.webapp.ws.repository.RestaurantRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private RestaurantRepository restaurantRepository;
	
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
		Object restIDAndSaleAmount = orderRepository.findRestaurantSaleNum(orderID);
		String restID_saleAmount = restIDAndSaleAmount.toString();
		String[] split = restID_saleAmount.split("\\,");
		Integer restID = Integer.valueOf(split[0]);
		Integer saleAmount = Integer.valueOf(split[1]);
		String baseSaleNum = restaurantRepository.findRestaurantByID(restID.toString());
		Integer addedSaleAmount = saleAmount + Integer.valueOf(baseSaleNum);
		restaurantRepository.updateRestaurantSaleNum(addedSaleAmount.toString(), restID.toString());
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
