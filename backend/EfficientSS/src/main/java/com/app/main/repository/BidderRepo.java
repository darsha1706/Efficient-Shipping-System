package com.app.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.app.main.model.Bidder;

@Repository
public interface BidderRepo extends JpaRepository<Bidder,Integer> {

	@Query(value="select * from bidder where b_selection_status in ('Selected')",nativeQuery = true)
	List<Bidder> findAllSelected();

//	@Query(value="select * from bidder where a_item_id= ?",nativeQuery = true)
//	List<Bidder> findByAuctionItemId(int a_id);

}
