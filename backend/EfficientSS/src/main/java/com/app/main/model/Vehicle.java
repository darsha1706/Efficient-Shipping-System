package com.app.main.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Vehicle {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="v_id")
	private int V_id;
	@Column(name="v_type",nullable=false)
	private String V_type;
	@Column(name="v_reg_no",nullable=false)
	private String V_reg_no;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="t_id",referencedColumnName="t_id")
	private Transporter transporter;
	
	@JsonIgnore
	 @ManyToMany(mappedBy="vehicle")
	    private List<Driver> driver;

	 
	public Vehicle() {
		
	}


	public Vehicle(int v_id, String v_type, String v_reg_no, Transporter transporter, List<Driver> driver) {
		super();
		V_id = v_id;
		V_type = v_type;
		V_reg_no = v_reg_no;
		this.transporter = transporter;
		this.driver = driver;
	}

	public int getV_id() {
		return V_id;
	}

	public void setV_id(int v_id) {
		V_id = v_id;
	}

	public String getV_type() {
		return V_type;
	}

	public void setV_type(String v_type) {
		V_type = v_type;
	}

	public String getV_reg_no() {
		return V_reg_no;
	}

	public void setV_reg_no(String v_reg_no) {
		V_reg_no = v_reg_no;
	}

	public Transporter getTransporter() {
		return transporter;
	}

	public void setTransporter(Transporter transporter) {
		this.transporter = transporter;
	}

	public List<Driver> getDriver() {
		return driver;
	}

	public void setDriver(List<Driver> driver) {
		this.driver = driver;
	}

	@Override
	public String toString() {
		return "Vehicle [V_id=" + V_id + ", V_type=" + V_type + ", V_reg_no=" + V_reg_no + ", transporter="
				+ transporter + ", driver=" + driver + "]";
	}
	 
	 
}
