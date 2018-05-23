package com.leonlu.code.sample.webapp.ws.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	
	//o_ID
	@Id
	@Column(name = "o_ID")
	private String id;
	@Column(name = "amount")
	private Double amount;
	//餐厅是否接受
	@Column(name = "restaurantAdvice")
	private String advice;
	
	//ID
	@ManyToOne
	@JoinColumn(name = "ID")
	private Customer customerID;
	
	@ManyToOne
	@JoinColumn(name = "c_id",nullable = true)
	private Courier courier;
	
	@ManyToOne
	@JoinColumn(name = "food_id")
	private Food food;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Customer getCustomerID() {
		return customerID;
	}
	public void setCustomerID(Customer customerID) {
		this.customerID = customerID;
	}
	public Courier getCourier() {
		return courier;
	}
	public void setCourier(Courier courier) {
		this.courier = courier;
	}
	public Food getFood() {
		return food;
	}
	public void setFood(Food food) {
		this.food = food;
	}
	public String getAdvice() {
		return advice;
	}
	public void setAdvice(String advice) {
		this.advice = advice;
	}
	
	
	
	

}
