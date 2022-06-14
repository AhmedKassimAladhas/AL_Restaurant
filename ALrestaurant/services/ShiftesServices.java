package com.aladhas.ALrestaurant.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aladhas.ALrestaurant.model.Shifts;
import com.aladhas.ALrestaurant.repository.ShiftsRepository;

@Service
public class ShiftesServices {

	@Autowired
	private ShiftsRepository shiftsRepository;

	public void addShift(Shifts shifts) {
		shiftsRepository.save(shifts);
	}

	public void deleteSift(Long id) {
		shiftsRepository.deleteById(id);
	}

	public List<Shifts> getAllShifts() {
		return shiftsRepository.findAll();
	}

	public Shifts getShift(Long id) {
		return shiftsRepository.findById(id).get();
	}
	
	public List<Shifts> getShiftByDate(Date date) {
		return shiftsRepository.findBydate(date);
	}
}
