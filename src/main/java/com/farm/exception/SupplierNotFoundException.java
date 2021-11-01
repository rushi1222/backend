package com.farm.exception;

public class SupplierNotFoundException extends RuntimeException {

	
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public SupplierNotFoundException(String message) {
		super();
		this.message = message;
	}
}
