package com.testlead.services;

import java.util.List;

import com.testlead.entity.Lead;

public interface LeadServices {
	
	public void savelead(Lead lead);

	public List<Lead> showallrecord();

	public void deleteonerecord(long id);

	public Lead getleadinfo(long id);

	}
