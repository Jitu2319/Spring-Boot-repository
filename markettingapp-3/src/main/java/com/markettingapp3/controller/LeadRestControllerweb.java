package com.markettingapp3.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.markettingapp3.entities.Lead;
import com.markettingapp3.repositories.LeadRepository;

@RestController
public class LeadRestControllerweb {
	@Autowired
	private LeadRepository leadRepo;

	@GetMapping("/lead/{id}")
	public Lead getLead(@PathVariable long id) {
		Optional<Lead> findById = leadRepo.findById(id);
		Lead lead = findById.get();
		return lead;

	}

}
