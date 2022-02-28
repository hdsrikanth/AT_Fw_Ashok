package com.avin.networks.at.exceptions;

@SuppressWarnings("serial")
public class CustomException extends RuntimeException {

	public CustomException(String message) {
		super(message);
	}
	
	public CustomException(String message, Throwable cause) {
		super(message, cause);
	}
}
