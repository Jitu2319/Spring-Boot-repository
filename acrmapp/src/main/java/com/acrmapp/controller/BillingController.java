package com.acrmapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.acrmapp.entity.Billing;
import com.acrmapp.services.BillingService;

@Controller
public class BillingController {
	
	@Autowired
	private BillingService billingservice;
	
	@RequestMapping("/generateBill")
	public String generateBill(Billing bill) {
		billingservice.saveBill(bill);
		return "final_bill";
	}

}
