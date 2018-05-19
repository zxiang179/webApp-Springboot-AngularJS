package com.leonlu.code.sample.webapp.ws.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "restaurant")
public class Restaurant {

	@Id
	@Column(name = "rest_id",nullable = false)
	private String id;
	
	@Column(name = "rest_name",nullable = false)
	private String name;
	
	@Column(name = "address",nullable = false)
	private String address;
	
	@Column(name = "phone",nullable = false)
	private String phone;
	
	@Column(name = "sale_number",nullable = false)
	private String saleNumber;
	
	@Column(name = "credits",nullable = false)
	private Long credits;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSaleNumber() {
		return saleNumber;
	}
	public void setSaleNumber(String saleNumber) {
		this.saleNumber = saleNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Long getCredits() {
		return credits;
	}
	public void setCredits(Long credits) {
		this.credits = credits;
	}
	
	
	
}
