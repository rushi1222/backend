package com.farm.exception;

public class ComplaintNotFoundException extends RuntimeException {

	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ComplaintNotFoundException(String message) {
		super();
		this.message = message;
	}
}
