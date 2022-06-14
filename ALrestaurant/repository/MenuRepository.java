package com.aladhas.ALrestaurant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aladhas.ALrestaurant.model.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

	@Query("SELECT DISTINCT men_section FROM Menu")
	List<String> getMenuSections(); 
	
	@Query("SELECT m FROM Menu m WHERE m.men_section =?1")
	List<Menu> getAllMenuBySection(String sec_name); 
}
