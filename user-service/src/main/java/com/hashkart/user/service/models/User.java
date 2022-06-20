package com.hashkart.user.service.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;
	private String emailId;
	private String name;
	private String username;
	private String password;

	public User(String emailId, String name, String username, String password) {
		this.emailId = emailId;
		this.name = name;
		this.username = username;
		this.password = password;
	}
}
