package com.app.main.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.main.model.Admin;
import com.app.main.model.Auction_Item;
import com.app.main.model.Customer;
import com.app.main.model.Transporter;
import com.app.main.repository.AdminRepo;
import com.app.main.repository.AuctionItemRepo;
import com.app.main.repository.CustomerRepo;
import com.app.main.repository.TransporterRepo;

@Service
public class LoginService {

	@Autowired
	CustomerRepo C_repo;

	@Autowired
	TransporterRepo T_repo;
	
	@Autowired
	AdminRepo A_repo;
	
	@Autowired
	AuctionItemRepo A_I_repo;
	
	public ResponseEntity<?> saveCustomer(Customer customer) {
		
		try {
			customer.setC_blacklist("Clear");
			C_repo.save(customer);
			
			
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}

	public ResponseEntity<?> saveTransporter(Transporter transporter) {
		
		try {
			transporter.setT_verification("Pending");
			transporter.setT_blacklist("Clear");
			T_repo.save(transporter);
			
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}	
	}

	
		
	public ResponseEntity<Customer> validateCustomer(Customer customer) {
		
		Customer cust=C_repo.findByEmail(customer.getC_email_id());
		
		if(cust.getC_email_id().equals(customer.getC_email_id()) && cust.getC_password().equals(customer.getC_password()) && cust.getC_blacklist().equalsIgnoreCase("Clear"))
			return new ResponseEntity<>(cust,HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<Transporter> validateTransporter(Transporter transporter) {
		
		try {
			Transporter trans=T_repo.findByEmail(transporter.getT_email_id());
			
			if(trans.getT_email_id().equals(transporter.getT_email_id()) && trans.getT_password().equals(transporter.getT_password()) && trans.getT_verification().equalsIgnoreCase("Done") && trans.getT_blacklist().equalsIgnoreCase("Clear"))
				return new ResponseEntity<>(trans,HttpStatus.OK);
			else
				return new ResponseEntity<>(HttpStatus.CONFLICT);
		} catch (Exception e) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	

	public ResponseEntity<Admin> validateAdmin(Admin admin) {
		
		Admin adm=A_repo.findByEmail(admin.getA_email_id());
		
		if(adm.getA_email_id().equals(admin.getA_email_id()) && adm.getA_password().equals(admin.getA_password()))
			return new ResponseEntity<>(adm,HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	
	
	public void startMethod() { 
	LocalDate localDate = LocalDate.now();
	 
	
	List<Auction_Item> alist=A_I_repo.getAllAuctionItem();	
	
	if(alist.isEmpty()) {
		//Do Nothing
	}else {
		
		for(Auction_Item a: alist) 
		{
			try {
			SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");
			
				Date d1=formatter1.parse(a.getA_end_datetime());
				int x=d1.getDate();
				int y=localDate.getDayOfMonth();
				
				int z=y-x;	//0 or positive			times up
							//negative 				running
				
				if(z>=0) {
					a.setTimer("Expired");
					if(a.getA_item_status().equalsIgnoreCase("Running"))
					{
						a.setA_item_status("No bid");
						
					}
					A_I_repo.save(a);
				}
				
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
			
		}
	}
	}
	
}
