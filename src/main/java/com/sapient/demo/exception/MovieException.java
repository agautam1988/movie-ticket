package com.sapient.demo.exception;

public class MovieException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 937149262942907556L;
	public MovieException(String message) {
		super(message);
	}
	public MovieException(String msg,Throwable th) {
		super(msg,th);
	}
}
