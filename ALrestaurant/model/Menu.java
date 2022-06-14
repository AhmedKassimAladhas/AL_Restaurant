package com.aladhas.ALrestaurant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long men_id;

	private String men_section;
	private String men_name;
	private Double price_sale;
	private Double price_sale2;
	private Double price_buy;
	private String ingredients;
	private Double count;
	private String men_notes;
	@Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String image;

	public Menu() {
		// TODO Auto-generated constructor stub
	}

	public Long getMen_id() {
		return men_id;
	}

	public void setMen_id(Long men_id) {
		this.men_id = men_id;
	}

	public String getMen_section() {
		return men_section;
	}

	public void setMen_section(String men_section) {
		this.men_section = men_section;
	}

	public String getMen_name() {
		return men_name;
	}

	public void setMen_name(String men_name) {
		this.men_name = men_name;
	}

	public Double getPrice_sale() {
		return price_sale;
	}

	public void setPrice_sale(Double price_sale) {
		this.price_sale = price_sale;
	}
	
	public Double getPrice_sale2() {
		return price_sale2;
	}

	public void setPrice_sale2(Double price_sale2) {
		this.price_sale2 = price_sale2;
	}

	public Double getPrice_buy() {
		return price_buy;
	}

	public void setPrice_buy(Double price_buy) {
		this.price_buy = price_buy;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public Double getCount() {
		return count;
	}

	public void setCount(Double count) {
		this.count = count;
	}

	public String getMen_notes() {
		return men_notes;
	}

	public void setMen_notes(String men_notes) {
		this.men_notes = men_notes;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	

}
