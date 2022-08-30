package com.TestProject.services;

import java.util.List;

import com.TestProject.entities.Lead;

public interface LeadServices {
	
	public void saveLead(Lead lead);

	public List<Lead> getAllLeads();

	public void deleteOneLead(long id);

	public Lead getOneLead(long id);
		
	

}
