package com.crmappp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crmappp.entity.Billing;

public interface BillingRepository extends JpaRepository<Billing, Long> {

}
