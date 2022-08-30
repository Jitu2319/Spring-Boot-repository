package com.leadapp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leadapp.entities.Lead;
import com.leadapp.repository.LeadRepository;

@RestController
public class LeadRestController {

	@Autowired
	private LeadRepository leadrepo;

	@RequestMapping("/viewleadpage/{id}")
	public Lead getleadinfo(@PathVariable("id") long id) {
		Optional<Lead> findById = leadrepo.findById(id);
		Lead lead = findById.get();
		return lead;
	}

}
