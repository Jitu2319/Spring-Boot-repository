package com.markettingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.markettingapp.entities.Lead;
import com.markettingapp.services.LeadServices;
import com.markettingapp.utilities.EmailService;

@Controller
public class LeadController {
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private LeadServices leadservices;

	@RequestMapping("/viewleadpage")
	public String viewLeadsPage() {
		return "new_lead";
	}

	@RequestMapping("/savelead")
	public String saveLeadData(@ModelAttribute("lead") Lead lead, ModelMap model) {
		leadservices.saveLead(lead);
		emailService.sendSimpleMessage(lead.getEmail(), "test", "Welcome test email");
		model.addAttribute("msg", "Record is Saved!");
		return "new_lead";

	}

	@RequestMapping("/listall")
	public String listLeads(ModelMap model) {
		List<Lead> allLeads = leadservices.getAllLeads();
		model.addAttribute("leads", allLeads);
		return "search_result";

	}

	@RequestMapping("/delete")
	public String deleteLead(@RequestParam("id") long id, ModelMap model) {
		leadservices.deleteOneLead(id);
		List<Lead> allLeads = leadservices.getAllLeads();
		model.addAttribute("leads", allLeads);
		return "search_result";

	}
	@RequestMapping("/getLeadInfo")
	public String getLeadInfo(@RequestParam("id") long id, ModelMap model) {
		Lead lead = leadservices.getOneLead(id);
		model.addAttribute("lead", lead);
		return "update_lead";
		
	}
	@RequestMapping("/updatelead")
	public String updatelead(Lead lead,ModelMap model) {
		leadservices.saveLead(lead);
		List<Lead> allLeads = leadservices.getAllLeads();
		model.addAttribute("leads", allLeads);
		return "search_result";
		
	}

}
