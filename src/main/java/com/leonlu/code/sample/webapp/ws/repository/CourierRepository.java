package com.leonlu.code.sample.webapp.ws.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.leonlu.code.sample.webapp.ws.domain.Courier;
import com.leonlu.code.sample.webapp.ws.domain.Customer;

@Transactional
@Repository
public interface CourierRepository extends JpaRepository<Courier, Long>{
	
	@Query(value = "select * from couriers",nativeQuery = true)
	public List<Courier> findAll();
	
	@Modifying
	@Query(value = "INSERT INTO couriers(c_id,c_name,phone) VALUES (?1,?2,?3)",nativeQuery=true)
	public void insertCourier(String ID,String name,String phone);
	
	@Query(value = "select * from couriers where c_name = ?1",nativeQuery = true)
	public Courier findCourierByCourierName(String name);
	
	@Query(value = "select count(*) from couriers",nativeQuery = true)
	public Integer getMaxID();
	
	@Query(value = "select * from couriers where c_name = ?1 and phone = ?2",nativeQuery = true)
	public Courier findCourierByNameAndPhone(String name,String phone);
	

}
