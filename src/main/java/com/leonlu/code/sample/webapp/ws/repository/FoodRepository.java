package com.leonlu.code.sample.webapp.ws.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.leonlu.code.sample.webapp.ws.domain.Food;

@Transactional
@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {

	// SELECT * FROM food WHERE food.rest_id = (SELECT restaurant.rest_id FROM
	// restaurant WHERE restaurant.rest_name = 'Italy Nest')
	@Query(value = "SELECT * FROM food WHERE food.rest_id = (SELECT restaurant.rest_id FROM restaurant WHERE restaurant.rest_name = ?1)", nativeQuery = true)
	public List<Food> findFoodByRestaurantName(String restaurantName);
	
	@Query(value = "select * from food",nativeQuery = true)
	public List<Food> findAllFood();

}
