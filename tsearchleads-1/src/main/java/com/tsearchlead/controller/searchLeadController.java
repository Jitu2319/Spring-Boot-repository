package com.tsearchlead.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tsearchlead.dto.Lead;

@Controller
public class searchLeadController {

	@RequestMapping("/viewleadpage")
	public String getleadinfo() {
		return "search_lead";
	}

	@RequestMapping("/getleadinfo")
	public String getleadid(@RequestParam("id") long id, ModelMap model) {
		LeadRestClient client = new LeadRestClient();
		Lead lead = client.getLeadInfo(id);
		model.addAttribute("lead", lead);
		return "lead_result";

	}

}
