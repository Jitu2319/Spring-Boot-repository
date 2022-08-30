package com.tsearchlead.controller;

import org.springframework.web.client.RestTemplate;

import com.tsearchlead.dto.Lead;

public class LeadRestClient {
	public Lead getLeadInfo(long id) {
		RestTemplate restTemplate = new RestTemplate();
		Lead lead = restTemplate.getForObject("http://localhost:8080/lead/" + id, Lead.class);
		return lead;
	}

}
