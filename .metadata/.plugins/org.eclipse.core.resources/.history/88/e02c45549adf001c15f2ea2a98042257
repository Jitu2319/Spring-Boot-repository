package com.testlead.controller;

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

import com.testlead.entity.Lead;
import com.testlead.repository.LeadRepository;

@RestController
@RequestMapping("/records")
public class LeadRestController1 {
	
	@Autowired
	private LeadRepository leadrepo;
	
	@GetMapping
	public List<Lead> listall() {
		List<Lead> leads = leadrepo.findAll();
		return leads;
	}
	@PostMapping
	public void saveonerecord(@RequestBody Lead lead) {
		leadrepo.save(lead);
	}
	@PutMapping
	public void updateonerecord(@RequestBody Lead lead) {
		leadrepo.save(lead);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteonerecord(@PathVariable("id") Long id) {
		leadrepo.deleteById(id);
	}
}
