package com.ddominguezh.master.v4.exercise.entity;

import java.util.Scanner;

public class GestorIO {

	private Scanner scanner;
	public GestorIO() {
		this.scanner = new Scanner(System.in);
	}
	public String read() {
        return this.scanner.nextLine(); 
	}

	public GestorIO write(String value) {
		System.out.print(value);
		return this;
	}
	
	public GestorIO writeln(String value) {
		System.out.println(value);
		return this;
	}

}
