package com.aladhas.ALrestaurant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aladhas.ALrestaurant.model.Dates;

@Repository
public interface DatesRepository extends JpaRepository<Dates, Long> {
	
	@Query("select d from Dates d where d.dat_number !=0")
	List<Dates> findAllWhere();
	
	@Query("SELECT d FROM Dates d WHERE d.time_from <= ?1 AND d.time_to >= ?2 ")
	Dates getShiftNumber(String time_from ,String time_to);
	
	@Query("select d from Dates d where d.dat_number =?1")
	Dates getAllByShiftNum(int shift);
}

