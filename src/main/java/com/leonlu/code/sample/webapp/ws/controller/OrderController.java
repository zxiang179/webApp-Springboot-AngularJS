package com.leonlu.code.sample.webapp.ws.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leonlu.code.sample.webapp.ws.domain.Order;
import com.leonlu.code.sample.webapp.ws.domain.Restaurant;
import com.leonlu.code.sample.webapp.ws.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value = "/orders")
	public List<Order> findAllOrders(){
		return orderService.findAllOrders();
	}
	
	/**
	 * 餐厅将restaurantAdvice 改为 accepted 
	 */
	@RequestMapping(value = "/update/orderRestaurantAdvice")
	public void updateOrderRestaurantAdvice(String orderID){
		orderService.updateOrderRestaurantAdvice(orderID);
	}
	
	/**
	 * 用户创建订单
	 * @param customerID
	 * @param foodID
	 * @param amount
	 */
	//localhost:8080/api/order/create/order?customerID=10003&foodID=30004&amount=5
	@RequestMapping(value="/create/order") 
	public void createOrder(String customerID,String foodID,Double amount){
		Integer maxID = orderService.getMaxID()+40001;
		orderService.createOrder(maxID.toString(), customerID,foodID,amount,"unaccepted");
	}
	
	@RequestMapping(value = "/createdOrders")
	public List<Order> findAllCreatedOrders(){
		List<Order> orders = orderService.findAllCreatedOrders();
		return orders;
	}
	
	/**
	 * 查找用户创建并且被餐厅接受的订单
	 * @return
	 */
	@RequestMapping(value="/createdAndAcceptedOrders")
	public List<Order> findAllCreatedAndAcceptedOrder(){
		List<Order> allCreatedOrders = orderService.findAllCreatedAndAcceptedOrder();
		return allCreatedOrders;
	}
	
	/**
	 * 快递员接单
	 * @param orderID
	 * @return
	 */
	//http://localhost:8080/api/order/acceptOrder?courierID=50005?orderID=40004
	@RequestMapping(value="/acceptOrder")
	public void acceptOrder(String courierID,String orderID){
		orderService.acceptOrder(courierID,orderID);
	}
	
	/**
	 * 查找销量最高的食物
	 * @return
	 */
	//http://localhost:8080/api/order/findTopFoodOrder
	//foodID,foodSumAmount
	@RequestMapping(value="/findTopFoodOrder")
	public Object findTopFoodOrder(){
		return orderService.findTopFoodOrder();
	}
	
	/**
	 * 查找销量最高的餐厅
	 */
	//http://localhost:8080/api/order/findTopFoodOrder
	//restID,foodID,restaurantSumAmount
	@RequestMapping(value="/findTopRestaurantOrder")
	public Object findTopRestaurantOrder(){
		return orderService.findTopRestaurantOrder();
	}

}
