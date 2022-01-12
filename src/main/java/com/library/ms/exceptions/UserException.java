package com.library.ms.exceptions;

public class UserException extends RuntimeException {

	private static final long serialVersionUID = 7585590230353305627L;

	public UserException(String message) {
		super(String.format(message));
	}

}