package com.leadapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leadapp.entity.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long> {

}
