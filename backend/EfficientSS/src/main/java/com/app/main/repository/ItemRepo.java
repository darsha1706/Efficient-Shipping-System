package com.app.main.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.main.model.Item_Detail;

@Repository
public interface ItemRepo extends JpaRepository<Item_Detail,Integer>{

	@Query(value="select * from item_Detail WHERE c_id = ?",nativeQuery = true)
	List<Item_Detail> findByCustomerId(int c_id);

}
