package com.marketingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketingapp.entities.Lead;
import com.marketingapp.services.LeadServices;
import com.marketingapp.utilities.EmailService;

@Controller
public class LeadController {
	@Autowired
	private EmailService emailService;

	@Autowired
	private LeadServices leadServices;

	@RequestMapping("/viewleadpage")
	public String viewLeadsPage() {
		return "new_lead";
	}

	@RequestMapping("/savelead")
	public String saveLeadData(@ModelAttribute("lead") Lead lead, ModelMap model) {
		leadServices.saveLead(lead);
		emailService.sendSimpleMessage(lead.getEmail(), "Test", "Welcome");
		model.addAttribute("msg", "Data is Saved");
		return "new_lead";

	}

	@RequestMapping("/listAll")
	public String listLeads(ModelMap modelmap) {
		List<Lead> allLeads = leadServices.getAllLeads();
		modelmap.addAttribute("leads", allLeads);
		return "search_result";
	}

	@RequestMapping("/delete")
	public String deleteLead(@RequestParam("id") Long id, ModelMap modelmap) {
		leadServices.deleteOneLead(id);
		List<Lead> allLeads = leadServices.getAllLeads();
		modelmap.addAttribute("leads", allLeads);
		return "search_result";

	}
	@RequestMapping("/getLeadInfo")
	public String getLeadInfo(@RequestParam("id") Long id, ModelMap modelmap) {
		Lead lead = leadServices.getOneLead(id);
		modelmap.addAttribute("lead", lead);
		return "update_lead";
	}
	@RequestMapping("/updatelead")
	public String updatelead(Lead lead, ModelMap modelmap) {
		leadServices.saveLead(lead);
		List<Lead> allLeads = leadServices.getAllLeads();
		modelmap.addAttribute("leads", allLeads);
		return "search_result";
		
	}

}
