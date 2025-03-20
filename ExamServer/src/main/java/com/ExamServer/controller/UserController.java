package com.ExamServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ExamServer.model.user;
import com.ExamServer.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository UserRepo;

	@GetMapping("/test")
	@ResponseBody
	public String saveOne() {
		user user = new user();
		user.setEmail("Jitendra@gmail.com");
		user.setFirstName("Jitu");
		UserRepo.save(user);
		return "Working";

	}

}
