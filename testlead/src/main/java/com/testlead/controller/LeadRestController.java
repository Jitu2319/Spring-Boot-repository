package com.testlead.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testlead.entity.Lead;
import com.testlead.repository.LeadRepository;

@RestController
public class LeadRestController {

	@Autowired
	private LeadRepository leadRepo;

	@RequestMapping("/lead/{id}")
	public Lead getleadinfo(@PathVariable("id") long id) {
		Optional<Lead> findById = leadRepo.findById(id);
		Lead lead = findById.get();
		return lead;

	}
}
