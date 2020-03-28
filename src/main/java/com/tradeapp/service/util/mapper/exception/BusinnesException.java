package com.tradeapp.service.util.mapper.exception;

public class BusinnesException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BusinnesException(final String message) {
		super(message);
	}

	public BusinnesException(final String message, Throwable cause) {
		super(message, cause);
	}

}
