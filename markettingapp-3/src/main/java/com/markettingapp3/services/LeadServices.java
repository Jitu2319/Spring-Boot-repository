package com.markettingapp3.services;

import java.util.List;

import com.markettingapp3.entities.Lead;

public interface LeadServices {
	public void saveLead(Lead lead);

	public List<Lead> getAllLeads();

	public void deleteOneLead(Long id);

	public Lead getOneLead(Long id);

}
