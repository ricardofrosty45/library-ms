package com.library.ms.exceptions;

public class BookException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public BookException(String message) {
		super(String.format(message));
	}

}
