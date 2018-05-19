package com.leonlu.code.sample.webapp.ws.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "couriers")
public class Courier {
	
	@Id
	@Column(name = "c_id", nullable = false)
	private String id;
	
	@Column(name = "c_name")
	private String name;
	
	@Column(name = "phone")
	private String phone;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	

}
