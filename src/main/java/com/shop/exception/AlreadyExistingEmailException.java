package com.shop.exception;

public class AlreadyExistingEmailException extends RuntimeException {
	public AlreadyExistingEmailException(String message) {
		super(message);
	}
}
