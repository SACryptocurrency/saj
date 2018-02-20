package com.sa.blockchain.sablockchain.exceptions;

public class SaException extends RuntimeException {
	public SaException(String message) {
		super(message);
	}

	public SaException(Exception e) {
		super(e);
	}
}
