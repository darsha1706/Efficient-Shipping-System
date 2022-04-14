package com.app.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.app.main.model.*;
import com.app.main.service.AdminService;


@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/admin")
@Controller
public class AdminController {

	
	@Autowired
	AdminService A_service;
	
	@GetMapping("/transporter")
	public ResponseEntity<List<Transporter>> AllTransporter(){
		
		return A_service.getAllTransporter();
		
	}

	@PutMapping("/transverification/{id}")
	public ResponseEntity<Transporter> verifyTransporter(@PathVariable("id") int id){
		
		return A_service.verifySingleTransporter(id);
		
	}
	
	@PutMapping("/transblacklist/{id}")
	public ResponseEntity<Transporter> blockTransporter(@PathVariable("id") int id){
		
		return A_service.blockSingleTransporter(id);
	}
	
	
	//--------------------------------------------------------------------------------------------------------------------
	
	
	
	@GetMapping("/customer")
	public ResponseEntity<List<Customer>> AllCustomer(){
		
		return A_service.getAllCustomer();
		
	}
	
	
	@PutMapping("/customer/{id}")
	public ResponseEntity<Customer> blockCustomer(@PathVariable("id") int id){
		
		return A_service.blockSingleCustomer(id);
	}
	

}
