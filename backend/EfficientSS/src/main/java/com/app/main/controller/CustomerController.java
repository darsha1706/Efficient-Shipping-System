package com.app.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.main.model.Auction_Item;
import com.app.main.model.Bidder;
import com.app.main.model.Estimated_Price;
import com.app.main.model.Item_Detail;
import com.app.main.model.Transporter;
import com.app.main.service.AdminService;
import com.app.main.service.CustomerService;
import com.app.main.service.LoginService;
import com.app.main.service.TransporterService;


@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/customer")
@Controller
public class CustomerController {

	
	@Autowired
	CustomerService C_service;
	
	@Autowired
	TransporterService T_service;
	
	@Autowired
	AdminService A_service;

	@Autowired
	LoginService loginservice;

	//---------------------------------------------------------------------------------------------------------------------------------------
	
	@PostMapping("/itemdetails") 
	  public ResponseEntity<HttpStatus> itemRegistration(@RequestBody Item_Detail itemdetail,@RequestParam int c_id) {

		  	return C_service.saveitem(itemdetail,c_id);
	 }

	
	
	@GetMapping("/itemdetails/{c_id}")
	public ResponseEntity<List<Item_Detail>> itemDetail(@PathVariable("c_id") int id) {				//CustomerId

		return C_service.getAllItem(id);
	
	}
	
	
	
	//Customer Goes For Direct Booking--------------------------------------------------------------------------------------------------------
	
	
	@GetMapping("/transporter")
	public ResponseEntity<List<Transporter>> AllTransporter(){
	
		return A_service.getAllTransporter();
	}
	
	@GetMapping("/estimatedprice/{t_id}")
	public ResponseEntity<Estimated_Price> getEstimatedPrice(@PathVariable("t_id") int id){		//Transporter_id
		
		return T_service.getEstimatedPrice(id);
	}
	
	@PostMapping("/bidder")
	public ResponseEntity<Bidder> setBidder(@RequestParam int t_id,@RequestParam int i_id,@RequestParam int c_id,@RequestParam String kmrange){
		
		return C_service.setBidderNoAuction(t_id,i_id,c_id,kmrange);
	}

	
	
	//Customer Goes For Bidding-----------------------------------------------------------------------------------------------------------

	
	@PostMapping("/auctionitem")
	public ResponseEntity<Auction_Item> AddAuctionItem(@RequestBody Auction_Item auction_item,@RequestParam int c_id,@RequestParam int i_id){
		
		return C_service.saveAuctionItem(auction_item,c_id,i_id);
	}

	@GetMapping("/auctionitem/{c_id}")
	public ResponseEntity<List<Auction_Item>> listOfAuctionItem(@PathVariable("c_id") int c_id) {		//Customer_id

		loginservice.startMethod();
		
		return C_service.getAuctionItem(c_id);
	
	}
	
	@GetMapping("/auctionitembidder/{a_id}")
	public ResponseEntity<List<Bidder>> listOfAuctionItemBidder(@PathVariable("a_id") int id){					//Auction_item_id
		
		return C_service.getAuctionItemBidderList(id);
	}

	//More info of Vehicles remaining
	
	@PutMapping("/bidder/{b_id}/{a_id}")
	public ResponseEntity<Bidder> BidderSelection(@PathVariable("b_id") int b_id,@PathVariable("a_id") int a_id){
		
		return C_service.updateBidder(b_id,a_id);
	}
	
	
	//History--------------------------------------------------------------------------------------------------------------
	
	@GetMapping("/historyauctionitem/{c_id}")
	public ResponseEntity<List<Auction_Item>> historyOfAuction(@PathVariable("c_id") int c_id){
		
		return C_service.getAuctionItems(c_id);
	}
	
	@GetMapping("/historyauctionbidder/{a_id}")
	public ResponseEntity<List<Bidder>> historyOfAuctionBidder(@PathVariable("a_id") int a_id){
		
		return C_service.getBidderofAuctionItem(a_id);
	}
	
	@GetMapping("/directhistory")
	public  ResponseEntity<List<Bidder>> DirectBidderH(){
		
		return C_service.HistoryDirectBidder();
	}
	//Time Exhausted----------------------------------------------------------------------------------------------------------------------
	
	@PutMapping("/timeexhausted/{a_id}")
	public ResponseEntity<Auction_Item> timeExhausted(@PathVariable("a_id") int a_id)
	{
			
			return C_service.updateStatusToNoBid(a_id);
	}	
	
}
