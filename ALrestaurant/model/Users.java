package com.aladhas.ALrestaurant.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class Users {

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long user_id;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "emp_id")
	private Employees emp_id;

	@Column(name = "user_name")
	private String user_name;

	private String user_password;
	private boolean active;
	private String themes;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "users_roles",
	joinColumns = @JoinColumn(name = "user_id"),
	inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	public Users() {
		// TODO Auto-generated constructor stub
	}

	public Users(Long user_id, Employees emp_id, String user_name, String user_password, boolean active,
			Set<Role> roles,String themes) {
		super();
		this.user_id = user_id;
		this.emp_id = emp_id;
		this.user_name = user_name;
		this.user_password = user_password;
		this.active = active;
		this.roles = roles;
		this.themes = themes;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public Employees getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Employees emp_id) {
		this.emp_id = emp_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public void addRoles(Role role) {
		this.roles.add(role);
	}
	
	public void removeRoles(Set<Role> set) {
		this.roles.removeAll(set);
	}

	public String getThemes() {
		return themes;
	}

	public void setThemes(String themes) {
		this.themes = themes;
	}
	
	
}
