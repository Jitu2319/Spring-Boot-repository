package com.leadapp.services;

import java.util.List;

import com.leadapp.entities.Lead;

public interface LeadServices {

	public void savelead(Lead lead);

	public List<Lead> showalldata();

	public Lead getleadinfo(long id);

	public void deleteonelead(long id);

}
