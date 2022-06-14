package com.aladhas.ALrestaurant.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aladhas.ALrestaurant.model.Categories;
import com.aladhas.ALrestaurant.repository.CategoriesRepository;

@Service
public class CategoriesServices {

	@Autowired
	private CategoriesRepository categoriesRepository;

	public void addCategorie(Categories categories) {
		categoriesRepository.save(categories);
	}

	public void deleteCategorie(Long id) {
		categoriesRepository.deleteById(id);
	}

	public List<Categories> getAllCategoris() {
		return categoriesRepository.findAll();
	}

	public Categories getCategorie(Long id) {
		return categoriesRepository.findById(id).get();
	}
	
	public List<Categories> getCategorieBySec(String sec) {
		return categoriesRepository.getCategoriesBySection(sec);
	}
	
}
