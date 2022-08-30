package com.testapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testapp.entities.Lead;
import com.testapp.repository.LeadRepository;

@Service
public class LeadServicesImpl implements LeadServices {

	@Autowired
	private LeadRepository leadRepo;

	@Override
	public Lead saveonerecord(Lead lead) {
		leadRepo.save(lead);
		return lead;
	}

	@Override
	public List<Lead> showalldata() {
		List<Lead> leads = leadRepo.findAll();
		return leads;
	}

	@Override
	public void deleteonerecord(Long id) {
		leadRepo.deleteById(id);
	}

	@Override
	public Lead getonerecord(Long id) {
		Optional<Lead> findById = leadRepo.findById(id);
		Lead lead = findById.get();
		return lead;
	}

}
