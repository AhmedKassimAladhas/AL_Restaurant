package com.aladhas.ALrestaurant.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aladhas.ALrestaurant.model.Customers;
import com.aladhas.ALrestaurant.repository.CustomersRepository;

@Service
public class CustomersServices {

	@Autowired
	private CustomersRepository customersRepository;

	public void addCustomer(Customers customers) {
		customersRepository.save(customers);
	}

	public void deleteCustomer(Long id) {
		customersRepository.deleteById(id);
	}

	public List<Customers> getAllCustomers() {
		return customersRepository.findAll();
	}

	public Customers getCustomer(Long id) {
		return customersRepository.findById(id).get();
	}
	
	public Customers getCustomerByPhone(String Phone) {
		return customersRepository.getCustByPhone(Phone);
	}
	
}
