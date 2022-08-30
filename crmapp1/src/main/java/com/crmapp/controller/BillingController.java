package com.crmapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crmapp.entities.Billing;
import com.crmapp.services.BillingService;

@Controller
public class BillingController {

	@Autowired
	private BillingService billingservice;

	@RequestMapping("generatebill")
	public String generateBill(Billing bill, ModelMap model) {
		billingservice.saveBill(bill);
		model.addAttribute("bill", bill);
		return "All_Bills";

	}

	@RequestMapping("/listallBills")
	public String getLeads(ModelMap model) {
		List<Billing> bills = billingservice.getAllBills();
		model.addAttribute("bills", bills);
		return "All_Bills";
	}

}
