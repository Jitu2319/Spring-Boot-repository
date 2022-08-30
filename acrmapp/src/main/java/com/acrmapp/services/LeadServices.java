package com.acrmapp.services;

import java.util.List;

import com.acrmapp.entity.Lead;

public interface LeadServices {

	public void saveLead(Lead lead);

	public List<Lead> getAllLeads();

	public Lead findLeadById(Long id);

	public void deleteLeadById(long id);
}
