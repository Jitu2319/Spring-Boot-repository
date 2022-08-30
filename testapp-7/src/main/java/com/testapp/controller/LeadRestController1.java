package com.testapp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testapp.entities.Lead;
import com.testapp.repository.LeadRepository;

@RestController
public class LeadRestController1 {

	@Autowired
	private LeadRepository leadRepo;

	@RequestMapping("/viewleadspage/{id}")
	public Lead getLead(@PathVariable("id") long id) {
		Optional<Lead> findById = leadRepo.findById(id);
		Lead lead = findById.get();
		return lead;
	}

}
