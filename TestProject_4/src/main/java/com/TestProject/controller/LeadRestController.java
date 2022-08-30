package com.TestProject.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.TestProject.entities.Lead;
import com.TestProject.repositories.LeadRepository;

@RestController
public class LeadRestController {

	@Autowired
	private LeadRepository leadRepo;

	@GetMapping("/lead/{id}")
	public Lead getLead(@PathVariable long id) {
		Optional<Lead> findById = leadRepo.findById(id);
		Lead lead = findById.get();
		return lead;

	}

}
