package com.flightreservation.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flightreservation.entities.User;
import com.flightreservation.service.UserService;
import com.flightreservation.utility.HelperUtil;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/index")
	public String showRegister(@ModelAttribute("User") User user) {
		return "register";
	}

	@RequestMapping("/registerUser")
	public String registerUser(@ModelAttribute("User") User user,
			@RequestParam(value = "action", required = false) String action, HttpSession session) {
		//register the user in the system
		user.setPassword(HelperUtil.getInstance().encrypt(user.getPassword()));
		userService.saveUser(user);
		session.setAttribute("user", user);
		
		//check if the user arrived from showFlight page
		String id = (String) session.getAttribute("id");
		if (HelperUtil.notNull(action) && HelperUtil.notNull(id)) {
			if (action.equals("bookFlight")) {
				session.setAttribute("action", "bookFlight");
				
				return "forward:/bookFlight?id="+id;
			}
		}
		session.removeAttribute("action");
		session.setAttribute("action", "showAllFlights");
		return "login";
	}
	
	@RequestMapping("/login")
	public String login(@ModelAttribute("User") User user, HttpSession httpsession) {
		System.out.println("email"+user.getEmail());
		return "forward:/showAllFlights";
	}

}
