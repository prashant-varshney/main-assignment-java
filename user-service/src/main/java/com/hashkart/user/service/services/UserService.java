package com.hashkart.user.service.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hashkart.user.service.exceptions.PasswordIsWrongException;
import com.hashkart.user.service.exceptions.ResourceAlreadyExistsException;
import com.hashkart.user.service.exceptions.ResourceNotFoundException;
import com.hashkart.user.service.models.User;
import com.hashkart.user.service.repositories.UserRepository;

@Service
public class UserService {

	private static Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;

	public User checkUser(String username, String password) throws ResourceNotFoundException {
		Optional<User> user = userRepository.findByUsername(username);
		if (user.isPresent()) {
			logger.info("getUser {}", this.getClass().getName());

			Optional<User> userWithPass = userRepository.findByUsernameAndPassword(username, password);

			if (userWithPass.isPresent()) {

				return user.get();

			} else {
				logger.error("Please enter the correct password", this.getClass().getName());
				throw new PasswordIsWrongException("Password is wrong!!");
			}
		} else {
			logger.error("getUser {} User not Found!", this.getClass().getName());
			throw new ResourceNotFoundException("User does not exist!!");
		}
	}

	public User createUser(User user) throws ResourceAlreadyExistsException {

		if (user.getEmailId() != null) {
			Optional<User> u = userRepository.findByEmailId(user.getEmailId());
			if (u.isPresent()) {
				logger.error("createUser {} User already exists!", this.getClass().getName());
				throw new ResourceAlreadyExistsException("User Already Exist");
			}
		}
		logger.info("createUser {}", this.getClass().getName());
		return userRepository.save(user);
	}

}
