package com.acrmapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acrmapp.entity.Lead;
import com.acrmapp.repository.LeadRepository;

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
	public Lead findLeadById(Long id) {
		Optional<Lead> findById = leadRepo.findById(id);
		Lead lead = findById.get();
		return lead;
	}

	@Override
	public void deleteLeadById(long id) {
		leadRepo.deleteById(id);
		
	}

}
