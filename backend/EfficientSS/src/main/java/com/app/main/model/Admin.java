package com.app.main.model;


import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Admin")
public class Admin {
	
	
	@Id
	@Column(name="a_email_id")
	private String A_email_id;
	
	@Column(name="a_password",nullable=false)
	private String A_password;
	
	@Column(name="a_ph_no",nullable=false)
	private String A_ph_no;

	
	public Admin() {
		
//		A_email_id = "Admin";
//		A_password = "Admin@123";
//		A_ph_no = 1234567890;
	}


	public Admin(String a_email_id, String a_password, String a_ph_no) {
		super();
		A_email_id = a_email_id;
		A_password = a_password;
		A_ph_no = a_ph_no;
	}


	public String getA_email_id() {
		return A_email_id;
	}


	public void setA_email_id(String a_email_id) {
		A_email_id = a_email_id;
	}


	public String getA_password() {
		return A_password;
	}


	public void setA_password(String a_password) {
		A_password = a_password;
	}


	public String getA_ph_no() {
		return A_ph_no;
	}


	public void setA_ph_no(String a_ph_no) {
		A_ph_no = a_ph_no;
	}


	@Override
	public String toString() {
		return "Admin [A_email_id=" + A_email_id + ", A_password=" + A_password + ", A_ph_no=" + A_ph_no + "]";
	}


	
}
