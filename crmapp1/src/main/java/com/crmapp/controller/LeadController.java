package com.crmapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crmapp.entities.Lead;
import com.crmapp.services.LeadService;

@Controller
public class LeadController {

	@Autowired
	private LeadService leadservice;

	@RequestMapping("/ViewLeads")
	public String viewLeadsPage() {
		return "save_lead";
	}

	@RequestMapping("/savelead")
	public String saveLead(Lead lead, ModelMap model) {
		leadservice.saveLead(lead);
		model.addAttribute("lead", lead);
		return "lead_info";

	}

	@RequestMapping("/listall")
	public String getLeads(ModelMap model) {
		List<Lead> leads = leadservice.getAllLeads();
		model.addAttribute("leads", leads);
		return "lead_result";
	}

	@RequestMapping("/getLeadById")
	public String getLeadById(@RequestParam("id") long id, ModelMap model) {
		Lead lead = leadservice.findLeadById(id);
		model.addAttribute("lead", lead);
		return "lead_info";
	}

}
