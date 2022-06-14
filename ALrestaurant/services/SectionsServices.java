package com.aladhas.ALrestaurant.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aladhas.ALrestaurant.model.Sections;
import com.aladhas.ALrestaurant.repository.SectionsRepository;

@Service
public class SectionsServices {

	@Autowired
	private SectionsRepository sectionsRepository;

	public void addSection(Sections sec) {
		sectionsRepository.save(sec);
	}

	public void deleteSection(Long id) {
		sectionsRepository.deleteById(id);
	}

	public List<Sections> getAllSections() {
		return sectionsRepository.findAll();
	}

	public Sections getSection(Long id) {
		return sectionsRepository.findById(id).get();
	}
}
