package com.acrmapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.acrmapp.entity.Lead;
import com.acrmapp.services.LeadServices;

@Controller
public class LeadController {
	@Autowired
	private LeadServices leadservices;

	@RequestMapping("/viewlead")
	public String viewLeadsPage() {
		return "save_lead";
	}

	@RequestMapping("/savelead")
	public String saveLead(Lead lead, ModelMap model) {
		leadservices.saveLead(lead);
		model.addAttribute("lead", lead);
		return "lead_info";
	}

	@RequestMapping("/listall")
	public String getLeads(ModelMap model) {
		List<Lead> leads = leadservices.getAllLeads();
		model.addAttribute("leads", leads);
		return "leads_result";
	}

	@RequestMapping("/getLeadById")
	public String getLeadBId(@RequestParam("id") long id, ModelMap model) {
		Lead lead = leadservices.findLeadById(id);
		model.addAttribute("lead", lead);
		return "lead_info";
	}

}
