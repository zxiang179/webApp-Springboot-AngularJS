package com.leonlu.code.sample.webapp.ws.repository;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.leonlu.code.sample.webapp.ws.domain.Order;

@Repository
@Transactional
public interface OrderRepository extends JpaRepository<Order, Long> {

	@Query(value = "select count(*) from orders", nativeQuery = true)
	public Integer getMaxID();

	@Modifying
	@Query(value = "INSERT INTO orders(o_ID,food_id,ID,amount,restaurant_advice) VALUES(?1,?2,?3,?4,?5)", nativeQuery = true)
	void createOrder(String orderID, String foodID, String customerID,
			Double amount,String restaurantAdvice);

	@Query(value = "SELECT * FROM orders WHERE c_id IS NULL and restaurant_advice = 'accepted'", nativeQuery = true)
	public List<Order> findAllCreatedAndAcceptedOrder();

	// UPDATE orders SET c_id = NULL WHERE o_ID = '40004'
	@Modifying
	@Query(value = "UPDATE orders SET c_id = ?1 WHERE o_ID = ?2", nativeQuery = true)
	public void updateOrderByOrderID(String courierID, String orderID);

	@Query(value = "SELECT food.foodname,food.price,SUM(orders.amount) AS foodSumAmount "
			+ "FROM orders join food on orders.food_id = food.food_id WHERE c_id IS NOT NULL "
			+ "GROUP BY orders.food_id ORDER BY foodSumAmount DESC LIMIT 0,1", nativeQuery = true)
	public Object findTopFoodOrder();

	@Query(value = "SELECT restaurant.rest_name,restaurant.address,restaurant.phone,SUM(orders.amount) AS restaurantSum FROM orders INNER JOIN food ON orders.food_id = food.food_id INNER JOIN restaurant ON food.rest_id = restaurant.rest_id AND orders.c_id IS NOT NULL GROUP BY food.food_id ORDER BY restaurantSum DESC LIMIT 0,1",nativeQuery = true)
	public Object findTopRestaurantOrder();

	@Query(value = "SELECT rest_id,amount FROM orders INNER JOIN food ON orders.food_id = food.food_id AND orders.o_ID = ?1",nativeQuery = true)
	public Object findRestaurantSaleNum(String orderID);
	
	@Query(value = "select * from orders where restaurant_advice = 'unaccepted'",nativeQuery = true)
	public List<Order> findAllCreatedOrders();
	
	@Query(value = "UPDATE orders SET restaurant_advice = 'accepted' WHERE o_ID = ?1" , nativeQuery = true)
	@Modifying
	public void updateOrderRestaurantAdvice(String orderID);
	
	@Query(value = "select * from orders",nativeQuery = true)
	public List<Order> findAllOrders();
	
}
