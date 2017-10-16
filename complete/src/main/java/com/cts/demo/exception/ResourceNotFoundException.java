package com.cts.demo.exception;

public class ResourceNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long customerId;
	 
    public ResourceNotFoundException(Long customerId, String message) {
        super(message);
        this.customerId = customerId;
    }

}
