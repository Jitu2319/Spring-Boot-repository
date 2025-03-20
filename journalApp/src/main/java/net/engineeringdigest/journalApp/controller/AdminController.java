package net.engineeringdigest.journalApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.engineeringdigest.journalApp.Model.Users;
import net.engineeringdigest.journalApp.Services.UserService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UserService userService;

	@GetMapping("/getAllUsers")
	public ResponseEntity<?> getAll() {
		System.out.println("Adminnnnn  Inside getallusers..");
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

}
