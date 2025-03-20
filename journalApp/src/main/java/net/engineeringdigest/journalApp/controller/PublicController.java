package net.engineeringdigest.journalApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.engineeringdigest.journalApp.Model.Users;
import net.engineeringdigest.journalApp.Services.UserService;

@RestController
@RequestMapping("/public")
public class PublicController {

	@Autowired
	private UserService userService;

	private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@PostMapping("/createUser")
	public ResponseEntity<?> createUser(@RequestBody Users user) {
		System.out.println("Inside createUsers..");
		try {
			System.out.println(user);
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			user.setRoles(user.getRoles());
			userService.saveEntry(user);
			return new ResponseEntity<>(user, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
		}

	}

}
