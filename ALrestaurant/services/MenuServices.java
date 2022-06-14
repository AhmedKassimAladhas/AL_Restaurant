package com.aladhas.ALrestaurant.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aladhas.ALrestaurant.model.Menu;
import com.aladhas.ALrestaurant.repository.MenuRepository;

@Service
public class MenuServices {

	@Autowired
	private MenuRepository menuRepository;

	public void addMenu(Menu menu) {
		menuRepository.save(menu);
	}

	public void deleteMenu(Long id) {
		menuRepository.deleteById(id);
	}

	public List<Menu> getAllMenu() {
		return menuRepository.findAll();
	}

	public Menu getMenu(Long id) {
		return menuRepository.findById(id).get();
	}
	
	public Optional<Menu> getImageById(Long id) {
		return menuRepository.findById(id);
	}
	
	public List<String> getMenuSections() {
		return menuRepository.getMenuSections();
	}

	public List<Menu> getAllMenuBySection(String sec_name) {
		return menuRepository.getAllMenuBySection(sec_name);
	}
}
