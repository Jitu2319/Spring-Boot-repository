package com.crmappp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crmappp.entity.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long> {

}
