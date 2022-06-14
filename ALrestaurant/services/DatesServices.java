package com.aladhas.ALrestaurant.services;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aladhas.ALrestaurant.model.Dates;
import com.aladhas.ALrestaurant.repository.DatesRepository;

@Service
public class DatesServices {

	@Autowired
	private DatesRepository datesRepository;

	public void addDates(Dates dates) {
		datesRepository.save(dates);
	}

	public void deleteDate(Long id) {
		datesRepository.deleteById(id);
	}

	public List<Dates> getAllDates() {
		return datesRepository.findAll();
	}

	public List<Dates> getAllDatesWhere() {
		return datesRepository.findAllWhere();
	}
	
	public Dates getDate(Long id) {
		return datesRepository.findById(id).get();
	}
	
	public Dates getDateByShiftNum(int shift) {
		return datesRepository.getAllByShiftNum(shift);
	}
	
	public int getShiftNumber() {
		java.util.Date utilDate = new java.util.Date();
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
		String stringTime= timeFormat.format(utilDate);
		Dates d = datesRepository.getShiftNumber(stringTime, stringTime);
		int shift = 0;
		if(d != null) {
			shift = d.getDat_number();
			return shift;
		}else {
			return shift;
		}
		
	}
}
