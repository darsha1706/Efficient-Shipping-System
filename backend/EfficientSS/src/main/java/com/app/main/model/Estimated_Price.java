package com.app.main.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Estimated_Price {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="e_price_Id")
	private int E_price_Id;
	//Value will be price/kg
	@Column(name="range_0_200")
	private int range_0_200;
	@Column(name="range_200_500")
	private int range_200_500;
	@Column(name="range_500_above")
	private int range_500_above;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="t_id",referencedColumnName="t_id")
	private Transporter transporter;

	
	public Estimated_Price() {
		
	}

	public Estimated_Price(int e_price_Id, int range_0_200, int range_200_500, int range_500_above,
			Transporter transporter) {
		super();
		E_price_Id = e_price_Id;
		this.range_0_200 = range_0_200;
		this.range_200_500 = range_200_500;
		this.range_500_above = range_500_above;
		this.transporter = transporter;
	}



	public int getE_price_Id() {
		return E_price_Id;
	}

	public void setE_price_Id(int e_price_Id) {
		E_price_Id = e_price_Id;
	}

	public int getRange_0_200() {
		return range_0_200;
	}

	public void setRange_0_200(int range_0_200) {
		this.range_0_200 = range_0_200;
	}

	public int getRange_200_500() {
		return range_200_500;
	}

	public void setRange_200_500(int range_200_500) {
		this.range_200_500 = range_200_500;
	}

	public int getRange_500_above() {
		return range_500_above;
	}

	public void setRange_500_above(int range_500_above) {
		this.range_500_above = range_500_above;
	}

	public Transporter getTransporter() {
		return transporter;
	}

	public void setTransporter(Transporter transporter) {
		this.transporter = transporter;
	}

	@Override
	public String toString() {
		return "Estimated_Price [E_price_Id=" + E_price_Id + ", range_0_200=" + range_0_200 + ", range_200_500="
				+ range_200_500 + ", range_500_above=" + range_500_above + ", transporter=" + transporter + "]";
	}
	
	
	
}
