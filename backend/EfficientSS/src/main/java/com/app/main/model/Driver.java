package com.app.main.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;



@Entity
public class Driver {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="d_id")
	private int D_id;
	@Column(name="d_first_name",nullable=false)
	private String D_first_name;
	@Column(name="d_middle_name",nullable=false)
	private String D_middle_name;
	@Column(name="d_last_name",nullable=false)
	private String D_last_name;
	@Column(name="d_email_id",nullable=false)
	private String D_email_id;
	@Column(name="d_ph_no",nullable=false)
	private String D_ph_no;
	@Column(name="d_Licence_no",nullable=false)
	private String D_Licence_no;
	

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="t_id",referencedColumnName="t_id")
	private Transporter transporter;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinTable(name="Driver_Vehicle", 
                joinColumns={@JoinColumn(name="d_id")}, 
                inverseJoinColumns={@JoinColumn(name="v_id")})
    private List<Vehicle> vehicle;
	
	
	public Driver() {
		
	}
	
	public Driver(int d_id, String d_first_name, String d_middle_name, String d_last_name, String d_email_id,
			String d_ph_no, String d_Licence_no, Transporter transporter, List<Vehicle> vehicle) {
		super();
		D_id = d_id;
		D_first_name = d_first_name;
		D_middle_name = d_middle_name;
		D_last_name = d_last_name;
		D_email_id = d_email_id;
		D_ph_no = d_ph_no;
		D_Licence_no = d_Licence_no;
		this.transporter = transporter;
		this.vehicle = vehicle;
	}



	public int getD_id() {
		return D_id;
	}
	public void setD_id(int d_id) {
		D_id = d_id;
	}
	public String getD_first_name() {
		return D_first_name;
	}
	public void setD_first_name(String d_first_name) {
		D_first_name = d_first_name;
	}
	public String getD_middle_name() {
		return D_middle_name;
	}
	public void setD_middle_name(String d_middle_name) {
		D_middle_name = d_middle_name;
	}
	public String getD_last_name() {
		return D_last_name;
	}
	public void setD_last_name(String d_last_name) {
		D_last_name = d_last_name;
	}
	public String getD_email_id() {
		return D_email_id;
	}
	public void setD_email_id(String d_email_id) {
		D_email_id = d_email_id;
	}
	public String getD_ph_no() {
		return D_ph_no;
	}
	public void setD_ph_no(String d_ph_no) {
		D_ph_no = d_ph_no;
	}
	public String getD_Licence_no() {
		return D_Licence_no;
	}
	public void setD_Licence_no(String d_Licence_no) {
		D_Licence_no = d_Licence_no;
	}
	
	public Transporter getTransporter() {
		return transporter;
	}
	public void setTransporter(Transporter transporter) {
		this.transporter = transporter;
	}

	public List<Vehicle> getVehicle() {
		return vehicle;
	}

	public void setVehicle(List<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}

	@Override
	public String toString() {
		return "Driver [D_id=" + D_id + ", D_first_name=" + D_first_name + ", D_middle_name=" + D_middle_name
				+ ", D_last_name=" + D_last_name + ", D_email_id=" + D_email_id + ", D_ph_no=" + D_ph_no
				+ ", D_Licence_no=" + D_Licence_no + ", transporter=" + transporter + ", vehicle=" + vehicle + "]";
	}
	
	
}
