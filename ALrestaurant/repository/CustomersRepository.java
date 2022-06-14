package com.aladhas.ALrestaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aladhas.ALrestaurant.model.Customers;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Long> {

	@Query("SELECT c FROM Customers c WHERE c.cust_phone=?1")
	Customers getCustByPhone(String Phone);

}
