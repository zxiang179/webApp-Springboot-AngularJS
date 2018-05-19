package com.leonlu.code.sample.webapp.ws.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "food")
public class Food {

	@Id
	@Column(name = "food_id",nullable = false)
	private String id;
	
	@Column(name = "foodname",nullable = false)
	private String foodName;
	
	@Column(name = "price",nullable = false)
	private Double price;
	
	@ManyToOne
	@JoinColumn(name = "rest_id",nullable = false)
	private Restaurant restaurant;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
	
	
	
}
