package com.ddominguezh.master.v4.exercise.entity;

public class Game {

	private final static int MAX_ATTEMTPS = 10;
	private Combination secret;
	private Attempt[] attempts;
	private int numAttempts;
	private GestorIO io = new GestorIO();
	public Game() {
		this.secret = new SecretCombination();
		this.attempts = new Attempt[MAX_ATTEMTPS];
		this.numAttempts = 0;
	}
	public void play() {
		do {
			io.writeln("Attempt " + this.numAttempts);
			attempts[this.numAttempts] = new Attempt().result(secret);
			this.numAttempts++;
			printAttempts();
		}while(haveMoreAttempts());
		finish();
	}
	private void printAttempts() {
		for(int j = 0 ; j < this.numAttempts ; j++) {
			attempts[j].print();
		}
		io.writeln("");
	}
	private boolean haveMoreAttempts() {
		Attempt attempt = this.attempts[this.numAttempts - 1];
		return attempt.isLoser() && haveAttemptsRemain();
	}
	private boolean haveAttemptsRemain() {
		return this.attempts[MAX_ATTEMTPS - 1] == null;
	}
	private void finish() {
		if(hasWon()) {
			io.writeln("You're winner :-)!!");
		}else {
			io.writeln("You loose :-(");
		}
	}
	public boolean hasWon() {
		Attempt attempt = this.attempts[this.numAttempts - 1];
		return attempt.isWinner();
	}
}
