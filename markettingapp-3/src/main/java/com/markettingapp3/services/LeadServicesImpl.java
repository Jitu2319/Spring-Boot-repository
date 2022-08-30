package com.markettingapp3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.markettingapp3.entities.Lead;
import com.markettingapp3.repositories.LeadRepository;

@Service
public class LeadServicesImpl implements LeadServices {

	@Autowired
	private LeadRepository leadRepo;

	@Override
	public void saveLead(Lead lead) {
		leadRepo.save(lead);

	}

	@Override
	public List<Lead> getAllLeads() {
		List<Lead> leads = leadRepo.findAll();
		return leads;
	}

	@Override
	public void deleteOneLead(Long id) {
		leadRepo.deleteById(id);
		
	}

	@Override
	public Lead getOneLead(Long id) {
		Optional<Lead> findById = leadRepo.findById(id);
		Lead lead = findById.get();
		return lead;
		
	}

}
