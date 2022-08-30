package com.crmapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crmapp.entities.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long> {

}
