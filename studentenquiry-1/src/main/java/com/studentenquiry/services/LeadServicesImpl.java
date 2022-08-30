package com.studentenquiry.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentenquiry.entities.Lead;
import com.studentenquiry.repositories.LeadRepository;
@Service
public class LeadServicesImpl implements LeadServices {
	
	@Autowired
	private LeadRepository leadRepo;

	@Override
	public void saveLead(Lead lead) {
		leadRepo.save(lead);
		

	}

}
