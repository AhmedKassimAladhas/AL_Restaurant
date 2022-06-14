package com.aladhas.ALrestaurant.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.aladhas.ALrestaurant.model.Role;
import com.aladhas.ALrestaurant.model.Users;
import com.aladhas.ALrestaurant.repository.RolesRepository;
import com.aladhas.ALrestaurant.repository.UsersRepository;
import com.aladhas.ALrestaurant.sec.MyUserDetails;

@Service
public class UsersServices implements UserDetailsService {

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private RolesRepository roleRepo;
	
	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = usersRepository.findByUser_name(username);

		if(user == null) {
			throw new UsernameNotFoundException("Not Found" + username);
		}
		return new MyUserDetails(user);
	}

	public void addUser(Users users) {
		users.setUser_password(getPasswordEncoder().encode(users.getUser_password()));
		usersRepository.save(users);
	}
	
	public void saveUser(Users users) {
		usersRepository.save(users);
	}

	public List<Users> getAllUsers() {
		return usersRepository.findAll();
	}

	public void deleteUsers(Long id) {
		usersRepository.deleteById(id);
	}

	public Users getUser(Long id) {
		return usersRepository.findById(id).get();
	}
	
	public Users getByUserName(String userName) {
		return usersRepository.findByUser_name(userName);
	}

	public List<Role> getAllRole() {
		return roleRepo.findAll();
	}
}
