package com.aladhas.ALrestaurant.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aladhas.ALrestaurant.model.Expenses;
import com.aladhas.ALrestaurant.repository.ExpensesRepository;

@Service
public class ExpensesService {

	@Autowired
	private ExpensesRepository expensesRepository;

	public void addExpense(Expenses expense) {
		expensesRepository.save(expense);
	}

	public void deleteExpense(Long id) {
		expensesRepository.deleteById(id);
	}

	public List<Expenses> getAllExpenses() {
		return expensesRepository.findAll();
	}

	public List<Expenses> getAllByDateExpenses(Date date) {
		return expensesRepository.findByDateExpenses(date);
	}

	public Expenses getExpense(Long id) {
		return expensesRepository.findById(id).get();
	}

	public Double getExpensesTotal(String emp, Date date, String time_from, String time_to) {
		return expensesRepository.getExpensesTotal(emp, date, time_from, time_to);
	}
}
