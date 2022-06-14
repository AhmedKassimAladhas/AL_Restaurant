package com.aladhas.ALrestaurant.sec;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	UserDetailsService userDetailsService;
	

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
		
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
//		auth.userDetailsService(userDetailsService);
		auth.authenticationProvider(authenticationProvider());
	}

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http
			.authorizeRequests()
			.antMatchers("/resources/**","/ALRestaurant/error").permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.formLogin()
			.permitAll()
			.loginPage("/ALRestaurant/login")
			.usernameParameter("username")
			.passwordParameter("password")
			.loginProcessingUrl("/dologin")
			.failureUrl("/ALRestaurant/error")
			.defaultSuccessUrl("/ALRestaurant/Home")
			.and()
			.logout()
			.permitAll()
			.logoutUrl("/dologout")
			.logoutSuccessUrl("/ALRestaurant/logout")
//			.and()
//			.exceptionHandling().accessDeniedPage("/403")
			;
	}
	
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManager();
	}

	
}
