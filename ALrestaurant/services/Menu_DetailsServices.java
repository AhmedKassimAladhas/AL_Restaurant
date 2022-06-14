package com.aladhas.ALrestaurant.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aladhas.ALrestaurant.model.Menu_Details;
import com.aladhas.ALrestaurant.repository.Menu_DetailsRepository;

@Service
public class Menu_DetailsServices {

	@Autowired
	private Menu_DetailsRepository detailsRepository;

	public void adddetails(Menu_Details details) {
		detailsRepository.save(details);
	}

	public List<Menu_Details> getِllDetails() {
		return detailsRepository.findAll();
	}
	
	public List<String> getMenuName() {
		return detailsRepository.getMenuName();
	}

	public List<String> getIngredients(String name) {

		return detailsRepository.getIngredients(name);
	}
	
	public void deleteDetail(Long det_id) {
		detailsRepository.deleteById(det_id);
	}
}
