package com.aladhas.ALrestaurant.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Dates {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long dat_id;
	
	private int dat_number;
	private String time_from;
	private String time_to;

	@OneToMany
	@JoinColumn(name = "dat_friday")
	private Set<Shifts> shift;
;
	
	public Dates() {
		// TODO Auto-generated constructor stub
	}

	public Dates(Long dat_id, int dat_number, String time_from, String time_to) {
		super();
		this.dat_id = dat_id;
		this.dat_number = dat_number;
		this.time_from = time_from;
		this.time_to = time_to;
	}

	public Long getDat_id() {
		return dat_id;
	}

	public void setDat_id(Long dat_id) {
		this.dat_id = dat_id;
	}

	public int getDat_number() {
		return dat_number;
	}

	public void setDat_number(int dat_number) {
		this.dat_number = dat_number;
	}

	public String getTime_from() {
		return time_from;
	}

	public void setTime_from(String time_from) {
		this.time_from = time_from;
	}

	public String getTime_to() {
		return time_to;
	}

	public void setTime_to(String time_to) {
		this.time_to = time_to;
	}

	
	
}
