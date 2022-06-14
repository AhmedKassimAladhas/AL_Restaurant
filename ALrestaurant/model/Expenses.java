package com.aladhas.ALrestaurant.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Expenses {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long exp_id;

	private String exp_empName;
	private Date exp_date;
	private String exp_time;
	private String expense;
	private Double exp_cost;
	private String exp_notes;

	public Expenses() {
		// TODO Auto-generated constructor stub
	}

	public Expenses(Long exp_id, String exp_empName, Date exp_date, String exp_time, String expense, Double exp_cost,
			String exp_notes) {
		super();
		this.exp_id = exp_id;
		this.exp_empName = exp_empName;
		this.exp_date = exp_date;
		this.exp_time = exp_time;
		this.expense = expense;
		this.exp_cost = exp_cost;
		this.exp_notes = exp_notes;
	}

	public Long getExp_id() {
		return exp_id;
	}

	public void setExp_id(Long exp_id) {
		this.exp_id = exp_id;
	}

	public String getExp_empName() {
		return exp_empName;
	}

	public void setExp_empName(String exp_empName) {
		this.exp_empName = exp_empName;
	}

	public Date getExp_date() {
		return exp_date;
	}

	public void setExp_date(Date exp_date) {
		this.exp_date = exp_date;
	}

	public String getExp_time() {
		return exp_time;
	}

	public void setExp_time(String exp_time) {
		this.exp_time = exp_time;
	}

	public String getExpense() {
		return expense;
	}

	public void setExpense(String expense) {
		this.expense = expense;
	}

	public Double getExp_cost() {
		return exp_cost;
	}

	public void setExp_cost(Double exp_cost) {
		this.exp_cost = exp_cost;
	}

	public String getExp_notes() {
		return exp_notes;
	}

	public void setExp_notes(String exp_notes) {
		this.exp_notes = exp_notes;
	}

}
