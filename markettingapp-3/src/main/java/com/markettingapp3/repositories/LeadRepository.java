package com.markettingapp3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.markettingapp3.entities.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long> {

}
