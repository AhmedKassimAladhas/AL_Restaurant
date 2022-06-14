package com.aladhas.ALrestaurant.model;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Menu_Details {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long det_id;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cat_id")
	private Categories cat_id;
	
	private String det_name;
	private Double det_count;
	
	public Menu_Details() {
		// TODO Auto-generated constructor stub
	}

	public Long getDet_id() {
		return det_id;
	}

	public void setDet_id(Long det_id) {
		this.det_id = det_id;
	}

	public Categories getCat_id() {
		return cat_id;
	}

	public void setCat_id(Categories cat_id) {
		this.cat_id = cat_id;
	}

	public String getDet_name() {
		return det_name;
	}

	public void setDet_name(String det_name) {
		this.det_name = det_name;
	}

	public Double getDet_count() {
		return det_count;
	}

	public void setDet_count(Double det_count) {
		this.det_count = det_count;
	}

	
	
	
}
