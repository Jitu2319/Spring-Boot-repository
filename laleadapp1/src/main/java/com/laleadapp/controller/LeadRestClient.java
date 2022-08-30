package com.laleadapp.controller;

import org.springframework.web.client.RestTemplate;

import com.laleadapp.dto.Lead;

public class LeadRestClient {

	public Lead getLeadInfo(long id) {
		RestTemplate restTemplate = new RestTemplate();
		Lead lead = restTemplate.getForObject("http://localhost:8080/viewleadpage/" + id, Lead.class);
		return lead;

	}
}
