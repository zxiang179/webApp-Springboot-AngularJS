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
	
	public List<Order> findAllOrders(){
		List<Order> allOrders = orderRepository.findAllOrders();
		return allOrders;
	}
	
	public Integer getMaxID() {
		Integer id = orderRepository.getMaxID();
		return id;
	}
	
	public void updateOrderRestaurantAdvice(String orderID){
		orderRepository.updateOrderRestaurantAdvice(orderID);
	}
	
	public List<Order> findAllCreatedOrders(){
		List<Order> orders = orderRepository.findAllCreatedOrders();
		return orders;
	}

	public void createOrder(String orderID, String customerID, String foodID, Double amount,String restaurantAdvice) {
		orderRepository.createOrder(orderID, foodID, customerID, amount,restaurantAdvice);
	}
	
	public List<Order> findAllCreatedAndAcceptedOrder(){
		List<Order> allCreatedOrders = orderRepository.findAllCreatedAndAcceptedOrder();
		return allCreatedOrders;
	}
	
	public void acceptOrder(String courierID,String orderID){
		orderRepository.updateOrderByOrderID(courierID,orderID);
		//餐厅销量
		Object[] restIDAndSaleAmount = (Object[])orderRepository.findRestaurantSaleNum(orderID);
		Integer saleAmount = Integer.valueOf(restIDAndSaleAmount[1].toString().split("\\.")[0]);
		String baseSaleNum = restaurantRepository.findRestaurantByID(restIDAndSaleAmount[0].toString());
		Integer addedSaleAmount = saleAmount + Integer.valueOf(baseSaleNum);
		restaurantRepository.updateRestaurantSaleNum(addedSaleAmount.toString(), restIDAndSaleAmount[0].toString());
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
