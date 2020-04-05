package com.ryangrillo.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ryangrillo.service.UserService;
import com.ryangrillo.model.User;



@RestController
public class UserController {
	
	Logger logger = LoggerFactory.getLogger(UserController.class);

    private UserService userService;
    
    @Autowired
    UserController(UserService userService) {
    	this.userService = userService;
    }

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/user")
	public User createUser(@Valid @RequestBody User user) {
    	logger.info("create user with fields {}", user.toString());
		return userService.createUser(user);
	}

}
