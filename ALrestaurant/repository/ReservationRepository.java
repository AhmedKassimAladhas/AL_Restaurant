package com.aladhas.ALrestaurant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aladhas.ALrestaurant.model.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long>{

	@Query("SELECT r from Reservation r WHERE r.old != old")
	List<Reservation> getAllByOld();
		
}
