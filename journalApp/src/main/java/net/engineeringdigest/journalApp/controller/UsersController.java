package net.engineeringdigest.journalApp.controller;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import net.engineeringdigest.journalApp.Model.EmailRequest;
import net.engineeringdigest.journalApp.Model.Users;
import net.engineeringdigest.journalApp.Repository.UserRepository;
import net.engineeringdigest.journalApp.Services.EmailService;
import net.engineeringdigest.journalApp.Services.UserService;
import net.engineeringdigest.journalApp.utilities.Constants;

@RestController
@RequestMapping("/user")
@Slf4j
public class UsersController<userName> {

//	private static final Logger log = LoggerFactory.getLogger(UsersController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private EmailService emailService;

	private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@GetMapping("/getAllUsers")
	public ResponseEntity<?> getAll() {
		log.info("Inside getallusers..");
		try {
			List<Users> all = userService.getAll();
			if (!all.isEmpty() && all != null) {
				return new ResponseEntity(all, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity(HttpStatus.NOT_FOUND);
	};

	@GetMapping("/getUserByUserName/{userName}")
	public ResponseEntity<?> getUsersById(@PathVariable String userName) {
		log.info("Inside getUserById..");

		Users userInDB = userRepo.findByUserName(userName);

		if (userInDB != null) {
			return new ResponseEntity<>(userInDB, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	};

	@DeleteMapping("/deleteUser")
	public ResponseEntity<?> deleteUser() {
		log.info("Inside deleteUserById..");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userName = authentication.getName();
		userService.deleteByUserName(userName);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	};

	@PutMapping("/updateUser")
	public ResponseEntity<?> updateUser(@RequestBody Users user) {
		log.info("Inside updateUserById..");

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userName = authentication.getName();

		if (user == null || user.getUserName() == null || user.getPassword() == null) {
			return new ResponseEntity<>("Invalid request body", HttpStatus.BAD_REQUEST);
		}
		Users updatedUsers = userService.UpdateByUserName(userName, user);
		if (updatedUsers != null) {
			return new ResponseEntity<>(updatedUsers, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	};

	@PostMapping("/send")
	public String sendMail(@RequestBody EmailRequest emailRequest) {
		String to = emailRequest.getTo();
//		to = Constants.EMAIL_TO;
		String subject = emailRequest.getSubject();
//		subject = Constants.EMAIL_SUBJECT;
		String from = emailRequest.getFrom();
//		from = Constants.EMAIL_FROM;
		String body = emailRequest.getBody();
//		body = Constants.EMAIL_BODY;

		String filePath = Constants.FILE_PATH;
		emailService.sendEmail(to, subject, from, body, filePath);
		return "Email sent successfully!";
	}

}
