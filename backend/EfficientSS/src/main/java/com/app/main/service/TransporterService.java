package com.app.main.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
public class TransporterService {

	@Autowired
	EstimatedPriceRepo E_repo;
	
	@Autowired
	AuctionItemRepo A_repo;
	
	@Autowired
	TransporterRepo T_repo;
	
	@Autowired
	CustomerRepo C_repo;
	
	@Autowired
	ItemRepo I_repo;
	
	@Autowired
	BidderRepo B_repo;

	//-------------------------------------------------------------------------------------------------------------------------------------
	
	public ResponseEntity<Estimated_Price> setEstimatedPrice(Estimated_Price estimatedPrice, int t_id) {
		
		try {
			
			Transporter Trans=T_repo.getById(t_id);
			
			Optional <Estimated_Price> oldEstimatedPrice=E_repo.findByTransporterId(t_id);
			
			if(oldEstimatedPrice.isPresent())
			{
				//Update
				
				Estimated_Price newEstimatedPrice=oldEstimatedPrice.get();
				
				newEstimatedPrice.setRange_0_200(estimatedPrice.getRange_0_200());
				newEstimatedPrice.setRange_200_500(estimatedPrice.getRange_200_500());
				newEstimatedPrice.setRange_500_above(estimatedPrice.getRange_500_above());
				
				return new ResponseEntity<>(E_repo.save(newEstimatedPrice),HttpStatus.OK);
			}
			else
			{
				estimatedPrice.setTransporter(Trans);
				
				Estimated_Price ep=E_repo.save(estimatedPrice);
				
				return new ResponseEntity<>(ep,HttpStatus.CREATED);
			}
			
			
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}

	//Auction---------------------------------------------------------------------------------------------------------------------
	
	public ResponseEntity<List<Auction_Item>> listOfAuctionItems() {
		
		List<Auction_Item> auction_Items = A_repo.findAllRunning();

		if (auction_Items.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(auction_Items, HttpStatus.OK);
		}
	}

	public ResponseEntity<HttpStatus> setBidderAuction(int t_id, int a_item_id, int c_id, String price) {
		
try {
			
			Bidder bidder = new Bidder();
			
			Transporter transporter=T_repo.getById(t_id);
			
			Customer cust1=C_repo.getById(c_id);								//no need of customer id it should be taken from item_details table
			
			Auction_Item aucItem=A_repo.getById(a_item_id);
			aucItem.setA_item_status("Got Bid");
			
			
			Item_Detail item1=I_repo.getById(aucItem.getItem_detail().getI_id());
			
			bidder.setB_name(transporter.getT_first_name());
			bidder.setB_ph_no(transporter.getT_ph_no());
			
			int rs=Integer.parseInt(price);
			bidder.setB_price(rs);												
			bidder.setB_selection_status("Not Selected");
			

			
			bidder.setTransporter(transporter);
			B_repo.save(bidder);
			

			
			List<Bidder> b1=new ArrayList<Bidder>();
			List<Customer> c1=new ArrayList<Customer>();
			List<Item_Detail> i1=new ArrayList<Item_Detail>();
			List<Auction_Item> a1=new ArrayList<Auction_Item>();
			
			b1.add(bidder);
			c1.add(cust1);
			i1.add(item1);
			a1.add(aucItem);
			
			cust1.setBidder(b1);
			bidder.setCustomer(c1);
			
			item1.setBidder(b1);
			bidder.setItem_detail(i1);
			
			aucItem.setBidder(b1);
			bidder.setAuction_item(a1);
			
			B_repo.save(bidder);
			C_repo.save(cust1);
			I_repo.save(item1);
			A_repo.save(aucItem);
			
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}

	//History-------------------------------------------------------------------------------------------------------------------------------
	
	public ResponseEntity<List<Bidder>> ListofSelcetedandUnselectedBids(int id) {
		
		Optional <Transporter> trans= T_repo.findById(id);
		
		if(trans.isPresent()) {
		
			
			Transporter T=	trans.get();
			
			List<Bidder> Bid=T.getBidder();
			
			
			
			return new ResponseEntity<>(Bid,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
				
	}

	
	public ResponseEntity<Estimated_Price> getEstimatedPrice(int id) {
		
		Optional<Estimated_Price> estimatedPrice = E_repo.findByTransporterId(id);

		if (estimatedPrice.isPresent()) {
			return new ResponseEntity<>(estimatedPrice.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	//Pickup And Delivery Status----------------------------------------------------------------------------------------
	
	public ResponseEntity<List<Item_Detail>> ListofSelcetedItems(int t_id) {
		
		Optional <Transporter> trans= T_repo.findById(t_id);
		
		if(trans.isPresent()) {
		
			
			Transporter T=	trans.get();
			
			List<Bidder> Bid=T.getBidder();
			
			
			List<Integer> item_detail=new ArrayList<Integer>();
			
			for(Bidder b: Bid)
			{
				List<Item_Detail> iDetail=b.getItem_detail();
			
				if(b.getB_selection_status().equalsIgnoreCase("Selected")) {
				
				for(Item_Detail a: iDetail) {
					
					item_detail.add(a.getI_id());
				}
				}
				
			}
			
			List<Item_Detail> iDet=I_repo.findAllById(item_detail);
			
			return new ResponseEntity<>(iDet,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}

	public ResponseEntity<Item_Detail> set_PickUpDeliveryDate(int i_id, String pickupDate, String deliveryDate) {
		
		try {
			SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");
			
			Date d1=formatter1.parse(pickupDate);
			
			SimpleDateFormat formatter2=new SimpleDateFormat("yyyy-MM-dd");
			
			Date d2=formatter2.parse(deliveryDate);
			
			Item_Detail idetail=I_repo.getById(i_id);
			
			idetail.setPickup_date(d1);
			
			idetail.setDelivery_date(d2);

			return new ResponseEntity<>(I_repo.save(idetail),HttpStatus.OK);
		} catch (ParseException e) {
			
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}

	public ResponseEntity<Item_Detail> set_DeliveryStatus(int i_id) {
		try {


			Item_Detail idetail=I_repo.getById(i_id);
			
			
			idetail.setDelivery_status("Delivered");

			return new ResponseEntity<>(I_repo.save(idetail),HttpStatus.OK);
		} catch (Exception e) {
			
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}
}
