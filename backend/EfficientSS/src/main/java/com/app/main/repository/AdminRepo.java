package com.app.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.main.model.Admin;

public interface AdminRepo extends JpaRepository<Admin,String>{
	@Query(value="SELECT * FROM Admin WHERE a_email_id = ?",nativeQuery = true)
	Admin findByEmail(String a_email_id);

}
