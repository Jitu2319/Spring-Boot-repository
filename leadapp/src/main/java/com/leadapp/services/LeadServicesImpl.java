package com.leadapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leadapp.entity.Lead;
import com.leadapp.repository.LeadRepository;

@Service
public class LeadServicesImpl implements LeadServices {
	@Autowired
	private LeadRepository leadrepo;

	@Override
	public void saveLead(Lead lead) {
		leadrepo.save(lead);

	}

	@Override
	public List<Lead> showalldata() {
		List<Lead> leads = leadrepo.findAll();
		return leads;
	}

	@Override
	public void deleteonerecord(long id) {
		leadrepo.deleteById(id);
	}

	@Override
	public Lead getleadinfo(long id) {
		Optional<Lead> findById = leadrepo.findById(id);
		Lead lead = findById.get();

		return lead;
	}

}
