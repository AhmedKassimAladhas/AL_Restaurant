package com.aladhas.ALrestaurant.sec;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.aladhas.ALrestaurant.model.Role;
import com.aladhas.ALrestaurant.model.Users;

public class MyUserDetails implements UserDetails {

	private String UserName;
	private String Password;
	private boolean Active;
	private List<GrantedAuthority> authorities;
	private String empName;
	private String themes;
	
	public MyUserDetails(Users user) {
		this.UserName = user.getUser_name();
		this.Password = user.getUser_password();
		this.Active = user.isActive();
//		this.authorities = Arrays.stream(user.gETROLES().SPLIT(","))
//				.MAP(SIMPLEGRANTEDAUTHORITY :: NEW)
//				.COLLECT(COLLECTORS.TOLIST());
		Set<Role> roles = user.getRoles();
		List<GrantedAuthority> authorities = new ArrayList<>();
		for(Role role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		this.authorities = authorities;
		this.empName = user.getEmp_id().getEmp_name();
		this.themes = user.getThemes();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return Password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return UserName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return Active;
	}

	public String getempName() {
		return empName;
	}
	
	@Bean
	public String getThemes() {
		if(themes == null) {
			themes = "bootstrapD";
		}
		return themes;
	}

	public void setThemes(String themes) {
		this.themes = themes;
	}
	
	
}
