package com.aladhas.ALrestaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aladhas.ALrestaurant.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
	
	@Query("SELECT u FROM Users u WHERE u.user_name = :username")
	Users findByUser_name(@Param("username") String user_name);
	
}
