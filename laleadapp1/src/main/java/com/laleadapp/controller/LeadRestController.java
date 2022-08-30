package com.laleadapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.laleadapp.dto.Lead;

@Controller
public class LeadRestController {

	@RequestMapping("/viewleadsspage")
	public String viewleadpage() {
		return "search_lead";
	}

	@RequestMapping("/getleadinfo")
	public String getleadinfo(@RequestParam("id") long id, ModelMap model) {
		LeadRestClient client = new LeadRestClient();
		Lead lead = client.getLeadInfo(id);
		model.addAttribute("lead", lead);
		return "lead_result";
	}

}
