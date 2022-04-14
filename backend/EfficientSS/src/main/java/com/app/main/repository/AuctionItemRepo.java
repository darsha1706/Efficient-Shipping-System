package com.app.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.main.model.Auction_Item;
import com.app.main.model.Customer;

@Repository
public interface AuctionItemRepo extends JpaRepository<Auction_Item,Integer>{

	@Query(value="select * from auction_item WHERE c_id = ? and a_item_status in ('Running','Got Bid','No Bid')",nativeQuery = true)
	List<Auction_Item> findByCustomerId(int c_id);

	@Query(value="select * from auction_item WHERE a_item_status in ('Running','Got Bid') and timer in ('Counting')",nativeQuery = true)
	List<Auction_Item> findAllRunning();

	//History
	@Query(value="select * from auction_item WHERE c_id = ? and a_item_status in ('No Bid','Transporter Selected')",nativeQuery = true)
	List<Auction_Item> findByCustId(int c_id);
	
	
	
	
	@Query(value="select * from auction_item",nativeQuery = true)
	List<Auction_Item> getAllAuctionItem();
	
}
