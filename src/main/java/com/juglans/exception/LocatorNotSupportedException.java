package com.juglans.exception;


public class LocatorNotSupportedException extends RuntimeException {

	private static final long serialVersionUID = -6598083737880253802L;

	public LocatorNotSupportedException() {
	}

	public LocatorNotSupportedException(String message) {
		super(message);
	}

	public LocatorNotSupportedException(Throwable cause) {
		super(cause);
	}

	public LocatorNotSupportedException(String message, Throwable cause) {
		super(message, cause);
	}

}
