package com.flightreservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@RequestMapping("/showReq")
	public String showRegisterPage() {
		
		return "login/registerUser";
	}
}
