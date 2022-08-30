package com.testlead.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.testlead.entity.Lead;
import com.testlead.services.LeadServices;
import com.testlead.utilities.EmailService;

@Controller
public class LeadController {

	@Autowired
	private EmailService emailservices;
	@Autowired
	private LeadServices leadservices;

	@RequestMapping("/viewlead")
	public String viewleadspage() {
		return "new_lead";
	}

	@RequestMapping("/savelead")
	public String saveonerecord(@ModelAttribute("lead") Lead lead, ModelMap model) {
		leadservices.saveonerecord(lead);
		emailservices.sendSimpleMessage(lead.getEmail(), "Test", "Welcome to the Emailservices");
		model.addAttribute("msg", "Data is saved");
		List<Lead> getallleads = leadservices.getallleads();
		model.addAttribute("leads", getallleads);
		return "search_result";

	}

	@RequestMapping("/listall")
	public String getallleads(ModelMap model) {
		List<Lead> getallleads = leadservices.getallleads();
		model.addAttribute("leads", getallleads);
		return "search_result";
	}

	@RequestMapping("/getleadinfo")
	public String getleadinfo(@RequestParam("id") Long id, ModelMap model) {
		Lead getleadinfo = leadservices.getleadinfo(id);
		model.addAttribute("lead", getleadinfo);
		return "update_lead";
	}

	@RequestMapping("/updatelead")
	public String updateonerecord(Lead lead, ModelMap model) {
		leadservices.saveonerecord(lead);
		List<Lead> getallleads = leadservices.getallleads();
		model.addAttribute("leads", getallleads);
		return "search_result";
	}

	@RequestMapping("/delete")
	public String deleteonerecord(@RequestParam("id") Long id, ModelMap model) {
		leadservices.deleteonerecord(id);
		List<Lead> getallleads = leadservices.getallleads();
		model.addAttribute("leads", getallleads);
		return "search_result";
	}
}
