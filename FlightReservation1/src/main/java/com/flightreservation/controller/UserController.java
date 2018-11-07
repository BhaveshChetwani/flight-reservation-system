package com.flightreservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flightreservation.entities.User;
import com.flightreservation.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/index")
	public String showRegister() {
		return "register";
	}
	
	@RequestMapping("/registerUser")
	public String registerUser(@ModelAttribute("user") User user) {
		userService.saveUser(user);
		return "/login";
	}
	
}
