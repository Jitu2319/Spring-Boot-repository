package com.TestProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TestProject.entities.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long> {

}
