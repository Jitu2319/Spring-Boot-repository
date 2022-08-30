package com.testapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.testapp.entities.Lead;
import com.testapp.services.LeadServices;
import com.testapp.utilities.EmailService;

@Controller
public class LeadController {

	@Autowired
	private EmailService emailservice;

	@Autowired
	private LeadServices leadservices;

	@RequestMapping("/viewleadspage")
	public String viewleadspage() {
		return "new_lead";
	}

	@RequestMapping("/savelead")
	public String saveonerecord(@ModelAttribute("lead") Lead lead, ModelMap model) {
		leadservices.saveonerecord(lead);
		emailservice.sendSimpleMessage(lead.getEmail(), "Test", "This is a test Email");
		model.addAttribute("msg", "Data is saved");
		List<Lead> showalldata = leadservices.showalldata();
		model.addAttribute("leads", showalldata);
		return "search_result";
	}

	@RequestMapping("/listall")
	public String showalldata(ModelMap model) {
		List<Lead> showalldata = leadservices.showalldata();
		model.addAttribute("leads", showalldata);
		return "search_result";
	}

	@RequestMapping("/delete")
	public String deleteonerecord(@RequestParam("id") Long id, ModelMap model) {
		leadservices.deleteonerecord(id);
		List<Lead> showalldata = leadservices.showalldata();
		model.addAttribute("leads", showalldata);
		return "search_result";
	}

	@RequestMapping("/getleadinfo")
	public String getleadinfo(@RequestParam("id") Long id, ModelMap model) {
		Lead lead = leadservices.getonerecord(id);
		model.addAttribute("lead", lead);
		return "update_lead";
	}

	@RequestMapping("/updatelead")
	public String updateonelead(Lead lead, ModelMap model) {
		leadservices.saveonerecord(lead);
		List<Lead> showalldata = leadservices.showalldata();
		model.addAttribute("leads", showalldata);
		model.addAttribute("mesg", "Record is updated");
		return "update_lead";
	}
}
