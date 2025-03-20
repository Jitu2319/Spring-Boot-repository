package net.engineeringdigest.journalApp.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import net.engineeringdigest.journalApp.Model.Journal;
import net.engineeringdigest.journalApp.Model.Users;

@Repository
public interface UserRepository extends MongoRepository<Users, ObjectId> {

	Users findByUserName(String userName);

	void deleteByUserName(String userName);

}
