package com.farm.exception;

public class FarmerNotFoundException extends RuntimeException {

private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public FarmerNotFoundException(String message) {
		super();
		this.message = message;
	}
}
