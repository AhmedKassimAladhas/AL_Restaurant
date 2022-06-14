package com.aladhas.ALrestaurant.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aladhas.ALrestaurant.model.Other;
import com.aladhas.ALrestaurant.repository.OtherRepository;

import java.util.List;

@Service
public class OtherServices {

	@Autowired
	private OtherRepository otherRepository;

	public void saveOther(Other other) {
		otherRepository.save(other);
	}

	public List<Other> getAllOther() {
		return otherRepository.findAll();
	}

	public Other getOtherById(Long id) {
		return otherRepository.findById(id).get();
	}
}
