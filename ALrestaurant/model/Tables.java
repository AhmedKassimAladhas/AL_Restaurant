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
public class Tables {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tab_id;

	private String tab_num;
	private String tab_statues;
	private int tab_bill;
	private Date date_reserved;
	private String time_reserved;
	private String name_reserved;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "res_id")
	private Reservation res_id;

	public Tables() {
		// TODO Auto-generated constructor stub
	}

	public Long getTab_id() {
		return tab_id;
	}

	public void setTab_id(Long tab_id) {
		this.tab_id = tab_id;
	}

	public String getTab_num() {
		return tab_num;
	}

	public void setTab_num(String tab_num) {
		this.tab_num = tab_num;
	}

	public String getTab_statues() {
		return tab_statues;
	}

	public void setTab_statues(String tab_statues) {
		this.tab_statues = tab_statues;
	}

	public int getTab_bill() {
		return tab_bill;
	}

	public void setTab_bill(int tab_bill) {
		this.tab_bill = tab_bill;
	}

	public Date getDate_reserved() {
		return date_reserved;
	}

	public void setDate_reserved(Date date_reserved) {
		this.date_reserved = date_reserved;
	}
	
	public String getTime_reserved() {
		return time_reserved;
	}

	public void setTime_reserved(String time_reserved) {
		this.time_reserved = time_reserved;
	}

	public String getName_reserved() {
		return name_reserved;
	}

	public void setName_reserved(String name_reserved) {
		this.name_reserved = name_reserved;
	}

	public Reservation getRes_id() {
		return res_id;
	}

	public void setRes_id(Reservation res_id) {
		this.res_id = res_id;
	}


}
