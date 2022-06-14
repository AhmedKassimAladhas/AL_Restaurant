package com.aladhas.ALrestaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aladhas.ALrestaurant.model.Other;

@Repository
public interface OtherRepository extends JpaRepository<Other, Long> {

}
