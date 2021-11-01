package com.farm.exception;

public class TipNotFoundException extends RuntimeException {

private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public TipNotFoundException(String message) {
		super();
		this.message = message;
	}
}
