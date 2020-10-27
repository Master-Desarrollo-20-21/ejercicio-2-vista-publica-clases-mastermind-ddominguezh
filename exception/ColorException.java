package com.ddominguezh.master.v4.exercise.exception;

import com.ddominguezh.master.v4.exercise.enums.Color;

public class ColorException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4703550789964943164L;
	public ColorException() {
		super("Wrong colors they must be: " + Color.shortNames());
	}
}
