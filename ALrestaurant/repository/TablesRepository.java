package com.aladhas.ALrestaurant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aladhas.ALrestaurant.model.Tables;

@Repository
public interface TablesRepository extends JpaRepository<Tables, Long> {

	@Query("SELECT t FROM Tables t WHERE t.tab_statues = ?1")
	List<Tables> getAllTablesByStatus(String tab_statues); 
}
