package com.Jwt.AuthToken.exceptions;

import lombok.NoArgsConstructor;


@NoArgsConstructor
public class BadRequestServiceAlertException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BadRequestServiceAlertException(final String message) {
        super(message);
    }
}
