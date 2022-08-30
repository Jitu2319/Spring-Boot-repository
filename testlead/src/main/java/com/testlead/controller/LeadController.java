package com.testlead.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.testlead.entity.Lead;
import com.testlead.services.LeadServices;
import com.testlead.utilities.EmailService;

@Controller
public class LeadController {
	@Autowired
	private EmailService emailservice;

	@Autowired
	private LeadServices leadservices;

	@RequestMapping("/viewleadpage")
	public String viewleadpage() {
		return "NewLead";
	}

	@RequestMapping("/savelead")
	public String saveonerecord(@ModelAttribute("lead") Lead lead, ModelMap model) {
		model.addAttribute("msg", "Data is saved!");
		leadservices.savelead(lead);
		emailservice.sendSimpleMessage("demojitendra@gmail.com", "Test", "This is a test Email. Please ignore.");
		List<Lead> showallrecord = leadservices.showallrecord();
		model.addAttribute("leads", showallrecord);
		return "search_result";

	}

	@RequestMapping("/listall")
	public String showallrecord(ModelMap model) {
		List<Lead> showallrecord = leadservices.showallrecord();
		model.addAttribute("leads", showallrecord);
		return "search_result";

	}

	@RequestMapping("/delete")
	public String deleteonerecord(@RequestParam("id") long id, ModelMap model) {
		leadservices.deleteonerecord(id);
		List<Lead> showallrecord = leadservices.showallrecord();
		model.addAttribute("leads", showallrecord);
		return "search_result";

	}

	@RequestMapping("/getleadinfo")
	public String getleadinfo(@RequestParam("id") long id, ModelMap model) {
		Lead lead = leadservices.getleadinfo(id);
		model.addAttribute("lead", lead);
		return "update_lead";
	}

	@RequestMapping("/updatelead")
	public String updateonerecord(Lead lead, ModelMap model) {
		leadservices.savelead(lead);
		List<Lead> showallrecord = leadservices.showallrecord();
		model.addAttribute("leads", showallrecord);
		return "search_result";
	}
}
