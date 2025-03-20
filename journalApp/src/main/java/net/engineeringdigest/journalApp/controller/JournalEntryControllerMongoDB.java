package net.engineeringdigest.journalApp.controller;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.engineeringdigest.journalApp.Model.Journal;
import net.engineeringdigest.journalApp.Model.Users;
import net.engineeringdigest.journalApp.Services.JournalEntryService;
import net.engineeringdigest.journalApp.Services.UserService;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerMongoDB {

	@Autowired
	private JournalEntryService journalService;

	@Autowired
	private UserService userService;

	@GetMapping("/getAllJournal")
	public ResponseEntity<?> getAllJournal() {

		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String userName = authentication.getName();
			Users user = userService.findByUserName(userName);
			List<Journal> all = user.getJournalEntries();
			if (!all.isEmpty() && all != null) {
				return new ResponseEntity(all, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity(HttpStatus.NOT_FOUND);
	};

	@PostMapping("/createEntry")
	public ResponseEntity<?> createEntry(@RequestBody Journal entry) {

		try {
			System.out.println(entry);
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String userName = authentication.getName();

			journalService.createEntry(entry, userName);
			return new ResponseEntity<>(entry, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(entry, HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<?> getJournalById(@PathVariable ObjectId id) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userName = authentication.getName();
		Users user = userService.findByUserName(userName);
		List<Journal> Entry = user.getJournalEntries().stream().filter(s -> s.getId().equals(id))
				.collect(Collectors.toList());
		if (!Entry.isEmpty()) {
			Optional<Journal> journalEntry = journalService.getById(id);
			return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	};

	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<?> deleteJournalById(@PathVariable ObjectId id) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userName = authentication.getName();
		Users user = userService.findByUserName(userName);

		Journal old = journalService.getById(id).orElse(null);
		if (old == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		boolean deleteJournalById = journalService.deleteJournalById(id, userName);

		if (deleteJournalById) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	};

	@PostMapping("/updateById/{id}")
	public ResponseEntity<?> updateJournalById(@PathVariable ObjectId id, @RequestBody Journal newEntry) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userName = authentication.getName();
		Users user = userService.findByUserName(userName);
		List<Journal> Entry = user.getJournalEntries().stream().filter(s -> s.getId().equals(id))
				.collect(Collectors.toList());
		if (!Entry.isEmpty()) {
			Journal updatedJournal = journalService.UpdateById(id, newEntry);
			if (updatedJournal != null) {
				return new ResponseEntity<>(updatedJournal, HttpStatus.OK);
			}
		}

		if (newEntry == null || newEntry.getName() == null || newEntry.getContent() == null) {
			return new ResponseEntity<>("Invalid request body", HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	};

}
