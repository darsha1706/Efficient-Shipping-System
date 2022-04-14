package com.app.main.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.main.model.Auction_Item;
import com.app.main.model.Bidder;
import com.app.main.model.Customer;
import com.app.main.model.Estimated_Price;
import com.app.main.model.Item_Detail;
import com.app.main.model.Transporter;
import com.app.main.repository.AuctionItemRepo;
import com.app.main.repository.BidderRepo;
import com.app.main.repository.CustomerRepo;
import com.app.main.repository.EstimatedPriceRepo;
import com.app.main.repository.ItemRepo;
import com.app.main.repository.TransporterRepo;

@Service
public class CustomerService {

	@Autowired
	ItemRepo I_repo;
	
	@Autowired
	EstimatedPriceRepo E_repo;
	
	@Autowired
	BidderRepo B_repo;
	
	@Autowired
	TransporterRepo T_repo;
	
	@Autowired
	CustomerRepo C_repo;
	
	@Autowired
	AuctionItemRepo A_repo;

	//-----------------------------------------------------------------------------------------------------------------------------------
	
	public ResponseEntity<HttpStatus> saveitem(Item_Detail itemdetail,int c_id) {
		
		try {
			Customer cust=C_repo.getById(c_id);
			itemdetail.setCustomer(cust);
			itemdetail.setOperation_status("Registered");
			I_repo.save(itemdetail);
			
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}

	
	public ResponseEntity<List<Item_Detail>> getAllItem(int c_id) {
		
		List<Item_Detail> itemdetail = I_repo.findByCustomerId(c_id);
		
		if (itemdetail.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		} else {
			List<Item_Detail> i_detail=new ArrayList<Item_Detail>();
			
			for(Item_Detail e:itemdetail) {
				if(e.getOperation_status().equalsIgnoreCase("Registered")) {
					i_detail.add(e);
				}
			}
			return new ResponseEntity<>(i_detail, HttpStatus.OK);
		}
	}
	
	
	//Costomer goes For Direct Booking-------------------------------------------------------------------------------------------------
	

	
	@SuppressWarnings("null")
	public ResponseEntity<Bidder> setBidderNoAuction(int t_id,int i_id,int c_id, String kmrange) {
		
		try {
			
			
			Bidder bidder = new Bidder();
			
			Transporter transporter=T_repo.getById(t_id);
			
			Customer cust1=C_repo.getById(c_id);
			
			Item_Detail item1=I_repo.getById(i_id);
			item1.setOperation_status("Direct Booked");
			
			int i=Integer.parseInt(item1.getI_weight());
			int j=Integer.parseInt(kmrange);
			int price=0;
			Optional <Estimated_Price> esp=E_repo.findByTransporterId(t_id);
			
			if(esp.isPresent()) {
				Estimated_Price estimated=esp.get();
				if(j<=200) {
					price=estimated.getRange_0_200()*i;
				}else if(j>200 && j<=500) {
					price=estimated.getRange_200_500()*i;
				}else {
					price=estimated.getRange_500_above()*i;
				}
			}
			
			
			bidder.setB_name(transporter.getT_first_name());
			bidder.setB_ph_no(transporter.getT_ph_no());
			bidder.setB_price(price);												
			bidder.setB_selection_status("Selected");
		
			bidder.setTransporter(transporter);
			B_repo.save(bidder);
			
			List<Bidder> b1=new ArrayList<Bidder>();
			List<Customer> c1=new ArrayList<Customer>();
			List<Item_Detail> i1=new ArrayList<Item_Detail>();
			
			b1.add(bidder);
			c1.add(cust1);
			i1.add(item1);
			
			cust1.setBidder(b1);
			bidder.setCustomer(c1);
			
			item1.setBidder(b1);
			bidder.setItem_detail(i1);
			
			Bidder bid=B_repo.save(bidder);
			C_repo.save(cust1);
			I_repo.save(item1);
			
			return new ResponseEntity<>(bid,HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
		
	}
	
	//Customer goes For Bidding-------------------------------------------------------------------------------------------------------------------

	
	public ResponseEntity<Auction_Item> saveAuctionItem(Auction_Item auction_item,int c_id,int i_id) {
		
		try {
			
			Customer cust=C_repo.getById(c_id);
			auction_item.setCustomer(cust);
			
			Item_Detail item=I_repo.getById(i_id);
			item.setOperation_status("Goes for Auction");
			auction_item.setItem_detail(item);
			
			auction_item.setA_item_status("Running");
			auction_item.setTimer("Counting");
			
			
			
//			 long currentTime = System.currentTimeMillis();  
//		      
//			    // creating a new object of the class Date  
//			    Date currTime = new java.util.Date(currentTime);      
//			     			
//			if(auction_item.getA_start_datetime().equals(currTime))
//			{
//				auction_item.setA_item_status("Running");
//			}
				
				
					
			Auction_Item aItem=A_repo.save(auction_item);
			
			return new ResponseEntity<>(aItem,HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
		
	}

	
	public ResponseEntity<List<Auction_Item>> getAuctionItem(int c_id) {
		
		List<Auction_Item> auctionItem = A_repo.findByCustomerId(c_id);

		if (auctionItem.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(auctionItem, HttpStatus.OK);
		}
	}
	
	
	public ResponseEntity<List<Bidder>> getAuctionItemBidderList(int a_id) {
		
		
//		Optional<Auction_Item> aIbidders = A_repo.findById(a_id);

		Auction_Item a=A_repo.getById(a_id);
		List<Bidder>b=a.getBidder();
		
		
		if (b.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(b, HttpStatus.OK);
		}
		
			
		
	}


	//More info of Vehicles remaining
	
	
	public ResponseEntity<Bidder> updateBidder(int b_id, int a_id) {
		
		try {
			Optional<Bidder> oldBidder = B_repo.findById(b_id);
			
			Optional<Auction_Item> oldAuctionItem = A_repo.findById(a_id);
			
			if(oldAuctionItem.isPresent())
			{
				Auction_Item newAuctionItem=oldAuctionItem.get();
				newAuctionItem.setA_item_status("Transporter Selected");;
				
				A_repo.save(newAuctionItem);
			}
			
			if(oldBidder.isPresent())
			{
				Bidder newBidder=oldBidder.get();
				newBidder.setB_selection_status("Selected");
				
				
				return new ResponseEntity<>(B_repo.save(newBidder),HttpStatus.OK);
			}
			else
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}

	//History--------------------------------------------------------------------------------------------------------------------------

	public ResponseEntity<List<Auction_Item>> getAuctionItems(int c_id) {
		
		List<Auction_Item> auction_Items = A_repo.findByCustId(c_id);

		if (auction_Items.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(auction_Items, HttpStatus.OK);
		}
	}


	public ResponseEntity<List<Bidder>> getBidderofAuctionItem(int a_id) {
		
		Auction_Item auction_Item = A_repo.getById(a_id);

		try {
			List<Bidder> bid=auction_Item.getBidder();
			
			return new ResponseEntity<>(bid,HttpStatus.OK);
		} catch (Exception e) {
			
			return null;
		}
		
	}


	public ResponseEntity<List<Bidder>> HistoryDirectBidder() {
		
		try {
			//List<Bidder> bid=B_repo.findAllSelected();
			
			List<Item_Detail> idetail=I_repo.findAll();

			List<Bidder> bidder= new ArrayList<Bidder>();
			
			List<Bidder> selectedbidder= new ArrayList<Bidder>();
			
			for (Item_Detail i: idetail) {
				if(i.getOperation_status().equalsIgnoreCase("Direct Booked")) {
					 List<Bidder> bid=i.getBidder();
					 for(Bidder b:bid) {
						 bidder.add(b);
					 }
				}
			}
			
			for (Bidder a: bidder) {
				if(a.getB_selection_status().equalsIgnoreCase("Selected")) {
					selectedbidder.add(a);
				}
			}
			
			return new ResponseEntity<>(selectedbidder,HttpStatus.OK);
		} catch (Exception e) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}

	//Time Exhausted-----------------------------------------------------------------------------------------------------------
	
	public ResponseEntity<Auction_Item> updateStatusToNoBid(int a_id) {
		
		try {
			Auction_Item aitem=A_repo.getById(a_id);
			
			aitem.setA_item_status("No Bid");
			
			Auction_Item aucItem=A_repo.save(aitem);
			
			return new ResponseEntity<>(aucItem,HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	
}
