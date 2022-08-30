package com.markettingapp3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.markettingapp3.entities.Lead;
import com.markettingapp3.services.LeadServices;
import com.markettingapp3.utilities.EmailService;

@Controller
public class LeadoController {
	@Autowired
	private EmailService emailservices;

	@Autowired
	private LeadServices leadservices;

	@RequestMapping("/viewleadpage")
	public String viewLeadsPage() {
		return "new_lead";
	}

	@RequestMapping("/savelead")
	public String saveLead(@ModelAttribute("lead") Lead lead, ModelMap model) {
		leadservices.saveLead(lead);
		emailservices.sendSimpleMessage(lead.getEmail(), "Test", "Welcome Hero");
		model.addAttribute("msg", "Record is Saved!");

		return "new_lead";

	}

	@RequestMapping("/listall")
	public String listLead(ModelMap model) {
		List<Lead> allLeads = leadservices.getAllLeads();
		model.addAttribute("leads", allLeads);

		return "search_result";

	}

	@RequestMapping("/delete")
	public String deleteLead(@RequestParam("id") Long id, ModelMap model) {
		leadservices.deleteOneLead(id);
		List<Lead> allLeads = leadservices.getAllLeads();
		model.addAttribute("leads", allLeads);

		return "search_result";
	}

	@RequestMapping("/getLeadInfo")
	public String getLeadInfo(@RequestParam("id") Long id, ModelMap model) {
		Lead lead = leadservices.getOneLead(id);
		model.addAttribute("lead", lead);
		return "update_lead";

	}

	@RequestMapping("/updatelead")
	public String updatelead(Lead lead, ModelMap model) {
		leadservices.saveLead(lead);
		List<Lead> allLeads = leadservices.getAllLeads();
		model.addAttribute("leads", allLeads);

		return "search_result";

	}

}
