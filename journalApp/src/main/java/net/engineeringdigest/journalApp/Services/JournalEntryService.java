package net.engineeringdigest.journalApp.Services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import net.engineeringdigest.journalApp.Model.Journal;
import net.engineeringdigest.journalApp.Model.Users;
import net.engineeringdigest.journalApp.Repository.JournalEntryRepository;
import net.engineeringdigest.journalApp.Repository.UserRepository;

@Service
public class JournalEntryService {

	@Autowired
	private JournalEntryRepository journalRepo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private UserService userService;

	public List<Journal> getAll() {
		List<Journal> findAll = journalRepo.findAll();
		return findAll;
	};

	public List<Journal> getAllEntriesByName(String name) {
		List<Journal> findAll = journalRepo.getAllEntriesByName(name);
		return findAll;
	};

	@Transactional
	public void createEntry(Journal entry, String userName) {
		try {
			Users user = userRepo.findByUserName(userName);
			entry.setDate(LocalDateTime.now());
			Journal savedEntry = journalRepo.save(entry);
			if (user != null) {
				user.getJournalEntries().add(savedEntry);
				userService.saveEntry(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Something went wrong");
		}
	}

	public Optional<Journal> getById(ObjectId id) {
		Optional<Journal> journal = journalRepo.findById(id);
		return journal;

	}

	public boolean deleteJournalById(ObjectId id, String userName) {
		Users user = userRepo.findByUserName(userName);
		if (user != null) {
			user.getJournalEntries().removeIf(x -> x.getId().equals(id));
			userService.saveEntry(user);
		}
		journalRepo.deleteById(id);
		return true;

	}

	public Journal UpdateById(ObjectId id, Journal newEntry) {
		Journal old = journalRepo.findById(id).orElse(null);
		if (old != null) {
			old.setContent(!newEntry.getContent().isBlank() ? newEntry.getContent() : old.getContent());
			old.setName(!newEntry.getName().isBlank() ? newEntry.getName() : old.getName());
		}
		Journal savedEntry = journalRepo.save(old);
		return savedEntry;

	}

}
