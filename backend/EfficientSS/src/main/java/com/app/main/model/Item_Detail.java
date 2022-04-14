package com.app.main.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Item_Detail {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="i_id")
	private int I_id;
	@Column(name="i_name",nullable=false)
	private String I_name;
	@Column(name="i_weight",nullable=false)
	private String I_weight;
	@Column(name="description")
	private String description;
	@Column(name="pickup_location",nullable=false)
	private String pickup_location;
	@Column(name="pickup_state",nullable=false)
	private String pickup_state;
	@Column(name="pickup_city",nullable=false)
	private String pickup_city;
	@Column(name="delivery_location")
	private String delivery_location;
	@Column(name="delivery_state")
	private String delivery_state;
	@Column(name="delivery_city")
	private String delivery_city;
	@Column(name="delivery_status")
	private String delivery_status;
	@Column(name="i_image",nullable=false)
	private String I_image;
	@Column(name="delivery_date")
	private Date delivery_date;
	@Column(name="pickup_date")
    private Date pickup_date;
	@Column(name="operation_status")
    private String operation_status;
	
	
	
    @ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="c_id",referencedColumnName="c_id")
	private Customer customer;
    
    @JsonIgnore
	@OneToOne(mappedBy="item_detail")
	private Auction_Item auction_item;
	
    @JsonIgnore
	@OneToMany(mappedBy="item_detail")
	private List<Feedback_Complaint> feedback_complaint;

	@JsonIgnore
	@OneToMany(mappedBy="item_detail")
	private List<Payment> payment;

	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy="item_detail")
    private List<Bidder> bidder;

	

	public Item_Detail() {
		
		
	}

	public Item_Detail(int i_id, String i_name, String i_weight, String description, String pickup_location,
			String pickup_state, String pickup_city, String delivery_location, String delivery_state,
			String delivery_city, String delivery_status, String i_image, Date delivery_date, Date pickup_date,
			String operation_status,Customer customer, Auction_Item auction_item, List<Feedback_Complaint> feedback_complaint,
			List<Payment> payment, List<Bidder> bidder) {
		super();
		I_id = i_id;
		I_name = i_name;
		I_weight = i_weight;
		this.description = description;
		this.pickup_location = pickup_location;
		this.pickup_state = pickup_state;
		this.pickup_city = pickup_city;
		this.delivery_location = delivery_location;
		this.delivery_state = delivery_state;
		this.delivery_city = delivery_city;
		this.delivery_status = delivery_status;
		I_image = i_image;
		this.delivery_date = delivery_date;
		this.pickup_date = pickup_date;
		this.operation_status= operation_status;
		this.customer = customer;
		this.auction_item = auction_item;
		this.feedback_complaint = feedback_complaint;
		this.payment = payment;
		this.bidder = bidder;
	}



	public int getI_id() {
		return I_id;
	}

	public void setI_id(int i_id) {
		I_id = i_id;
	}

	public String getI_name() {
		return I_name;
	}

	public void setI_name(String i_name) {
		I_name = i_name;
	}

	public String getI_weight() {
		return I_weight;
	}

	public void setI_weight(String i_weight) {
		I_weight = i_weight;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPickup_location() {
		return pickup_location;
	}

	public void setPickup_location(String pickup_location) {
		this.pickup_location = pickup_location;
	}

	public String getPickup_state() {
		return pickup_state;
	}

	public void setPickup_state(String pickup_state) {
		this.pickup_state = pickup_state;
	}

	public String getPickup_city() {
		return pickup_city;
	}

	public void setPickup_city(String pickup_city) {
		this.pickup_city = pickup_city;
	}

	public String getDelivery_location() {
		return delivery_location;
	}

	public void setDelivery_location(String delivery_location) {
		this.delivery_location = delivery_location;
	}

	public String getDelivery_state() {
		return delivery_state;
	}

	public void setDelivery_state(String delivery_state) {
		this.delivery_state = delivery_state;
	}

	public String getDelivery_city() {
		return delivery_city;
	}

	public void setDelivery_city(String delivery_city) {
		this.delivery_city = delivery_city;
	}

	public String getDelivery_status() {
		return delivery_status;
	}

	public void setDelivery_status(String delivery_status) {
		this.delivery_status = delivery_status;
	}

	public String getI_image() {
		return I_image;
	}

	public void setI_image(String i_image) {
		I_image = i_image;
	}

	public Date getDelivery_date() {
		return delivery_date;
	}

	public void setDelivery_date(Date delivery_date) {
		this.delivery_date = delivery_date;
	}

	public Date getPickup_date() {
		return pickup_date;
	}

	public void setPickup_date(Date pickup_date) {
		this.pickup_date = pickup_date;
	}
	
	public String getOperation_status() {
		return operation_status;
	}

	public void setOperation_status(String operation_status) {
		this.operation_status = operation_status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Auction_Item getAuction_item() {
		return auction_item;
	}

	public void setAuction_item(Auction_Item auction_item) {
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
		return "Item_Detail [I_id=" + I_id + ", I_name=" + I_name + ", I_weight=" + I_weight + ", description="
				+ description + ", pickup_location=" + pickup_location + ", pickup_state=" + pickup_state
				+ ", pickup_city=" + pickup_city + ", delivery_location=" + delivery_location + ", delivery_state="
				+ delivery_state + ", delivery_city=" + delivery_city + ", delivery_status=" + delivery_status
				+ ", I_image=" + I_image + ", delivery_date=" + delivery_date + ", pickup_date=" + pickup_date
				+ ", customer=" + customer + ", auction_item=" + auction_item + ", feedback_complaint="
				+ feedback_complaint + ", payment=" + payment + ", bidder=" + bidder + "]";
	}

	


}
