package com.flightreservation.repos;

import org.springframework.data.repository.CrudRepository;

import com.flightreservation.entities.User;

public interface UserRepo extends CrudRepository<User, Long> {

}
