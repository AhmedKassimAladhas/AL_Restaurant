package com.aladhas.ALrestaurant.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aladhas.ALrestaurant.model.Tables;
import com.aladhas.ALrestaurant.repository.TablesRepository;

@Service
public class TablesServices {

	@Autowired
	private TablesRepository tablesRepository;

	public void addTable(Tables tables) {
		tablesRepository.save(tables);
	}

	public void deleteTable(Long id) {
		tablesRepository.deleteById(id);
	}

	public List<Tables> getAllTables() {
		return tablesRepository.findAll();
	}

	public List<Tables> getAllTablesByStatus( String tab_Status) {
		return tablesRepository.getAllTablesByStatus(tab_Status);
	}
	
	public Tables getTable(Long id) {
		return tablesRepository.findById(id).get();
	}
}
