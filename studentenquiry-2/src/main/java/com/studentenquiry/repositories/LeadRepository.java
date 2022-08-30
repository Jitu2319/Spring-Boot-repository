package com.studentenquiry.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentenquiry.entities.Leads;

public interface LeadRepository extends JpaRepository<Leads, Long> {

}
