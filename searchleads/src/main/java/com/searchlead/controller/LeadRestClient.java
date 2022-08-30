package com.searchlead.controller;

import org.springframework.web.client.RestTemplate;

import com.searchlead.dto.Lead;

public class LeadRestClient {

	public Lead getleadinfo(long id) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			Lead lead = restTemplate.getForObject("http://localhost:8080/lead/" + id, Lead.class);
			return lead;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
