package com.aladhas.ALrestaurant.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sections {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sec_id;

	private String sec_name;


	public Sections() {
		// TODO Auto-generated constructor stub
	}

	public Sections(Long sec_id, String sec_name) {
		super();
		this.sec_id = sec_id;
		this.sec_name = sec_name;
	}

	public Long getSec_id() {
		return sec_id;
	}

	public void setSec_id(Long sec_id) {
		this.sec_id = sec_id;
	}

	public String getSec_name() {
		return sec_name;
	}

	public void setSec_name(String sec_name) {
		this.sec_name = sec_name;
	}

	

}
