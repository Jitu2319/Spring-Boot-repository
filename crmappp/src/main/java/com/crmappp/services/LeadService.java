package com.crmappp.services;

import java.util.List;

import com.crmappp.entity.Lead;

public interface LeadService {
	
	public void saveLead(Lead lead);
	public List<Lead>getAllLeads();
	public Lead findLeadById(long id);
	public void deleteLeadById(long id);

}
