package com.flightreservation.service;

import org.springframework.stereotype.Service;

import com.flightreservation.entities.User;

@Service
public interface UserService {
	
	User saveUser(User user);

}
