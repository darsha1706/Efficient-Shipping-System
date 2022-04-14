package com.app.main.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="c_id")
	private int C_id;
	@Column(name="c_first_name",nullable=false)
	private String C_first_name;
	@Column(name="c_middle_name",nullable=false)
	private String C_middle_name;
	@Column(name="c_last_name",nullable=false)
	private String C_last_name;
	@Column(name="c_email_id",nullable=false,unique=true)
	private String C_email_id;
	@Column(name="c_password",nullable=false)
	private String C_password;
	@Column(name="c_phone_no",nullable=false)
	private String C_phone_no;
	@Column(name="c_address")
	private String C_address;
	@Column(name="c_blacklist")
	private String C_blacklist;
	
	@JsonIgnore
	@OneToMany(mappedBy="customer")
	private List<Item_Detail> item_detail;
	
	@JsonIgnore
	@OneToMany(mappedBy="customer")
	private List<Auction_Item> auction_item;
	
	@JsonIgnore
	@OneToMany(mappedBy="customer")
	private List<Feedback_Complaint> feedback_complaint;

	@JsonIgnore
	@OneToMany(mappedBy="customer")
	private List<Payment> payment;

	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy="customer")
	    private List<Bidder> bidder;
	
	public Customer() {
		super();
	}


	public Customer(int c_id, String c_first_name, String c_middle_name, String c_last_name, String c_email_id,
			String c_password, String c_phone_no, String c_address, String c_blacklist, List<Item_Detail> item_detail,
			List<Auction_Item> auction_item, List<Feedback_Complaint> feedback_complaint, List<Payment> payment,
			List<Bidder> bidder) {
		super();
		C_id = c_id;
		C_first_name = c_first_name;
		C_middle_name = c_middle_name;
		C_last_name = c_last_name;
		C_email_id = c_email_id;
		C_password = c_password;
		C_phone_no = c_phone_no;
		C_address = c_address;
		C_blacklist = c_blacklist;
		this.item_detail = item_detail;
		this.auction_item = auction_item;
		this.feedback_complaint = feedback_complaint;
		this.payment = payment;
		this.bidder = bidder;
	}





	public int getC_id() {
		return C_id;
	}


	public void setC_id(int c_id) {
		C_id = c_id;
	}


	public String getC_first_name() {
		return C_first_name;
	}


	public void setC_first_name(String c_first_name) {
		C_first_name = c_first_name;
	}


	public String getC_middle_name() {
		return C_middle_name;
	}


	public void setC_middle_name(String c_middle_name) {
		C_middle_name = c_middle_name;
	}


	public String getC_last_name() {
		return C_last_name;
	}


	public void setC_last_name(String c_last_name) {
		C_last_name = c_last_name;
	}


	public String getC_email_id() {
		return C_email_id;
	}


	public void setC_email_id(String c_email_id) {
		C_email_id = c_email_id;
	}


	public String getC_password() {
		return C_password;
	}


	public void setC_password(String c_password) {
		C_password = c_password;
	}


	public String getC_phone_no() {
		return C_phone_no;
	}


	public void setC_phone_no(String c_phone_no) {
		C_phone_no = c_phone_no;
	}


	public String getC_address() {
		return C_address;
	}


	public void setC_address(String c_address) {
		C_address = c_address;
	}


	public String getC_blacklist() {
		return C_blacklist;
	}


	public void setC_blacklist(String c_blacklist) {
		C_blacklist = c_blacklist;
	}


	public List<Item_Detail> getItem_detail() {
		return item_detail;
	}


	public void setItem_detail(List<Item_Detail> item_detail) {
		this.item_detail = item_detail;
	}


	public List<Auction_Item> getAuction_item() {
		return auction_item;
	}


	public void setAuction_item(List<Auction_Item> auction_item) {
		this.auction_item = auction_item;
	}


	public List<Feedback_Complaint> getFeedback_complaint() {
		return feedback_complaint;
	}


	public void setFeedback_complaint(List<Feedback_Complaint> feedback_complaint) {
		this.feedback_complaint = feedback_complaint;
	}


	public List<Payment> getPayment() {
		return payment;
	}


	public void setPayment(List<Payment> payment) {
		this.payment = payment;
	}

	public List<Bidder> getBidder() {
		return bidder;
	}


	public void setBidder(List<Bidder> bidder) {
		this.bidder = bidder;
	}


	@Override
	public String toString() {
		return "Customer [C_id=" + C_id + ", C_first_name=" + C_first_name + ", C_middle_name=" + C_middle_name
				+ ", C_last_name=" + C_last_name + ", C_email_id=" + C_email_id + ", C_password=" + C_password
				+ ", C_phone_no=" + C_phone_no + ", C_address=" + C_address + ", C_blacklist=" + C_blacklist
				+ ", item_detail=" + item_detail + ", auction_item=" + auction_item + ", feedback_complaint="
				+ feedback_complaint + ", payment=" + payment + ", bidder=" + bidder + "]";
	}

	
}
