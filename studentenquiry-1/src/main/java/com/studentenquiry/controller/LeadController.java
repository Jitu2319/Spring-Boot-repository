package com.studentenquiry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.studentenquiry.entities.Lead;
import com.studentenquiry.services.LeadServices;

@Controller
public class LeadController {

	@Autowired
	private LeadServices leadservices;

	@RequestMapping("/viewleadpage")
	public String viewLeadspage() {
		return "new_lead";
	}

	@RequestMapping("/savelead")
	public String saveLead(@ModelAttribute() Lead lead, ModelMap model) {
		leadservices.saveLead(lead);
		model.addAttribute("Msg", "Record is Saved!");
		return "new_lead";
	}

}
