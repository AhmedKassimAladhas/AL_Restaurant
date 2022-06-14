package com.aladhas.ALrestaurant.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cust_id;

	private String cust_name;
	private String cust_phone;
	private String cust_address;
	private String cust_notes;

	public Customers() {
		// TODO Auto-generated constructor stub
	}

	public Customers(Long cust_id, String cust_name, String cust_phone, String cust_address, String cust_notes) {
		super();
		this.cust_id = cust_id;
		this.cust_name = cust_name;
		this.cust_phone = cust_phone;
		this.cust_address = cust_address;
		this.cust_notes = cust_notes;
	}

	public Long getCust_id() {
		return cust_id;
	}

	public void setCust_id(Long cust_id) {
		this.cust_id = cust_id;
	}

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public String getCust_phone() {
		return cust_phone;
	}

	public void setCust_phone(String cust_phone) {
		this.cust_phone = cust_phone;
	}

	public String getCust_address() {
		return cust_address;
	}

	public void setCust_address(String cust_address) {
		this.cust_address = cust_address;
	}

	public String getCust_notes() {
		return cust_notes;
	}

	public void setCust_notes(String cust_notes) {
		this.cust_notes = cust_notes;
	}

}
