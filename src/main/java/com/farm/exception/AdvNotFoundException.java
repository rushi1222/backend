
package com.farm.exception;

public class AdvNotFoundException extends RuntimeException{

 

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
    
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public AdvNotFoundException(String message) {
        super();
        this.message = message;
    }
}

