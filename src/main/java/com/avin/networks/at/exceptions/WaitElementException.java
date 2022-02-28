package com.avin.networks.at.exceptions;

@SuppressWarnings("serial")
public class WaitElementException extends CustomException {

	public WaitElementException(String message) {
		super(message);
	}

	public WaitElementException(String message, Throwable cause) {
		super(message, cause);
	}
}
