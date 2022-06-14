package com.aladhas.ALrestaurant.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String emp;
	private Date acc_date;
	private int shift;
	private int bills;
	private int deleviry;
	private int takeAway;
	private int reception;
	private Double total_bills;
	private Double total_deleviry;
	private Double total_takeAway;
	private Double total_reception;
	private Double total_expenses;

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmp() {
		return emp;
	}

	public void setEmp(String emp) {
		this.emp = emp;
	}

	public Date getAcc_date() {
		return acc_date;
	}

	public void setAcc_date(Date acc_date) {
		this.acc_date = acc_date;
	}

	public int getShift() {
		return shift;
	}

	public void setShift(int shift) {
		this.shift = shift;
	}

	public int getBills() {
		return bills;
	}

	public void setBills(int bills) {
		this.bills = bills;
	}

	public int getDeleviry() {
		return deleviry;
	}

	public void setDeleviry(int deleviry) {
		this.deleviry = deleviry;
	}

	public int getTakeAway() {
		return takeAway;
	}

	public void setTakeAway(int takeAway) {
		this.takeAway = takeAway;
	}

	public int getReception() {
		return reception;
	}

	public void setReception(int reception) {
		this.reception = reception;
	}

	public Double getTotal_bills() {
		return total_bills;
	}

	public void setTotal_bills(Double total_bills) {
		this.total_bills = total_bills;
	}

	public Double getTotal_deleviry() {
		return total_deleviry;
	}

	public void setTotal_deleviry(Double total_deleviry) {
		this.total_deleviry = total_deleviry;
	}

	public Double getTotal_takeAway() {
		return total_takeAway;
	}

	public void setTotal_takeAway(Double total_takeAway) {
		this.total_takeAway = total_takeAway;
	}

	public Double getTotal_reception() {
		return total_reception;
	}

	public void setTotal_reception(Double total_reception) {
		this.total_reception = total_reception;
	}

	public Double getTotal_expenses() {
		return total_expenses;
	}

	public void setTotal_expenses(Double total_expenses) {
		this.total_expenses = total_expenses;
	}

}
