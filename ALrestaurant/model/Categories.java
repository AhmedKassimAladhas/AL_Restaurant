package com.aladhas.ALrestaurant.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Categories {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cat_id;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "sec_id")
	private Sections sec_id;

	private String cat_name;
	private String measuring;
	private Double cat_count;


	public Categories() {
		// TODO Auto-generated constructor stub
	}

	public Categories(Long cat_id, Sections sec_id, String cat_name, Double cat_count) {
		super();
		this.cat_id = cat_id;
		this.sec_id = sec_id;
		this.cat_name = cat_name;
		this.cat_count = cat_count;
	}

	public Long getCat_id() {
		return cat_id;
	}

	public void setCat_id(Long cat_id) {
		this.cat_id = cat_id;
	}

	public Sections getSec_id() {
		return sec_id;
	}

	public void setSec_id(Sections sec_id) {
		this.sec_id = sec_id;
	}

	public String getCat_name() {
		return cat_name;
	}

	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}

	public String getMeasuring() {
		return measuring;
	}

	public void setMeasuring(String measuring) {
		this.measuring = measuring;
	}

	public Double getCat_count() {
		return cat_count;
	}

	public void setCat_count(Double cat_count) {
		this.cat_count = cat_count;
	}


	

}
