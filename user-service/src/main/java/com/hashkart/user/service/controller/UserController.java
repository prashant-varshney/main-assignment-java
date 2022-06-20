package com.hashkart.user.service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hashkart.user.service.models.User;
import com.hashkart.user.service.services.UserService;

@RestController
public class UserController {

	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Value("${server.port}")
    private String serverPort;

	@Autowired
	private UserService userService;

	
	@GetMapping("/users/login")
	public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {

		logger.info("retrieve user controller...!");
		User responseUser = userService.checkUser(username,password);
		
		return new ResponseEntity<String>("Authentication Success", new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping("/users/signUp")
	public ResponseEntity<User> signUp(@RequestBody User user) {

		logger.info("create user controller...!");
		User savedUser = userService.createUser(user);
		return new ResponseEntity<User>(savedUser, new HttpHeaders(), HttpStatus.CREATED);
	}

}
