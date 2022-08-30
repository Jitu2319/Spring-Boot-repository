package com.markettingapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.markettingapp.entities.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long> {

}
