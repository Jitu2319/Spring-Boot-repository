package com.TestProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.TestProject.entities.Lead;
import com.TestProject.services.LeadServices;
import com.TestProject.utilities.EmailService;

@Controller
public class LeadController {
	@Autowired
	private EmailService emailservice;

	@Autowired
	private LeadServices leadRepo;

	@RequestMapping("/viewlaedpage")
	public String viewLeadsPage() {
		return "New_Lead";
	}

	@RequestMapping("/savelead")
	public String saveOneLead(@ModelAttribute("lead") Lead lead, ModelMap model) {
		model.addAttribute("msg", "Data is saved");
		leadRepo.saveLead(lead);
		emailservice.sendSimpleMessage("Demojitendra@gmail.com", "Test", "Hi this is a test email");
		return "New_Lead";
	}

	@RequestMapping("/listAll")
	public String listLeads(ModelMap model) {
		List<Lead> allLeads = leadRepo.getAllLeads();
		model.addAttribute("leads", allLeads);
		return "search_result";
	}

	@RequestMapping("/delete")
	public String deleteLead(@RequestParam("id") long id, ModelMap model) {
		leadRepo.deleteOneLead(id);
		List<Lead> allLeads = leadRepo.getAllLeads();
		model.addAttribute("leads", allLeads);
		model.addAttribute("Message", "Record is deleted");
		return "search_result";

	}

	@RequestMapping("/getLeadInfo")
	public String getLeadInfo(@RequestParam("id") long id, ModelMap model) {
		Lead lead = leadRepo.getOneLead(id);
		model.addAttribute("lead", lead);
		model.addAttribute("Message", "Record is Updated");
		return "update_lead";

	}

	@RequestMapping("/updatelead")
	public String updateLead(Lead lead, ModelMap model) {
		leadRepo.saveLead(lead);
		List<Lead> allLeads = leadRepo.getAllLeads();
		model.addAttribute("leads", allLeads);
		model.addAttribute("Message", "Record is Updated");
		return "search_result";

	}
}
