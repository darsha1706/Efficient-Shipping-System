package com.app.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.main.model.Bidder;
import com.app.main.model.Customer;
import com.app.main.model.Item_Detail;
import com.app.main.model.Payment;
import com.app.main.model.Transporter;
import com.app.main.repository.CustomerRepo;
import com.app.main.repository.ItemRepo;
import com.app.main.repository.PaymentRepo;
import com.app.main.repository.TransporterRepo;

@Service
public class PaymentService {

	@Autowired
	CustomerRepo C_repo;
	
	@Autowired
	ItemRepo I_repo;
	
	@Autowired
	TransporterRepo T_repo;
	
	@Autowired
	PaymentRepo P_Repo;
	
	//-------------------------------------------------------------------------------------------------------------------
	
	public ResponseEntity<Payment> customerPayment(Payment payment,int c_id, int i_id) {
		
		
		try {
			Customer cust=C_repo.getById(c_id);
			
			Item_Detail idetail=I_repo.getById(i_id);
			
			Transporter trans = new Transporter();
			
			List<Bidder> bid=idetail.getBidder();
			
			for (Bidder b: bid) {
				if(b.getB_selection_status().equalsIgnoreCase("Selected")) {
					trans=b.getTransporter();
				}
			}
			
			Long profit=((payment.getC_payment()*30)/100);
					
			Long Bank_bal=payment.getBank_balance()+profit;
			
			payment.setBank_balance(Bank_bal);
			payment.setT_payment(payment.getC_payment()-profit);
			
			payment.setC_name(cust.getC_first_name()+" "+cust.getC_middle_name()+" "+cust.getC_last_name());
			payment.setPayment_status("Done");
			payment.setT_name(trans.getT_first_name()+" "+trans.getT_middle_name()+" "+trans.getT_last_name());
			
			payment.setCustomer(cust);
			payment.setItem_detail(idetail);
			payment.setTransporter(trans);
			
			Payment pay=P_Repo.save(payment);
			
			return new ResponseEntity<>(pay,HttpStatus.OK);
		
		} catch (Exception e) {
			
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
		
		
		
	}

	public ResponseEntity<List<Payment>> transporterCheckPayment(int t_id) {
		
		try {
			List<Payment> payments=P_Repo.getbyTransporterId(t_id);
			
			if(payments.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<>(payments,HttpStatus.OK);
			}
		} catch (Exception e) {
			
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
			
		}
		
	}

	public ResponseEntity<List<Payment>> CheckPayment() {
		
		try{
			List<Payment> payments=P_Repo.findAll();
		
			return new ResponseEntity<>(payments,HttpStatus.OK);
		
		} catch (Exception e) {
	
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	
		}
	}
	
}
