package com.searchlead.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.searchlead.dto.Lead;

@Controller
public class SearchLeadController {

	@RequestMapping("/viewleadpage")
	public String showSearchLeadPage() {
		return "search_lead";

	}

	@RequestMapping("/getleadinfo")
	public String getLeadId(@RequestParam("id") long id, ModelMap model) {
		LeadRestClient client = new LeadRestClient();
		Lead lead = client.getleadinfo(id);
		if(lead !=null) {
			model.addAttribute("lead", lead);
			return "lead_result";
		}else {
			model.addAttribute("Error", "No record Found");
			return "lead_result";
		}
		
	}

}
