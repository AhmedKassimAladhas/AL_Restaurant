package com.aladhas.ALrestaurant.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aladhas.ALrestaurant.model.Employees;
import com.aladhas.ALrestaurant.repository.EmployeesRepository;

@Service
public class EmployeesServices {

	@Autowired
	private EmployeesRepository empRepository;

	public void addEmp(Employees emp) {
		empRepository.save(emp);
	}

	public void deleteEmp(Long id) {
		empRepository.deleteById(id);
	}

	public List<Employees> getAllEmp() {
		return empRepository.findAll();
	}

	public Employees getEmp(Long id) {
		return empRepository.findById(id).get();
	}
	
	public List<Employees> getAllDelevery() {
		return empRepository.getAllDelevery();
	}
}
