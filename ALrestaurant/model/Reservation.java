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
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Date date_reservation;
	private String time_reseravation;
	private String name_reservation;
	private String phone_reservation;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tab_id")
	private Tables tab_id;

	private String old;

	public Reservation() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate_reservation() {
		return date_reservation;
	}

	public void setDate_reservation(Date date_reservation) {
		this.date_reservation = date_reservation;
	}

	public String getTime_reseravation() {
		return time_reseravation;
	}

	public void setTime_reseravation(String time_reseravation) {
		this.time_reseravation = time_reseravation;
	}

	public String getName_reservation() {
		return name_reservation;
	}

	public void setName_reservation(String name_reservation) {
		this.name_reservation = name_reservation;
	}
	
	public String getPhone_reservation() {
		return phone_reservation;
	}

	public void setPhone_reservation(String phone_reservation) {
		this.phone_reservation = phone_reservation;
	}

	public Tables getTab_id() {
		return tab_id;
	}

	public void setTab_id(Tables tab_id) {
		this.tab_id = tab_id;
	}

	public String getOld() {
		return old;
	}

	public void setOld(String old) {
		this.old = old;
	}

}
