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
public class Shifts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long shif_id;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "emp_id")
	private Employees emp_id;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "dat_saturday")
	private Dates dat_saturday;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "dat_sunday")
	private Dates dat_sunday;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "dat_monday")
	private Dates dat_monday;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "dat_tuesday")
	private Dates dat_tuesday;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "dat_wednesday")
	private Dates dat_wednesday;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "dat_thursday")
	private Dates dat_thursday;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "dat_friday")
	private Dates dat_friday;

	private Date dat_from;
	private Date dat_to;

	public Shifts() {
		// TODO Auto-generated constructor stub
	}

	public Shifts(Long shif_id, Employees emp_id, Dates dat_saturday, Dates dat_sunday, Dates dat_monday,
			Dates dat_tuesday, Dates dat_wednesday, Dates dat_thursday, Dates dat_friday, Date dat_from, Date dat_to) {
		super();
		this.shif_id = shif_id;
		this.emp_id = emp_id;
		this.dat_saturday = dat_saturday;
		this.dat_sunday = dat_sunday;
		this.dat_monday = dat_monday;
		this.dat_tuesday = dat_tuesday;
		this.dat_wednesday = dat_wednesday;
		this.dat_thursday = dat_thursday;
		this.dat_friday = dat_friday;
		this.dat_from = dat_from;
		this.dat_to = dat_to;
	}

	public Long getShif_id() {
		return shif_id;
	}

	public void setShif_id(Long shif_id) {
		this.shif_id = shif_id;
	}

	public Employees getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Employees emp_id) {
		this.emp_id = emp_id;
	}

	public Dates getDat_saturday() {
		return dat_saturday;
	}

	public void setDat_saturday(Dates dat_saturday) {
		this.dat_saturday = dat_saturday;
	}

	public Dates getDat_sunday() {
		return dat_sunday;
	}

	public void setDat_sunday(Dates dat_sunday) {
		this.dat_sunday = dat_sunday;
	}

	public Dates getDat_monday() {
		return dat_monday;
	}

	public void setDat_monday(Dates dat_monday) {
		this.dat_monday = dat_monday;
	}

	public Dates getDat_tuesday() {
		return dat_tuesday;
	}

	public void setDat_tuesday(Dates dat_tuesday) {
		this.dat_tuesday = dat_tuesday;
	}

	public Dates getDat_wednesday() {
		return dat_wednesday;
	}

	public void setDat_wednesday(Dates dat_wednesday) {
		this.dat_wednesday = dat_wednesday;
	}

	public Dates getDat_thursday() {
		return dat_thursday;
	}

	public void setDat_thursday(Dates dat_thursday) {
		this.dat_thursday = dat_thursday;
	}

	public Dates getDat_friday() {
		return dat_friday;
	}

	public void setDat_friday(Dates dat_friday) {
		this.dat_friday = dat_friday;
	}

	public Date getDat_from() {
		return dat_from;
	}

	public void setDat_from(Date dat_from) {
		this.dat_from = dat_from;
	}

	public Date getDat_to() {
		return dat_to;
	}

	public void setDat_to(Date dat_to) {
		this.dat_to = dat_to;
	}

}
