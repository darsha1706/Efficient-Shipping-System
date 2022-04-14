package com.app.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.main.model.Customer;


public interface CustomerRepo extends JpaRepository<Customer,Integer>{
	
	@Query(value="SELECT * FROM Customer WHERE c_email_id = ?",nativeQuery = true)
	Customer findByEmail(String c_email_id);

	

}
