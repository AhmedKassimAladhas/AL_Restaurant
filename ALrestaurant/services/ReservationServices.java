package com.aladhas.ALrestaurant.services;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aladhas.ALrestaurant.model.Reservation;
import com.aladhas.ALrestaurant.repository.ReservationRepository;

@Service
public class ReservationServices {

	@Autowired
	private ReservationRepository reservationRepository;
	
	public void save(Reservation resrevation) {
		reservationRepository.save(resrevation);
	}
	
	public List<Reservation> getAllReservation(){
		return reservationRepository.findAll();
	}
	
	public Reservation getOne(Long id) {
		return reservationRepository.findById(id).get();
	}
	
	public List<Reservation> getAllReservationByOld(){
		return reservationRepository.getAllByOld();
	}
	
	public void StartReservation() {		
		java.util.Date utilDate = new java.util.Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
		String stringDate= dateFormat.format(utilDate);
		String stringTime= timeFormat.format(utilDate);
		Date date =  Date.valueOf(stringDate);
//		System.out.println("today :" + date);
//		System.out.println("today :" + stringTime.substring(0,2));
		List<Reservation> r = getAllReservation();
		if(r.isEmpty()) {			
//			System.out.println("no Reservation");		
			}else {			
//			System.out.println("Hello..Reservation");
				for(Reservation i : r) {					
//					System.out.println("today Reservation:" + i.getDate_reservation().getTime());				
//					System.out.println("today Reservation:" + date.getTime());
//		        	System.out.println("today Reservation:" + i.getTime_reseravation().substring(0,2));					
		        	if(i.getTime_reseravation().substring(0,2).equalsIgnoreCase(stringTime.substring(0,2)) & i.getDate_reservation().getTime() == date.getTime() & i.getOld() == null) {		        	
		        		System.out.println("yes");
		        		i.getTab_id().setDate_reserved(i.getDate_reservation());
		        		i.getTab_id().setTime_reserved(i.getTime_reseravation());
		        		i.getTab_id().setName_reserved(i.getName_reservation());
		        		i.getTab_id().setTab_statues("receved");
		        		i.getTab_id().setRes_id(i);
		        		save(i);
		        	}else {
//		        		System.out.println("end Reservation");
		        	}
		        }			
			}
	}
	
}
