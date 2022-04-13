package com.sapient.demo.exception;

public class ShowQueryException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1936888901617426148L;
	public ShowQueryException(String message) {
		super(message);
	}
	public ShowQueryException(String msg,Throwable th) {
		super(msg,th);
	}
}
