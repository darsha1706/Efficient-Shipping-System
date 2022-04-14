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
import com.app.main.service.CustomerService;
import com.app.main.service.LoginService;
import com.app.main.service.TransporterService;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/transporter")
@Controller
public class TransporterController {
	
	@Autowired
	TransporterService T_service;
	
	@Autowired
	CustomerService C_service;
	
	@Autowired
	LoginService loginservice;

	//--------------------------------------------------------------------------------------------------------------------------------
	
	@PostMapping("/estimatedprice")
	public ResponseEntity<Estimated_Price> EstimatedPrice(@RequestBody Estimated_Price estimatedPrice,@RequestParam int t_id){
	
		return T_service.setEstimatedPrice(estimatedPrice,t_id); 
	}
	
	
	//Auction---------------------------------------------------------------------------------------------------------------------------
	
	@GetMapping("/auctionitem")
	public ResponseEntity<List<Auction_Item>> Auction_ItemList(){

		loginservice.startMethod();
		
		return T_service.listOfAuctionItems();
		
	}
	
	
	@PostMapping("/bidder")
	public ResponseEntity<HttpStatus> setBidder(@RequestParam int t_id,@RequestParam int a_item_id,@RequestParam int c_id,@RequestParam String price){
		
		return T_service.setBidderAuction(t_id,a_item_id,c_id,price);
	}

	
	//History-------------------------------------------------------------------------------------------------------------------------------
	
	@GetMapping("/selectedBidders/{t_id}")
	public ResponseEntity<List<Bidder>> getBidders(@PathVariable ("t_id") int id){
		
		return T_service.ListofSelcetedandUnselectedBids(id);
	}
	
	@GetMapping("/estimatedprice/{t_id}")
	public ResponseEntity<Estimated_Price> getEstimatedPrice(@PathVariable("t_id") int id){		//Transporter_id
		
		return T_service.getEstimatedPrice(id);
	}

	//Pickup And Delivery Status----------------------------------------------------------------------------------------
	
	@GetMapping("/selectedItems/{t_id}")
	public ResponseEntity<List<Item_Detail>> SelectedItems(@PathVariable("t_id") int id){		//Transporter_id
		
		return T_service.ListofSelcetedItems(id);
	}
	
	@PutMapping("/pickupdeliverydate")
	public ResponseEntity<Item_Detail> setPickUpDeliveryDate(@RequestParam int i_id,@RequestParam String pickupDate,@RequestParam String deliveryDate){		//Item_id
		
		return T_service.set_PickUpDeliveryDate(i_id,pickupDate,deliveryDate);
	}
	
	@PutMapping("/deliverystatus")
	public ResponseEntity<Item_Detail> setdeliveryStatus(@RequestParam int i_id){		//Item_id
		
		return T_service.set_DeliveryStatus(i_id);
	}
	
	
}
