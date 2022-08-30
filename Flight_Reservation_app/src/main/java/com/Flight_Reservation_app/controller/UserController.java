package com.Flight_Reservation_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Flight_Reservation_app.entity.User;
import com.Flight_Reservation_app.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepo;

	@RequestMapping("/showLoginPage")
	public String showLoginPage() {
		return "login/login1";
	}

	@RequestMapping("/showReg")
	public String showReg() {
		return "login/showReg";
	}

	@RequestMapping("/saveReg")
	public String savereg(@ModelAttribute("user") User user) {
		userRepo.save(user);
		return "login/login1";
	}

	@RequestMapping("/verifylogin")
	public String verifylogin(@RequestParam("email") String email, @RequestParam("password") String password,
			ModelMap model) {
		User user = userRepo.findByEmail(email);
		if (user != null) {
			if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
				return "findFlights";
			} else {
				model.addAttribute("Error", "Invalid Username/Password");
				return "login/login1";

			}
		} else {
			model.addAttribute("Error", "Invalid Username/Password");
			return "login/login1";
		}

	}

}