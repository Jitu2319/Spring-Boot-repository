package net.engineeringdigest.journalApp.Services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import net.engineeringdigest.journalApp.Model.Users;
import net.engineeringdigest.journalApp.Repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	public List<Users> getAll() {
		List<Users> findAll = userRepo.findAll();
		return findAll;
	};

	public boolean saveEntry(Users user) {
		Users insert = userRepo.save(user);
		return true;

	}
	
	
	public Users findByUserName(String userName) {
		return userRepo.findByUserName(userName);
	}

	public Users UpdateByUserName(String userName, Users user) {
		Users userInDB = userRepo.findByUserName(userName);
		userInDB.setPassword(passwordEncoder.encode(user.getPassword()));
		userInDB.setUserName(user.getUserName());
		userRepo.save(userInDB);
		return userInDB;
	}

	public void deleteByUserName(String userName) {
		userRepo.deleteByUserName(userName);
	}

}
