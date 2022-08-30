package com.testlead.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testlead.entity.Lead;
import com.testlead.repository.LeadRepository;

@RestController
public class Leadrestcontroller {

	@Autowired
	private LeadRepository leadrepo;

	@RequestMapping("/lead/{id}")
	public Lead getLead(@PathVariable long id) {
		Optional<Lead> findById = leadrepo.findById(id);
		Lead lead = findById.get();
		return lead;

	}

}
