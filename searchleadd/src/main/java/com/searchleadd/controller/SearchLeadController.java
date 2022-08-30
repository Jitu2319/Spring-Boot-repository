package com.searchleadd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.searchleadd.dto.Lead;

@Controller

public class SearchLeadController {

	@RequestMapping("/viewleadpage")
	public String showSearchLeadPage() {
		return "search_lead";
	}

	@RequestMapping("/getleadInfo")
	public String getLeadId(@RequestParam("id") long id, ModelMap modelmap) {
		LeadRestClient client = new LeadRestClient();
		Lead lead = client.getLeadInfo(id);
		modelmap.addAttribute("lead", lead);
		if (lead != null) {
			modelmap.addAttribute("lead", lead);
			return "lead_result";
		} else {
			modelmap.addAttribute("error", "No record Found");
			return "lead_result";
		}

	}

}
