package com.aladhas.ALrestaurant.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aladhas.ALrestaurant.model.Autonumber;
import com.aladhas.ALrestaurant.repository.AutonumberRepository;

@Service
public class AutonumberServices {

	@Autowired
	private AutonumberRepository auto;
	
	public void save(Autonumber aot) {
		auto.save(aot);
	}
	
	public int getName() {
		return auto.getNum();
	}
	
	public void deleteAll() {
		auto.deleteAll();
	}
}
