package com.crmapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crmapp.utilities.EmailService;

@Controller

public class EmailController {

	@Autowired
	private EmailService emailservice;

	@RequestMapping("sendemail")
	public String showEmailPage(@RequestParam("email") String email, ModelMap model) {
		model.addAttribute("to", email);
		return "compose_email";
	}

	@RequestMapping("send")
	public String sendEmail(@RequestParam("to") String to, @RequestParam("subject") String subject,
			@RequestParam("message") String message, ModelMap model) {
		emailservice.sendSimpleMessage(to, subject, message);
		model.addAttribute("Msg", "Email sent successfully");
		return "compose_email";
	}

}
