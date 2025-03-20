package net.engineeringdigest.journalApp.Repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import net.engineeringdigest.journalApp.Model.Journal;

@Repository
public interface JournalEntryRepository extends MongoRepository<Journal, ObjectId> {

	List<Journal> getAllEntriesByName(String name);

}
