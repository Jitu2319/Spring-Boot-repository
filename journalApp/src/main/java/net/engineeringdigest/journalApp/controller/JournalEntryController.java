package net.engineeringdigest.journalApp.controller;

import java.util.*;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.engineeringdigest.journalApp.Model.Journal;

@RestController
@RequestMapping("/journalOld")
public class JournalEntryController {

//	private Map<Long, Journal> journalEntries = new HashMap<>();
//
//	@GetMapping
//	public List<Journal> getAll() {
//		return new ArrayList<>(journalEntries.values());
//	};
//
//	@PostMapping
//	public boolean createEntry(@RequestBody Journal entry) {
//		System.out.println(entry);
//		journalEntries.put(entry.getId(), entry);
//		return true;
//	}
//
//	@GetMapping("/getById/{id}")
//	public Journal getJournalById(@PathVariable Long id) {
//		Journal journal = journalEntries.get(id);
//		return journal;
//
//	};
//
//	@DeleteMapping("/deleteById/{id}")
//	public boolean deleteJournalById(@PathVariable Long id) {
//		journalEntries.remove(id);
//		return true;
//
//	};
//
//	@PostMapping("/updateById/{id}")
//	public Journal updateJournalById(@PathVariable Long id, @RequestBody Journal entry) {
//		Journal Journal = journalEntries.put(id, entry);
//		return Journal;
//
//	};

}
