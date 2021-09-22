package com.skylift.fbs.exception;

public class InsufficiantAmountException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InsufficiantAmountException(String expMsg) {
		super(expMsg);
	}

}
