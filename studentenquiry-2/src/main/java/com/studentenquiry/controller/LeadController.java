package com.studentenquiry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.studentenquiry.entities.Leads;
import com.studentenquiry.services.LeadServices;

@Controller
public class LeadController {

	@Autowired
	private LeadServices leadservices;

	@RequestMapping("/viewleadpage")
	public String viewLeadPage() {
		return "new_lead";
	}

	@RequestMapping("/savelead")
	public String saveLead(@ModelAttribute("lead") Leads lead, ModelMap modelMap) {
		leadservices.saveLead(lead);
		modelMap.addAttribute("Msg", "Record is Saved!");
		return "new_lead";

	}

}
