package com.leadapp.services;

import java.util.List;

import com.leadapp.entity.Lead;

public interface LeadServices {
	
	public void saveLead(Lead lead);

	public List<Lead> showalldata();

	public void deleteonerecord(long id);

	public Lead getleadinfo(long id);
}
