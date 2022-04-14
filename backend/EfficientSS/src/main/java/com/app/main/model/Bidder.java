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

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Bidder {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="b_id")
	private int B_id;
	@Column(name="b_price",nullable=false)
	private int B_price;
	@Column(name="b_name")
	private String B_name;
	@Column(name="b_ph_no")
	private String B_ph_no;
	@Column(name="b_selection_status")
	private String B_selection_status;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="t_id",referencedColumnName="t_id")
	private Transporter transporter;
	
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name="Auction_Item_Bidder", 
                joinColumns={@JoinColumn(name="b_id")}, 
                inverseJoinColumns={@JoinColumn(name="a_id")})
    private List<Auction_Item> auction_item;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name="Item_Detail_Bidder",
                joinColumns={@JoinColumn(name="b_id")}, 
                inverseJoinColumns={@JoinColumn(name="i_id")})
    private List<Item_Detail> item_detail;
    
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name="Customer_Bidder",
                joinColumns={@JoinColumn(name="b_id")}, 
                inverseJoinColumns={@JoinColumn(name="c_id")})
    private List<Customer> customer;
   

	public Bidder() {
		super();
	}

	public Bidder(int b_id, int b_price, String b_name, String b_ph_no, String b_selection_status,
			Transporter transporter, List<Auction_Item> auction_item, List<Item_Detail> item_detail,
			List<Customer> customer) {
		super();
		B_id = b_id;
		B_price = b_price;
		B_name = b_name;
		B_ph_no = b_ph_no;
		B_selection_status = b_selection_status;
		this.transporter = transporter;
		this.auction_item = auction_item;
		this.item_detail = item_detail;
		this.customer = customer;
	}

	public int getB_id() {
		return B_id;
	}

	public void setB_id(int b_id) {
		B_id = b_id;
	}

	public int getB_price() {
		return B_price;
	}

	public void setB_price(int b_price) {
		B_price = b_price;
	}

	public String getB_name() {
		return B_name;
	}

	public void setB_name(String b_name) {
		B_name = b_name;
	}

	public String getB_ph_no() {
		return B_ph_no;
	}

	public void setB_ph_no(String b_ph_no) {
		B_ph_no = b_ph_no;
	}

	public String getB_selection_status() {
		return B_selection_status;
	}

	public void setB_selection_status(String b_selection_status) {
		B_selection_status = b_selection_status;
	}

	public Transporter getTransporter() {
		return transporter;
	}

	public void setTransporter(Transporter transporter) {
		this.transporter = transporter;
	}

	public List<Auction_Item> getAuction_item() {
		return auction_item;
	}

	public void setAuction_item(List<Auction_Item> auction_item) {
		this.auction_item = auction_item;
	}

	public List<Item_Detail> getItem_detail() {
		return item_detail;
	}

	public void setItem_detail(List<Item_Detail> item_detail) {
		this.item_detail = item_detail;
	}

	public List<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}
	
	@Override
	public String toString() {
		return "Bidder [B_id=" + B_id + ", B_price=" + B_price + ", B_name=" + B_name + ", B_ph_no=" + B_ph_no
				+ ", B_selection_status=" + B_selection_status + ", transporter=" + transporter + ", auction_item="
				+ auction_item + ", item_detail=" + item_detail + ", customer=" + customer + "]";
	}
    
}
