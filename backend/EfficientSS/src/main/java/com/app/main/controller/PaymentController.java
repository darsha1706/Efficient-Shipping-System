package com.app.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.main.model.Payment;
import com.app.main.service.PaymentService;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
public class PaymentController {
	
	@Autowired
	PaymentService P_service;

	//------------------------------------------------------------------------------------------------------------------------------
	
	@PostMapping("/customer/payment")
	public ResponseEntity<Payment> custPayment(@RequestBody Payment payment,@RequestParam int c_id,@RequestParam int i_id){
		
		return P_service.customerPayment(payment,c_id,i_id);
	}
	
	@GetMapping("/transporter/payment/{t_id}")
	public ResponseEntity<List<Payment>> transCheckPayment(@PathVariable ("t_id") int t_id){
		
		return P_service.transporterCheckPayment(t_id);
	}

	@GetMapping("/admin/payment")
	public ResponseEntity<List<Payment>> CheckPayment(){
		
		return P_service.CheckPayment();
	}

}
