package com.app.main.model;

import java.util.List; 


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="Transporter")
public class Transporter {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="t_id")
	private int T_id;
	@Column(name="t_first_name",nullable=false)
	private String T_first_name;
	@Column(name="t_middle_name",nullable=false)
	private String T_middle_name;
	@Column(name="t_last_name",nullable=false)
	private String T_last_name;
	@Column(name="t_email_id",nullable=false,unique=true)
	private String T_email_id;
	@Column(name="t_aadhar_no",nullable=false,unique=true)
	private String T_aadhar_no;
	@Column(name="t_password",nullable=false)
	private String T_password;
	@Column(name="t_ph_no",nullable=false)
	private String T_ph_no;
	@Column(name="t_address",nullable=false)
	private String T_address;
	
	@Column(name="t_verification",columnDefinition="varchar(50) default 'Pending'",nullable=false)
	private String T_verification;
	@Column(name="t_blacklist",columnDefinition="varchar(50) default 'Clear'",nullable=false)
	private String T_blacklist;
	
	@JsonIgnore
	@OneToMany(mappedBy="transporter")
	private List<Driver> driver;
	
	@JsonIgnore
	@OneToMany(mappedBy="transporter")
	private List<Vehicle> vehicle;
	
	@JsonIgnore
	@OneToMany(mappedBy="transporter")
	private List<Bidder> bidder;
	
	@JsonIgnore
	@OneToMany(mappedBy="transporter")
	private List<Feedback_Complaint> feedback_complaint;
	
	@JsonIgnore
	@OneToMany(mappedBy="transporter")
	private List<Payment> payment;
	
	@JsonIgnore
	@OneToOne(mappedBy="transporter")
	private Estimated_Price estimated_price;
	
	

	public Transporter() {
		super();
	}	

	public Transporter(int t_id, String t_first_name, String t_middle_name, String t_last_name, String t_email_id,
			String t_aadhar_no, String t_password, String t_ph_no, String t_address, String t_verification,
			String t_blacklist, List<Driver> driver, List<Vehicle> vehicle, List<Bidder> bidder,
			List<Feedback_Complaint> feedback_complaint, List<Payment> payment, Estimated_Price estimated_price) {
		super();
		T_id = t_id;
		T_first_name = t_first_name;
		T_middle_name = t_middle_name;
		T_last_name = t_last_name;
		T_email_id = t_email_id;
		T_aadhar_no = t_aadhar_no;
		T_password = t_password;
		T_ph_no = t_ph_no;
		T_address = t_address;
		T_verification = t_verification;
		T_blacklist = t_blacklist;
		this.driver = driver;
		this.vehicle = vehicle;
		this.bidder = bidder;
		this.feedback_complaint = feedback_complaint;
		this.payment = payment;
		this.estimated_price = estimated_price;
	}

	public int getT_id() {
		return T_id;
	}

	public void setT_id(int t_id) {
		T_id = t_id;
	}

	public String getT_first_name() {
		return T_first_name;
	}

	public void setT_first_name(String t_first_name) {
		T_first_name = t_first_name;
	}

	public String getT_middle_name() {
		return T_middle_name;
	}

	public void setT_middle_name(String t_middle_name) {
		T_middle_name = t_middle_name;
	}

	public String getT_last_name() {
		return T_last_name;
	}

	public void setT_last_name(String t_last_name) {
		T_last_name = t_last_name;
	}

	public String getT_email_id() {
		return T_email_id;
	}

	public void setT_email_id(String t_email_id) {
		T_email_id = t_email_id;
	}

	public String getT_aadhar_no() {
		return T_aadhar_no;
	}

	public void setT_aadhar_no(String t_aadhar_no) {
		T_aadhar_no = t_aadhar_no;
	}

	public String getT_password() {
		return T_password;
	}

	public void setT_password(String t_password) {
		T_password = t_password;
	}

	public String getT_ph_no() {
		return T_ph_no;
	}

	public void setT_ph_no(String t_ph_no) {
		T_ph_no = t_ph_no;
	}

	public String getT_address() {
		return T_address;
	}

	public void setT_address(String t_address) {
		T_address = t_address;
	}

	

	public String getT_verification() {
		return T_verification;
	}

	public void setT_verification(String t_verification) {
		T_verification = t_verification;
	}

	public String getT_blacklist() {
		return T_blacklist;
	}

	public void setT_blacklist(String t_blacklist) {
		T_blacklist = t_blacklist;
	}

	public List<Driver> getDriver() {
		return driver;
	}

	public void setDriver(List<Driver> driver) {
		this.driver = driver;
	}

	public List<Vehicle> getVehicle() {
		return vehicle;
	}

	public void setVehicle(List<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}

	public List<Bidder> getBidder() {
		return bidder;
	}

	public void setBidder(List<Bidder> bidder) {
		this.bidder = bidder;
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

	public Estimated_Price getEstimated_price() {
		return estimated_price;
	}

	public void setEstimated_price(Estimated_Price estimated_price) {
		this.estimated_price = estimated_price;
	}

	@Override
	public String toString() {
		return "Transporter [T_id=" + T_id + ", T_first_name=" + T_first_name + ", T_middle_name=" + T_middle_name
				+ ", T_last_name=" + T_last_name + ", T_email_id=" + T_email_id + ", T_aadhar_no=" + T_aadhar_no
				+ ", T_password=" + T_password + ", T_ph_no=" + T_ph_no + ", T_address=" + T_address
				+ ", T_verification=" + T_verification + ", T_blacklist=" + T_blacklist + ", driver=" + driver
				+ ", vehicle=" + vehicle + ", bidder=" + bidder + ", feedback_complaint=" + feedback_complaint
				+ ", payment=" + payment + ", estimated_price=" + estimated_price + "]";
	}
	
}