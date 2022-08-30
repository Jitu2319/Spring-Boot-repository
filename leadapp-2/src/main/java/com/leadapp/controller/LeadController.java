package com.leadapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.leadapp.entities.Lead;
import com.leadapp.services.LeadServices;

@Controller
public class LeadController {

	@Autowired
	private LeadServices leadservices;

	@RequestMapping("/viewleadpage")
	public String viewleadspage() {
		return "newlead";
	}

	@RequestMapping("/savelead")
	public String savelead(@ModelAttribute("lead") Lead lead, ModelMap Model) {
		leadservices.savelead(lead);
		Model.addAttribute("msg", "Data is Saved!");
		return "newlead";
	}

	@RequestMapping("/listall")
	public String showalldata(ModelMap model) {
		List<Lead> showalldata = leadservices.showalldata();
		model.addAttribute("leads", showalldata);
		return "search_result";

	}

	@RequestMapping("/delete")
	public String deleteonelead(@RequestParam("id") long id, ModelMap model) {
		leadservices.deleteonelead(id);
		List<Lead> showalldata = leadservices.showalldata();
		model.addAttribute("leads", showalldata);
		return "search_result";
	}

	@RequestMapping("/getLeadInfo")
	public String getLeadInfo(@RequestParam("id") long id, ModelMap model) {
		Lead lead = leadservices.getLeadInfo(id);
		model.addAttribute("lead", lead);
		return "update_lead";

	}
	@RequestMapping("/updatelead")
	public String updatelead(Lead lead, ModelMap model) {
		leadservices.savelead(lead);
		List<Lead> showalldata = leadservices.showalldata();
		model.addAttribute("leads", showalldata);
		return "search_result";
		
	}

}
