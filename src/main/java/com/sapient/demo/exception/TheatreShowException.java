package com.sapient.demo.exception;

public class TheatreShowException extends Exception {
/**
	 * 
	 */
	private static final long serialVersionUID = 3460133765738385012L;

public TheatreShowException(String message) {
	super(message);
}
public TheatreShowException(String msg,Throwable th) {
	super(msg,th);
}
}
