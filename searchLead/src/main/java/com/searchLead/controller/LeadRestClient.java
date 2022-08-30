package com.searchLead.controller;

import org.springframework.web.client.RestTemplate;

import com.searchLead.dto.Lead;

public class LeadRestClient {
	
	public Lead getLeadInfo(long id) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			Lead lead = restTemplate.getForObject("http://localhost:8080/lead/"+id, Lead.class);
			return lead;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
