package com.acrmapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acrmapp.entity.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long> {

}
