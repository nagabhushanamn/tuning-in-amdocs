package com.example.exceptions;

public class AccountBalanceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountBalanceException(String message) {
		super(message);
	}

}
