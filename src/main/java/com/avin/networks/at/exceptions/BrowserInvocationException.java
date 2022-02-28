package com.avin.networks.at.exceptions;


@SuppressWarnings("serial")
public class BrowserInvocationException extends CustomException{

	/**
	 * Pass the message that needs to be appended to the stacktrace
	 * @param message Details about the exception or custom message
	 */
	public BrowserInvocationException(String message) {
		super(message);
	}

	
	public BrowserInvocationException(String message, Throwable cause) {
		super(message, cause);
	}

}
