package com.tradeapp.service.util.mapper.exception;

public class ServiceUnavailableException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ServiceUnavailableException(final String message) {
		super(message);
	}

	public ServiceUnavailableException(final String message, Throwable cause) {
		super(message, cause);
	}
}
