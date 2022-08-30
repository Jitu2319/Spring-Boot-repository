package com.studentenquiry.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentenquiry.entities.Leads;
import com.studentenquiry.repositories.LeadRepository;

@Service
public class LeadServicesImpl implements LeadServices {

	@Autowired
	private LeadRepository leadRepo;

	@Override
	public void saveLead(Leads lead) {
		leadRepo.save(lead);

	}

}
