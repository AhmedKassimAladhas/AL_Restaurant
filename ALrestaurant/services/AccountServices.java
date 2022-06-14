package com.aladhas.ALrestaurant.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aladhas.ALrestaurant.model.Account;
import com.aladhas.ALrestaurant.repository.AccountRepository;

@Service
public class AccountServices {

	@Autowired
	private AccountRepository accountRepository;
	
	public void save(Account acc) {
		accountRepository.save(acc);
	}
	
	public List<Account> getAllaccount(){
		return accountRepository.findAll();
	}
	
	public List<Account> getAllaccountByDate(Date date){
		return accountRepository.findByDateAccount(date);
	}
}
