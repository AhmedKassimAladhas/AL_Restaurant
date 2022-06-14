package com.aladhas.ALrestaurant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aladhas.ALrestaurant.model.Menu_Details;

public interface Menu_DetailsRepository extends JpaRepository<Menu_Details, Long>{

	@Query("SELECT DISTINCT det_name FROM Menu_Details")
	List<String> getMenuName(); 
	
	@Query("SELECT m.cat_id.cat_name FROM Menu_Details m WHERE m.det_name = ?1")
	List<String> getIngredients(String name);
	
}
