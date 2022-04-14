package com.app.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.main.model.Transporter;

public interface TransporterRepo extends JpaRepository<Transporter,Integer>{
	@Query(value="SELECT * FROM Transporter  WHERE t_email_id = ?",nativeQuery = true)
	Transporter findByEmail(String t_email_id);

}
