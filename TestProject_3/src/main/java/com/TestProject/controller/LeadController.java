package com.TestProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.TestProject.entities.Lead;

@Controller
public class LeadController {
	
	@RequestMapping("/viewlaedpage")
	public String viewLeadsPage() {
		return "New_Lead";
	}
	@RequestMapping("/savelead")
	public String saveOneLead(@ModelAttribute("lead") Lead lead) {
		System.out.println(lead.getId());
		System.out.println(lead.getFirstName());
		System.out.println(lead.getMobile());
		System.out.println(lead.getLastName());
		System.out.println(lead.getEmail());
		System.out.println(lead.getCity());
		return "";
	}
}
