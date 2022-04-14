package com.app.main.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Feedback_Complaint {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="fc_id")
	private int FC_id;
	@Column(name="c_name")
	private String C_name;
	@Column(name="t_name")
	private String T_name;
	@Column(name="description")
	private String description;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="c_id",referencedColumnName="c_id")
	private Customer customer;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="i_id",referencedColumnName="i_id")
	private Item_Detail item_detail;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="t_id",referencedColumnName="t_id")
	private Transporter transporter;

	
	
	public Feedback_Complaint() {
		
	}

	public Feedback_Complaint(int fC_id, String c_name, String t_name, String description, Customer customer,
			Item_Detail item_detail, Transporter transporter) {
		super();
		FC_id = fC_id;
		C_name = c_name;
		T_name = t_name;
		this.description = description;
		this.customer = customer;
		this.item_detail = item_detail;
		this.transporter = transporter;
	}


	public int getFC_id() {
		return FC_id;
	}

	public void setFC_id(int fC_id) {
		FC_id = fC_id;
	}
	
	public String getC_name() {
		return C_name;
	}

	public void setC_name(String c_name) {
		C_name = c_name;
	}

	public String getT_name() {
		return T_name;
	}

	public void setT_name(String t_name) {
		T_name = t_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Item_Detail getItem_detail() {
		return item_detail;
	}

	public void setItem_detail(Item_Detail item_detail) {
		this.item_detail = item_detail;
	}

	public Transporter getTransporter() {
		return transporter;
	}

	public void setTransporter(Transporter transporter) {
		this.transporter = transporter;
	}

	@Override
	public String toString() {
		return "Feedback_Complaint [FC_id=" + FC_id + ", C_name=" + C_name + ", T_name=" + T_name + ", description="
				+ description + ", customer=" + customer + ", item_detail=" + item_detail + ", transporter="
				+ transporter + "]";
	}
	
	
	
	
	
}
