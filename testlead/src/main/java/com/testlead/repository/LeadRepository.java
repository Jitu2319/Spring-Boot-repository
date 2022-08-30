package com.testlead.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testlead.entity.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long> {

}
