package com.aladhas.ALrestaurant.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Bill_Line {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long lin_id;

	private int lin_number;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "bill_id")
	private Bill bill_id;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "men_id")
	private Menu men_id;

	private Double price_buy;
	private Double price_sale;
	private int lin_count;
	private Double lin_totalbuy;
	private Double lin_totalsale;
	private Date lin_date;

	public Bill_Line() {
		// TODO Auto-generated constructor stub
	}

	public Long getLin_id() {
		return lin_id;
	}

	public void setLin_id(Long lin_id) {
		this.lin_id = lin_id;
	}

	public int getLin_number() {
		return lin_number;
	}

	public void setLin_number(int lin_number) {
		this.lin_number = lin_number;
	}

	public Bill getBill_id() {
		return bill_id;
	}

	public void setBill_id(Bill bill_id) {
		this.bill_id = bill_id;
	}

	public Menu getMen_id() {
		return men_id;
	}

	public void setMen_id(Menu men_id) {
		this.men_id = men_id;
	}

	public Double getPrice_buy() {
		return price_buy;
	}

	public void setPrice_buy(Double price_buy) {
		this.price_buy = price_buy;
	}

	public Double getPrice_sale() {
		return price_sale;
	}

	public void setPrice_sale(Double price_sale) {
		this.price_sale = price_sale;
	}

	public int getLin_count() {
		return lin_count;
	}

	public void setLin_count(int lin_count) {
		this.lin_count = lin_count;
	}

	public Double getLin_totalbuy() {
		return lin_totalbuy;
	}

	public void setLin_totalbuy(Double lin_totalbuy) {
		this.lin_totalbuy = lin_totalbuy;
	}

	public Double getLin_totalsale() {
		return lin_totalsale;
	}

	public void setLin_totalsale(Double lin_totalsale) {
		this.lin_totalsale = lin_totalsale;
	}

	public Date getLin_date() {
		return lin_date;
	}

	public void setLin_date(Date lin_date) {
		this.lin_date = lin_date;
	}

}
