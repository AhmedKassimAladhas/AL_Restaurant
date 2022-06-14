package com.aladhas.ALrestaurant.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aladhas.ALrestaurant.model.Shifts;

@Repository
public interface ShiftsRepository extends JpaRepository<Shifts, Long> {

	@Query("select s from Shifts s where ?1 between s.dat_from and s.dat_to")
	List<Shifts> findBydate(Date date);
	
}
