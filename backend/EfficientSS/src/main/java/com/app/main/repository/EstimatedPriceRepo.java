package com.app.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.main.model.Estimated_Price;

@Repository
public interface EstimatedPriceRepo extends JpaRepository<Estimated_Price,Integer>{

	@Query(value="select * from estimated_price WHERE t_id = ?",nativeQuery = true)
	Optional<Estimated_Price> findByTransporterId(int id);

}
