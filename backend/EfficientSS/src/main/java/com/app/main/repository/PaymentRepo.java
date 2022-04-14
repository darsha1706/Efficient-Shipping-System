package com.app.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.main.model.Payment;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Integer>{

	@Query(value="select * from Payment where t_id= ?",nativeQuery = true)
	List<Payment> getbyTransporterId(int t_id);

}
