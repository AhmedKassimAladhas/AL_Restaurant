package com.aladhas.ALrestaurant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aladhas.ALrestaurant.model.Categories;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Long> {

	@Query("SELECT c FROM Categories c WHERE c.measuring =?1")
	List<Categories> getCategoriesBySection(String sec_name);
}
