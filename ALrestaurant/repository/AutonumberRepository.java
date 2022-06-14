package com.aladhas.ALrestaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aladhas.ALrestaurant.model.Autonumber;

@Repository
public interface AutonumberRepository extends JpaRepository<Autonumber, Integer> {

	@Query("SELECT max(a.Number)+1 FROM Autonumber a")
	int getNum();
}
