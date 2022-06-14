package com.aladhas.ALrestaurant.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aladhas.ALrestaurant.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
	
	@Query("SELECT a FROM Account a WHERE a.acc_date = ?1")
	List<Account> findByDateAccount(Date date);
	
}
