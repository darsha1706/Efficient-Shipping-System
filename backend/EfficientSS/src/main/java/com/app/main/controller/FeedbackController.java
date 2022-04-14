package com.app.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.main.model.Feedback_Complaint;
import com.app.main.service.FeedCompService;

@CrossOrigin(origins = "http://localhost:3000")

@Controller
public class FeedbackController {
	
	@Autowired
	FeedCompService FC_service; 

	@PostMapping("/customer/feedback")
	public ResponseEntity<Feedback_Complaint> custFeedback(@RequestBody Feedback_Complaint feedback,@RequestParam int c_id){
		
		return FC_service.customerFeedback(feedback,c_id);								//pass -1 if customer do not fill i_id , t_id
	}
	
	@PostMapping("/transporter/feedback")
	public ResponseEntity<Feedback_Complaint> transFeedback(@RequestBody Feedback_Complaint feedback,@RequestParam int t_id){
		
		return FC_service.transporterFeedback(feedback,t_id);								//pass -1 if customer do not fill i_id , c_id
	}
	
	@GetMapping("/admin/feedback")
	public ResponseEntity<List<Feedback_Complaint>> feedbackComplaint(){
		
		return FC_service.feedbackComp();
	}
}
