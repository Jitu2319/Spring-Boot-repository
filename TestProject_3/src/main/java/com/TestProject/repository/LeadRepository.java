package com.TestProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TestProject.entities.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long> {

}
