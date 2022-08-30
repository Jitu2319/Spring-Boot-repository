package com.crmapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crmapp.entities.Contact;
import com.crmapp.entities.Lead;
import com.crmapp.services.ContactService;
import com.crmapp.services.LeadService;

@Controller
public class ContactsController {

	@Autowired
	private LeadService leadservice;
	@Autowired
	private ContactService contactservice;

	@RequestMapping("/converttocontact")
	public String convertToContact(@RequestParam("id") long id, ModelMap model) {
		Lead lead = leadservice.findLeadById(id);
		Contact contact = new Contact();
		contact.setFirstName(lead.getFirstName());
		contact.setLastName(lead.getLastName());
		contact.setEmail(lead.getEmail());
		contact.setLeadSource(lead.getLeadSource());
		contact.setMobile(lead.getMobile());

		contactservice.saveContact(contact);
		leadservice.deleteLeadById(id);
		List<Contact> contacts = contactservice.getAllContacts();
		model.addAttribute("contacts", contacts);

		return "contact_result";

	}

	@RequestMapping("/listallcontacts")
	public String listallcontacts(ModelMap model) {
		List<Contact> contacts = contactservice.getAllContacts();
		model.addAttribute("contacts", contacts);

		return "contact_result";

	}

	@RequestMapping("/getContactById")
	public String getContactById(@RequestParam("id") long id, ModelMap model) {
		Contact contact = contactservice.findContactById(id);
		model.addAttribute("contact", contact);
		return "contact_info";
	}

	@RequestMapping("/getIdForBilling")
	public String getIdForBilling(@RequestParam("id") long id, ModelMap model) {
		Contact contact = contactservice.findContactById(id);
		model.addAttribute("contact", contact);
		return "biling_info";
	}
	@RequestMapping("/deleteById")
	public String deleteById(@RequestParam("id") long id, ModelMap model) {
		contactservice.deleteContactLeadById(id);
		List<Contact> contacts = contactservice.getAllContacts();
		model.addAttribute("contacts", contacts);

		return "contact_result";
		
	}

}
