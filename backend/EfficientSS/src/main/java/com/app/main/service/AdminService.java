package com.app.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.main.model.Customer;
import com.app.main.model.Transporter;
import com.app.main.repository.CustomerRepo;
import com.app.main.repository.TransporterRepo;

@Service
public class AdminService {

	@Autowired
	TransporterRepo T_repo;
	
	@Autowired
	CustomerRepo C_repo;

	
	public ResponseEntity<List<Transporter>> getAllTransporter() {
		
		List<Transporter> transporter=T_repo.findAll();
		
		if(transporter.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		else
		return new ResponseEntity<>(transporter, HttpStatus.OK);
	}


	public ResponseEntity<Transporter> verifySingleTransporter(int id) {
		
		Optional<Transporter> oldTransporter = T_repo.findById(id);
		
		if(oldTransporter.isPresent())
		{
			Transporter newTransporter=oldTransporter.get();
			newTransporter.setT_verification("Done");
			
			
			return new ResponseEntity<>(T_repo.save(newTransporter),HttpStatus.OK);
		}
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	
	public ResponseEntity<Transporter> blockSingleTransporter(int id) {

		Optional<Transporter> oldTransporter = T_repo.findById(id);
		
		if(oldTransporter.isPresent())
		{
			Transporter newTransporter=oldTransporter.get();
			if(newTransporter.getT_verification().equalsIgnoreCase("Done")) {
			
				if(newTransporter.getT_blacklist().equalsIgnoreCase("Clear")) {
					
					newTransporter.setT_blacklist("Block");
				}else {
					newTransporter.setT_blacklist("Clear");
				}
				
				
			//newTransporter.setT_blacklist(transporter.getT_blacklist());
			
			return new ResponseEntity<>(T_repo.save(newTransporter),HttpStatus.OK);
			}
			else
				return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	
	//-----------------------------------------------------------------------------------------------------
	
	
	
	public ResponseEntity<List<Customer>> getAllCustomer() {
		
		List<Customer> customer=C_repo.findAll();
		
		if(customer.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		else
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}	
	
	
	
	
	public ResponseEntity<Customer> blockSingleCustomer(int id) {
		
		Optional<Customer> oldCustomer = C_repo.findById(id);
		
		if(oldCustomer.isPresent())
		{
			Customer newCustomer=oldCustomer.get();
			
			
				if(newCustomer.getC_blacklist().equalsIgnoreCase("Clear")) {
					
					newCustomer.setC_blacklist("Block");
				}else {
					newCustomer.setC_blacklist("Clear");
				}
				
			
			return new ResponseEntity<>(C_repo.save(newCustomer),HttpStatus.OK);
			
		}
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	
	
}
