package com.hashkart.user.service.repositories;

import java.util.Optional;

import com.hashkart.user.service.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	 public Optional<User> findByUsernameAndPassword(String userName, String password);

	public Optional<User> findByUsername(String username);

	public Optional<User> findByEmailId(String emailId);

}
