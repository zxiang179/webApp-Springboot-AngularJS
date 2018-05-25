package com.leonlu.code.sample.webapp.ws.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leonlu.code.sample.webapp.ws.domain.Order;
import com.leonlu.code.sample.webapp.ws.domain.Restaurant;
import com.leonlu.code.sample.webapp.ws.service.OrderService;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	 * @param foodID
	 * @param amount
	 */
	@RequestMapping(value="/create/order") 
	public void createOrder(String foodID,String amount){
		Integer maxID = orderService.getMaxID()+40001;
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		String customerID = (String)session.getAttribute("customerId");
		orderService.createOrder(maxID.toString(), customerID,foodID,Double.valueOf(amount),"unaccepted");
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
	@RequestMapping(value="/acceptOrder")
	public void acceptOrder(String orderID){
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		String courierID = (String)session.getAttribute("courierId");
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
