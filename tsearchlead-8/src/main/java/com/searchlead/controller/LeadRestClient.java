package com.searchlead.controller;


import org.springframework.web.client.RestTemplate;

import com.searchlead.entity.Lead;

public class LeadRestClient {

	public Lead getleadinfo(long id) {
		RestTemplate restTemplate = new RestTemplate();
		Lead lead = restTemplate.getForObject("http://localhost:8080/viewleadspage/" + id, Lead.class);
		return lead;
	}

}
