package com.leonlu.code.sample.webapp.ws.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.leonlu.code.sample.webapp.ws.domain.Customer;


@Transactional
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	@Query(value = "select * from customer",nativeQuery = true)
	public List<Customer> findAll();
	
	@Modifying
	@Query(value = "INSERT INTO customer(ID,name,phone,address) VALUES (?1,?2,?3,?4)",nativeQuery=true)
	public void insertQuestion(String ID,String name,String phone,int address);
	

}
