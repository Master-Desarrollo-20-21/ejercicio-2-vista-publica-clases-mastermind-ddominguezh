package com.ddominguezh.master.v4.exercise.exception;

public class RepeatedColorsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9020491888969390827L;
	public RepeatedColorsException() {
		super("Wrong proposed, can not repeat color.");
	}
}
