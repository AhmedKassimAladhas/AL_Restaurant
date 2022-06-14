package com.aladhas.ALrestaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aladhas.ALrestaurant.model.Sections;

@Repository
public interface SectionsRepository extends JpaRepository<Sections, Long> {

}
