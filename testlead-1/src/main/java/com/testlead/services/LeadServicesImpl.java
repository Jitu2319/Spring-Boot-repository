package com.testlead.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testlead.entity.Lead;
import com.testlead.repository.LeadRepository;

@Service
public class LeadServicesImpl implements LeadServices {

	@Autowired
	private LeadRepository leadRepo;

	@Override
	public void saveonerecord(Lead lead) {
		leadRepo.save(lead);
	}

	@Override
	public List<Lead> getallleads() {
		List<Lead> leads = leadRepo.findAll();
		return leads;
	}

	@Override
	public Lead getleadinfo(Long id) {
		Optional<Lead> findById = leadRepo.findById(id);
		Lead lead = findById.get();
		return lead;
	}

	@Override
	public void deleteonerecord(Long id) {
		leadRepo.deleteById(id);
		
	}

}
