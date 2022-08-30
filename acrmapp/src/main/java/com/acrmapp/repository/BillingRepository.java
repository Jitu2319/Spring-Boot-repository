package com.acrmapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acrmapp.entity.Billing;

public interface BillingRepository extends JpaRepository<Billing, Long> {

}
