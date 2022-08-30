package com.spring_security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/home")
	public String homePage() {
		return "Home Page";
	}

	@GetMapping("/admin")
	public String adminPage() {
		return "Admin Page";
	}

	@GetMapping("/user")
	public String userPage() {
		return "User Page";
	}

}
