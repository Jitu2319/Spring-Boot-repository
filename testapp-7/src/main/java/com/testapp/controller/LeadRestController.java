package com.testapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testapp.entities.Lead;
import com.testapp.repository.LeadRepository;

@RestController
@RequestMapping("/Chain")
public class LeadRestController {

	@Autowired
	private LeadRepository leadRepo;

	@GetMapping
	public List<Lead> listall() {
		List<Lead> leads = leadRepo.findAll();
		return leads;
	}

	@PostMapping
	public void addonerecord(@RequestBody Lead lead) {
		leadRepo.save(lead);

	}

	@PutMapping
	public void updaterecord(@RequestBody Lead lead) {
		leadRepo.save(lead);
	}

	@DeleteMapping("delete/{id}")
	public void deleteonerecord(@PathVariable long id) {
		leadRepo.deleteById(id);

	}
}
