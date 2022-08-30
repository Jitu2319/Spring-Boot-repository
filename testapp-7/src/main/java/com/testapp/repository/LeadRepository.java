package com.testapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testapp.entities.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long> {

}
