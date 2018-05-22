package com.leonlu.code.sample.webapp.ws.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.leonlu.code.sample.webapp.ws.domain.Food;
import com.leonlu.code.sample.webapp.ws.domain.Restaurant;


@Transactional
@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

	@Query(value = "select * from restaurant", nativeQuery = true)
	public List<Restaurant> findAll();

	@Modifying
	@Query(value = "INSERT INTO restaurant(rest_name,rest_id,address,phone,sale_number,credits) VALUES (?1,?2,?3,?4,?5,?6)", nativeQuery = true)
	public void insertRestaurant(String name, String id, String address,
			String phone, String saleNum, Long credits);

	@Query(value = "select * from restaurant where rest_name = ?1", nativeQuery = true)
	public Restaurant findRestaurantByRestaurantName(String name);

	@Query(value = "select count(*) from restaurant", nativeQuery = true)
	public Integer getMaxID();

	@Query(value = "select * from restaurant where rest_name = ?1 and phone = ?2", nativeQuery = true)
	public Restaurant findRestaurantByNameAndPhone(String name, String phone);
	
	@Query(value = "SELECT sale_number FROM restaurant WHERE restaurant_id=?1;",nativeQuery = true)
	public String findRestaurantByID(String restaurantID);
	
    @Query(value = "UPDATE restaurant SET restaurant.sale_number = ?1 WHERE restaurant.rest_id = ?2", nativeQuery = true)
    @Modifying
    public void updateRestaurantSaleNum(String addedSaleNum,String restID);
}
