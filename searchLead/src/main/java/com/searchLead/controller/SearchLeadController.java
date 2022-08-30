package com.searchLead.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.searchLead.dto.Lead;

@Controller
public class SearchLeadController {
	@RequestMapping("/viewleadpage")
	public String showSearchLeadPage() {
		return "search_lead";
	}

	@RequestMapping("/getLeadInfo")
	public String getLeadId(@RequestParam("id") long id, ModelMap modelMap) {
		LeadRestClient client = new LeadRestClient();
		Lead lead = client.getLeadInfo(id);
		
		if(lead!=null) {
			modelMap.addAttribute("lead", lead);
			return "lead_result";
		}else {
			modelMap.addAttribute("error", "No Record Found");
			return "lead_result";
		}
	
}
}
