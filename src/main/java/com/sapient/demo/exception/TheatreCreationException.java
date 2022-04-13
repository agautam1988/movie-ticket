package com.sapient.demo.exception;

public class TheatreCreationException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2436534858298971556L;
	public TheatreCreationException(String message) {
		super(message);
	}
	public TheatreCreationException(String msg,Throwable th) {
		super(msg,th);
	}
}
