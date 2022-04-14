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
public class Payment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="transaction_id")
	private int transaction_id;
	@Column(name="account_number",nullable=false)
	private String account_number;
	@Column(name="bank_balance")
	private long bank_balance;
	@Column(name="c_payment")
	private long c_payment;
	@Column(name="t_payment")
	private long t_payment;
	@Column(name="c_name")
	private String c_name;
	@Column(name="t_name")
	private String t_name;
	@Column(name="payment_status")
	private String payment_status;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="c_id",referencedColumnName="c_id")
	private Customer customer;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="i_id",referencedColumnName="i_id")
	private Item_Detail item_detail;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="t_id",referencedColumnName="t_id")
	private Transporter transporter;
	
	

	public Payment() {
		
	}

	public Payment(int transaction_id, String account_number, long bank_balance, long c_payment, long t_payment,
			String c_name, String t_name, String payment_status, Customer customer, Item_Detail item_detail,
			Transporter transporter) {
		super();
		this.transaction_id = transaction_id;
		this.account_number = account_number;
		this.bank_balance = bank_balance;
		this.c_payment = c_payment;
		this.t_payment = t_payment;
		this.c_name = c_name;
		this.t_name = t_name;
		this.payment_status = payment_status;
		this.customer = customer;
		this.item_detail = item_detail;
		this.transporter = transporter;
	}



	public int getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}

	public String getAccount_number() {
		return account_number;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}

	public long getBank_balance() {
		return bank_balance;
	}

	public void setBank_balance(long bank_balance) {
		this.bank_balance = bank_balance;
	}

	public long getC_payment() {
		return c_payment;
	}

	public void setC_payment(long c_payment) {
		this.c_payment = c_payment;
	}

	public long getT_payment() {
		return t_payment;
	}

	public void setT_payment(long t_payment) {
		this.t_payment = t_payment;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getT_name() {
		return t_name;
	}

	public void setT_name(String t_name) {
		this.t_name = t_name;
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
	
	public String getPayment_status() {
		return payment_status;
	}

	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}

	@Override
	public String toString() {
		return "Payment [transaction_id=" + transaction_id + ", account_number=" + account_number + ", bank_balance="
				+ bank_balance + ", C_payment=" + c_payment + ", T_payment=" + t_payment + ", C_name=" + c_name
				+ ", T_name=" + t_name + ", payment_status=" + payment_status + ", customer=" + customer
				+ ", item_detail=" + item_detail + ", transporter=" + transporter + "]";
	}

	
	
	
}
