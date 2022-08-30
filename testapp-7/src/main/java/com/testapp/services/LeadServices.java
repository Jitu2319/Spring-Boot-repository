package com.testapp.services;

import java.util.List;

import com.testapp.entities.Lead;

public interface LeadServices {

	public Lead saveonerecord(Lead lead);

	public List<Lead> showalldata();

	public void deleteonerecord(Long id);

	public Lead getonerecord(Long id);

}
