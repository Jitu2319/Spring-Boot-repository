package com.acrmapp.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.acrmapp.entity.Billing;
import com.acrmapp.repository.BillingRepository;
@Service
public class BillingServiceImpl implements BillingService {
	
	@Autowired
	private BillingRepository billingRepo;

	@Override
	public void saveBill(Billing bill) {
		billingRepo.save(bill);
	}

}
