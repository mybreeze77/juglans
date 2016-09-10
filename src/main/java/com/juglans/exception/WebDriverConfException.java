package com.juglans.exception;


public class WebDriverConfException extends RuntimeException {

	private static final long serialVersionUID = -6598083737880253802L;

	public WebDriverConfException() {
	}

	public WebDriverConfException(String message) {
		super(message);
	}

	public WebDriverConfException(Throwable cause) {
		super(cause);
	}

	public WebDriverConfException(String message, Throwable cause) {
		super(message, cause);
	}

}
