package com.crmappp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crmappp.entity.Billing;
import com.crmappp.repositories.BillingRepository;
@Service
public class BillingServiceImpl implements BillingService {
	
	@Autowired
	private BillingRepository billingRepo;

	@Override
	public void saveBill(Billing bill) {
		billingRepo.save(bill);

	}

}
