package com.leadapp.services;

import java.util.List;

import com.leadapp.entities.Lead;

public interface LeadServices {

	public void savelead(Lead lead);

	public List<Lead> showalldata();

	public void deleteonelead(long id);

	public Lead getleadinfo(long id);
}
