package com.aladhas.ALrestaurant.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Bill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bill_id;

	private int bill_number;
	private Date bill_date;
	private String bill_time;
	private String bill_emp;
	private String bill_type;
	private Double bill_total_Buy;
	private Double bill_total_Sale;
	private Double bill_discount;
	private Double tax;
	private Double delevery_cost;
	private Double bill_total;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cust_id")
	private Customers cust_id;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "tab_id")
	private Tables tab_id;

	private String bill_delverymen;
	private String bill_notes;
	private String bill_Status;
	private String delivery_status;

	public Bill() {
		// TODO Auto-generated constructor stub
	}

	public Long getBill_id() {
		return bill_id;
	}

	public void setBill_id(Long bill_id) {
		this.bill_id = bill_id;
	}

	public int getBill_number() {
		return bill_number;
	}

	public void setBill_number(int bill_number) {
		this.bill_number = bill_number;
	}

	public Date getBill_date() {
		return bill_date;
	}

	public void setBill_date(Date bill_date) {
		this.bill_date = bill_date;
	}

	public String getBill_time() {
		return bill_time;
	}

	public void setBill_time(String bill_time) {
		this.bill_time = bill_time;
	}

	public String getBill_emp() {
		return bill_emp;
	}

	public void setBill_emp(String bill_emp) {
		this.bill_emp = bill_emp;
	}

	public String getBill_type() {
		return bill_type;
	}

	public void setBill_type(String bill_type) {
		this.bill_type = bill_type;
	}

	public Double getBill_total_Buy() {
		return bill_total_Buy;
	}

	public void setBill_total_Buy(Double bill_total_Buy) {
		this.bill_total_Buy = bill_total_Buy;
	}

	public Double getBill_total_Sale() {
		return bill_total_Sale;
	}

	public void setBill_total_Sale(Double bill_total_Sale) {
		this.bill_total_Sale = bill_total_Sale;
	}

	public Double getBill_discount() {
		return bill_discount;
	}

	public void setBill_discount(Double bill_discount) {
		this.bill_discount = bill_discount;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

	public Double getDelevery_cost() {
		return delevery_cost;
	}

	public void setDelevery_cost(Double delevery_cost) {
		this.delevery_cost = delevery_cost;
	}

	public Double getBill_total() {
		return bill_total;
	}

	public void setBill_total(Double bill_total) {
		this.bill_total = bill_total;
	}

	public Customers getCust_id() {
		return cust_id;
	}

	public void setCust_id(Customers cust_id) {
		this.cust_id = cust_id;
	}

	public Tables getTab_id() {
		return tab_id;
	}

	public void setTab_id(Tables tab_id) {
		this.tab_id = tab_id;
	}

	public String getBill_delverymen() {
		return bill_delverymen;
	}

	public void setBill_delverymen(String bill_delverymen) {
		this.bill_delverymen = bill_delverymen;
	}

	public String getBill_notes() {
		return bill_notes;
	}

	public void setBill_notes(String bill_notes) {
		this.bill_notes = bill_notes;
	}

	public String getBill_Status() {
		return bill_Status;
	}

	public void setBill_Status(String bill_Status) {
		this.bill_Status = bill_Status;
	}

	public String getDelivery_status() {
		return delivery_status;
	}

	public void setDelivery_status(String delivery_status) {
		this.delivery_status = delivery_status;
	}

}
