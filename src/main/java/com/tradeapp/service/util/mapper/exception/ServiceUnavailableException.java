package com.tradeapp.service.util.mapper.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ServiceUnavailableException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ServiceUnavailableException(final String message) {
		super(message);
	}

	public ServiceUnavailableException(final String message, Throwable cause) {
		super(message, cause);
	}
}
