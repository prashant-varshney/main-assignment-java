package com.hashkart.inventory.service.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NoCategoryFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public NoCategoryFoundException(String msg) {
		super(msg);
	}

}
