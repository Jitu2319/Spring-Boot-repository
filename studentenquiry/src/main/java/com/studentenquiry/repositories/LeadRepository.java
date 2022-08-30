package com.studentenquiry.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentenquiry.entities.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long> {

}
