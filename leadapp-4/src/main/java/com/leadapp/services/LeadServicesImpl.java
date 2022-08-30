package com.leadapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leadapp.entities.Lead;
import com.leadapp.repository.LeadRepository;

@Service
public class LeadServicesImpl implements LeadServices {

	@Autowired
	private LeadRepository leadRepo;

	@Override
	public void savelead(Lead lead) {
		leadRepo.save(lead);

	}

	@Override
	public List<Lead> showalldata() {
		List<Lead> leads = leadRepo.findAll();
		return leads;

	}

	@Override
	public Lead getleadinfo(long id) {
		Optional<Lead> findById = leadRepo.findById(id);
		Lead lead = findById.get();
		return lead;
	}

	@Override
	public void deleteonelead(long id) {
		leadRepo.deleteById(id);
		
	}

}
