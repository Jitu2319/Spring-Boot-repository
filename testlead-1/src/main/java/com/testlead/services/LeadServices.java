package com.testlead.services;

import java.util.List;

import com.testlead.entity.Lead;

public interface LeadServices {

	public void saveonerecord(Lead lead);

	public List<Lead> getallleads();

	public Lead getleadinfo(Long id);

	public void deleteonerecord(Long id);

}
