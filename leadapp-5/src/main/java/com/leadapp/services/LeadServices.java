package com.leadapp.services;

import java.util.List;

import com.leadapp.entities.Lead;

public interface LeadServices {

	public void saveonelead(Lead lead);

	public List<Lead> showalldata(long id);

}
