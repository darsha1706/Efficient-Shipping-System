package com.app.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.main.model.Customer;
import com.app.main.model.Feedback_Complaint;
import com.app.main.model.Item_Detail;
import com.app.main.model.Transporter;
import com.app.main.repository.CustomerRepo;
import com.app.main.repository.FeedCompRepo;
import com.app.main.repository.ItemRepo;
import com.app.main.repository.TransporterRepo;

@Service
public class FeedCompService {
	
	@Autowired
	CustomerRepo C_repo;
	
	@Autowired
	ItemRepo I_repo;
	
	@Autowired
	TransporterRepo T_repo;

	@Autowired
	FeedCompRepo FC_repo;
	
	public ResponseEntity<Feedback_Complaint> customerFeedback(Feedback_Complaint feedback, int c_id) {
		
		try {
			Customer cust=C_repo.getById(c_id);
			feedback.setCustomer(cust);
			
			feedback.setC_name(cust.getC_first_name()+" "+cust.getC_middle_name()+" "+cust.getC_last_name());
			
			
//			if(i_id != -1)
//			{
//				Optional<Item_Detail> item=I_repo.findById(i_id);
//				
//				if(item.isPresent()) {
//
//					Item_Detail idetail;
//					
//					idetail=item.get();
//					feedback.setItem_detail(idetail);
//				}
//			}
			
//			if(t_id != -1)
//			{
//				Optional<Transporter> transporter=T_repo.findById(t_id);
//				
//				if(transporter.isPresent()) {
//					
//					Transporter trans;
//					
//					trans=transporter.get();
//					feedback.setTransporter(trans);
//				}
//			}
			
			Feedback_Complaint feedcomp=FC_repo.save(feedback);
			
			return new ResponseEntity<>(feedcomp,HttpStatus.CREATED);
		} catch (Exception e) {
			
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}

	public ResponseEntity<Feedback_Complaint> transporterFeedback(Feedback_Complaint feedback, int t_id) {
		
		try {
			Transporter trans=T_repo.getById(t_id);
			feedback.setTransporter(trans);
			
			feedback.setT_name(trans.getT_first_name()+" "+trans.getT_middle_name()+" "+trans.getT_last_name());
			
			
//			if(i_id != -1)
//			{
//				Optional<Item_Detail> item=I_repo.findById(i_id);
//				
//				if(item.isPresent()) {
//
//					Item_Detail idetail;
//					
//					idetail=item.get();
//					feedback.setItem_detail(idetail);
//				}
//			}
//			
//			if(c_id != -1)
//			{
//				Optional<Customer> customer=C_repo.findById(c_id);
//				
//				if(customer.isPresent()) {
//					
//					Customer cust;
//					
//					cust=customer.get();
//					feedback.setCustomer(cust);
//				}
//			}
			
			Feedback_Complaint feedcomp=FC_repo.save(feedback);
			
			return new ResponseEntity<>(feedcomp,HttpStatus.CREATED);
		} catch (Exception e) {
			
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}

	public ResponseEntity<List<Feedback_Complaint>> feedbackComp() {
		
		try {
			List<Feedback_Complaint> fclist=FC_repo.findAll();
			
			return new ResponseEntity<>(fclist,HttpStatus.OK);
		} catch (Exception e) {
			
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}

	
}
