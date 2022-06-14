package com.aladhas.ALrestaurant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aladhas.ALrestaurant.model.Employees;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Long>{

	
	@Query("SELECT c from Employees c WHERE c.emp_job ='دليفري' ")
	List<Employees> getAllDelevery();
}
