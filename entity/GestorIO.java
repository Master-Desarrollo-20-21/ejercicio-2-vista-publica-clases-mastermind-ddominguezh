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

	public void write(String value) {
		System.out.println(value);
	}

}
