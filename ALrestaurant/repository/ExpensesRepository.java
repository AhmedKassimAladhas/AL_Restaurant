package com.aladhas.ALrestaurant.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aladhas.ALrestaurant.model.Expenses;

@Repository
public interface ExpensesRepository extends JpaRepository<Expenses, Long> {

	@Query("SELECT e FROM Expenses e WHERE e.exp_date = ?1")
	List<Expenses> findByDateExpenses(Date date);
	
	@Query("SELECT sum(e.exp_cost) FROM Expenses e WHERE e.exp_empName = ?1 AND e.exp_date >= ?2 AND e.exp_time between ?3 and ?4")
	Double getExpensesTotal(String emp , Date date ,String time_from ,String time_to);
}
