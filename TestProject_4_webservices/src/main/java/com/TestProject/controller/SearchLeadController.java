package com.TestProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.TestProject.dto.Lead;

@Controller
public class SearchLeadController {

	@RequestMapping("/viewleads")
	public String searchLead() {
		return "search_lead";

	}

	@RequestMapping("/getleadinfo")
	public String getLeadId(@RequestParam("id") long id, ModelMap model) {
		LeadRestClient client = new LeadRestClient();
		Lead lead = client.getLeadInfo(id);
		if (lead != null) {
			model.addAttribute("lead", lead);
			return "lead_result";
		} else {
			model.addAttribute("Error", "Record not Found");
			return "lead_result";
		}

	}

}
