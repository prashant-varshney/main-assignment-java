package com.hashkart.user.service.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PasswordIsWrongException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public PasswordIsWrongException(String msg) {
		super(msg);
	}

}
