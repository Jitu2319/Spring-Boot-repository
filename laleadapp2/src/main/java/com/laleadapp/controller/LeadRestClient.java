package com.laleadapp.controller;

import org.springframework.web.client.RestTemplate;

import com.laleadapp.dto.Lead;

public class LeadRestClient {

	public Lead getleadinfo(long id) {
		RestTemplate resttemplate = new RestTemplate();
		Lead lead = resttemplate.getForObject("http://localhost:8080/viewleads/" + id, Lead.class);
		return lead;
	}

}
