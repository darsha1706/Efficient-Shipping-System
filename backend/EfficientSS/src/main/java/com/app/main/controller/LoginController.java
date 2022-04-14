package com.app.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

//import org.springframework.web.bind.annotation.RestController;
import com.app.main.model.*;
import com.app.main.service.LoginService;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/home")
@Controller
public class LoginController {
	
	@Autowired
	LoginService loginservice;
	
	
	@PostMapping("/customer") 
	  public ResponseEntity<?> CustomerRegistration(@RequestBody Customer customer) {

		
		return loginservice.saveCustomer(customer);
	}
	
	@PostMapping("/transporter") 
	  public ResponseEntity<?> CustomerRegistration(@RequestBody Transporter transporter) {

		
			return loginservice.saveTransporter(transporter);		 	  
	}
	
	
	@PostMapping("/custlogin") 
	public ResponseEntity<Customer> CustomerLogin(@RequestBody Customer customer ) {

		loginservice.startMethod();
		return loginservice.validateCustomer(customer); 
	  }
	 
	@PostMapping("/translogin")
	public ResponseEntity<Transporter> TransporterLogin(@RequestBody Transporter transporter) {

		loginservice.startMethod();
		return loginservice.validateTransporter(transporter);
	}
	
	
	
	@PostMapping("/adminlogin")
	public ResponseEntity<Admin> AdminLogin(@RequestBody Admin admin) {

		loginservice.startMethod();
		return loginservice.validateAdmin(admin);
	}
	
}
