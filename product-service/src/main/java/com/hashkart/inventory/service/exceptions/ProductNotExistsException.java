package com.hashkart.inventory.service.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ProductNotExistsException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ProductNotExistsException(String msg) {
		super(msg);
	}

}
