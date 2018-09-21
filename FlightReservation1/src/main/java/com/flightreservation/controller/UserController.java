package com.flightreservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flightreservation.entities.User;
import com.flightreservation.repos.UserRepo;

@Controller
public class UserController {

	@Autowired
	UserRepo userRepo;
	
	@RequestMapping("/index")
	public String showRegister() {
		return "register";
	}
	
	@RequestMapping("/registerUser")
	public String registerUser(@ModelAttribute("user") User user) {
		userRepo.save(user);
		return "/login";
	}
}
