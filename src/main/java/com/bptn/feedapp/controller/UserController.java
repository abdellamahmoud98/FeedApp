package com.bptn.feedapp.controller;

import java.sql.Timestamp;
import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bptn.feedapp.jpa.User;
import com.bptn.feedapp.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

	final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	UserService userService;

	@GetMapping("/test")
	public String testController() {
		logger.debug("The testController() method was invoked!");
		System.out.println("Hello World");
		return "The FeedApp application is up and running";
	}

	// Add listUsers method to get all the existing Users in the database:
	@GetMapping("/")
	public List<User> listUsers() {

		logger.debug("The listUsers() method was invoked!");
		return this.userService.listUsers();
	}

	// The @PathVariable annotation handles template variables in the request URI
	// mapping and sets them as method parameters:
	// Add findByUsername method to get an existing User from the database:
	@GetMapping("/{username}")
	public Optional<User> findByUsername(@PathVariable   String username) {
		logger.debug("The findByUsername() method was invoked!, username={}", username);
		return this.userService.findUserByUsername(username);
	}


	// Add createUser method to create a User in the database:
	@GetMapping("/{first}/{last}/{username}/{password}/{phone}/{emailId}")
	public String createUser(@PathVariable String first, @PathVariable String last, @PathVariable String username,
			@PathVariable String password, @PathVariable String phone, @PathVariable String emailId) {



		User user = new User();

		user.setFirstName(first);
		user.setLastName(last);
		user.setUsername(username);
		user.setPassword(password);
		user.setPhone(phone);
		user.setEmailId(emailId);
		user.setEmailVerified(false);
		user.setCreatedOn(Timestamp.from(Instant.now()));

		logger.debug("The createUser() method was invoked!, user={}", user.toString());

		this.userService.createUser(user);

		return "User Created Successfully";
	}

	@PostMapping("/signup")
	public User signup(@RequestBody User user) {
		logger.debug("Signing up, username: {}", user.getUsername());
		return this.userService.signup(user);

	}
	
	@GetMapping("/verify/email")
	public void verifyEmail() {
		 logger.debug("Verifying Email");


		    this.userService.verifyEmail();

	}
	}

