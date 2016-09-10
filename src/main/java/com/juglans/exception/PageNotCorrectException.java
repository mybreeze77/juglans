package com.juglans.exception;


public class PageNotCorrectException extends RuntimeException {

	private static final long serialVersionUID = -6598083737880253802L;

	public PageNotCorrectException() {
	}

	public PageNotCorrectException(String message) {
		super(message);
	}

	public PageNotCorrectException(Throwable cause) {
		super(cause);
	}

	public PageNotCorrectException(String message, Throwable cause) {
		super(message, cause);
	}

}
