package com.fhec.exceptions;

public class BusinessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2582135187341454050L;

	public BusinessException() {
	}

	public BusinessException(String var1) {
		super(var1);
	}

	public BusinessException(String var1, Throwable var2) {
		super(var1, var2);
	}

	public BusinessException(Throwable var1) {
		super(var1);
	}

}
