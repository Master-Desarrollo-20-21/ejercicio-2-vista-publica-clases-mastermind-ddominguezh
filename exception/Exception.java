package com.ddominguezh.master.v4.exercise.exception;

import com.ddominguezh.master.v4.exercise.entity.GestorIO;

public class Exception extends java.lang.Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8088706241473931356L;
	public Exception(String message) {
		super(message);
	}

	public void print() {
		GestorIO IO = new GestorIO();
		IO.write(this.getMessage());
	}
}
