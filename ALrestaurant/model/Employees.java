package com.aladhas.ALrestaurant.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Employees {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long emp_id;

	private String emp_name;
	private String emp_phone;
	private String emp_job;
	private String emp_gender;
	private String emp_insurance;
	private Double emp_salary;
	private String user;
	
	@OneToMany(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "emp_id")
	private Set<Users> users;
	
	@OneToMany
	@JoinColumn(name = "emp_id")
	private Set<Shifts> shift;
	
	public Employees() {
		// TODO Auto-generated constructor stub
	}

	

	public Employees(Long emp_id, String emp_name, String emp_phone, String emp_job, String emp_gender,
			String emp_insurance, Double emp_salary) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_phone = emp_phone;
		this.emp_job = emp_job;
		this.emp_gender = emp_gender;
		this.emp_insurance = emp_insurance;
		this.emp_salary = emp_salary;
	}

	public Long getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Long emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getEmp_phone() {
		return emp_phone;
	}

	public void setEmp_phone(String emp_phone) {
		this.emp_phone = emp_phone;
	}

	public String getEmp_job() {
		return emp_job;
	}

	public void setEmp_job(String emp_job) {
		this.emp_job = emp_job;
	}

	public String getEmp_gender() {
		return emp_gender;
	}

	public void setEmp_gender(String emp_gender) {
		this.emp_gender = emp_gender;
	}

	public String getEmp_insurance() {
		return emp_insurance;
	}

	public void setEmp_insurance(String emp_insurance) {
		this.emp_insurance = emp_insurance;
	}

	public Double getEmp_salary() {
		return emp_salary;
	}

	public void setEmp_salary(Double emp_salary) {
		this.emp_salary = emp_salary;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}


	public Set<Users> getUsers() {
		return users;
	}



	public void setUsers(Set<Users> users) {
		this.users = users;
	}



	public Set<Shifts> getShift() {
		return shift;
	}



	public void setShift(Set<Shifts> shift) {
		this.shift = shift;
	}

	
	
	
}
