package com.aladhas.ALrestaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aladhas.ALrestaurant.model.Role;

@Repository
public interface RolesRepository extends JpaRepository<Role, Long>{

	@Query("SELECT r FROM Role r WHERE r.name = ?1")
	Role findByname(String name);
}
