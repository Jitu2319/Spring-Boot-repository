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

	@RequestMapping("/viewLeadsPage")
	public String viewleadspage() {
		return "Newlead";
	}
	@RequestMapping("/saveLead")
	public String saveLead(@ModelAttribute("lead")Lead lead, ModelMap model) {
		leadservices.savelead(lead);
		model.addAttribute("msg", "Data is saved.!");
		return "Newlead";
	}
	
	@RequestMapping("/list")
	public String showalldata(ModelMap model) {
		List<Lead> showalldata = leadservices.showalldata();
		model.addAttribute("leads", showalldata);
		return "search_result";
		
	}
	@RequestMapping("/delete")
	public String deleteoneLead(@RequestParam("id") long id, ModelMap model) {
		leadservices.deleteonelead(id);
		List<Lead> showalldata = leadservices.showalldata();
		model.addAttribute("leads", showalldata);
		return "search_result";
		
	}
	@RequestMapping("/getleadinfo")
	public String getleadinfo(@RequestParam("id") long id, ModelMap model) {
		Lead lead = leadservices.getleadinfo(id);
		model.addAttribute("lead", lead);
		return "update_lead";
		
	}
	
	@RequestMapping("/updatelead")
	public String updateonelead(Lead lead, ModelMap model) {
		leadservices.savelead(lead);
		List<Lead> showalldata = leadservices.showalldata();
		model.addAttribute("leads", showalldata);
		model.addAttribute("message", "Record updated successfully");
		return "search_result";
	}
	
}
