package com.acrmapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.acrmapp.entity.Contact;
import com.acrmapp.entity.Lead;
import com.acrmapp.services.ContactServices;
import com.acrmapp.services.LeadServices;

@Controller
public class ContactController {

	@Autowired
	private ContactServices contactservices;

	@Autowired
	private LeadServices leadservices;

	@RequestMapping("/convertToContact")
	public String convertToContact(@RequestParam("id") long id, ModelMap model) {
		Lead lead = leadservices.findLeadById(id);
		Contact contact = new Contact();
		contact.setFirstName(lead.getFirstName());
		contact.setLastName(lead.getLastName());
		contact.setEmail(lead.getEmail());
		contact.setLeadsource(lead.getLeadsource());
		contact.setMobile(lead.getMobile());
		contactservices.saveContact(contact);
		leadservices.deleteLeadById(id);

		List<Contact> contacts = contactservices.getAllContacts();
		model.addAttribute("contacts", contacts);
		return "contacts_result";

	}

	@RequestMapping("/listallcontacts")
	public String listallcontacts(ModelMap model) {
		List<Contact> contacts = contactservices.getAllContacts();
		model.addAttribute("contacts", contacts);
		return "contacts_result";
	}

	@RequestMapping("/getContactById")
	public String getContactById(@RequestParam("id") long id, ModelMap model) {
		Contact contact = contactservices.findContactById(id);
		model.addAttribute("contact", contact);
		return "contacts_info";
	}

	@RequestMapping("/getIdForBilling")
	public String getIdForBilling(@RequestParam("id") long id, ModelMap model) {
		Contact contact = contactservices.findContactById(id);
		model.addAttribute("contact", contact);
		return "billing_info";
	}
}
