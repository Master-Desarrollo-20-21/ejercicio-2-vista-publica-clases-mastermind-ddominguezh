package com.ddominguezh.master.v4.exercise.entity;

import com.ddominguezh.master.v4.exercise.builder.impl.CombinationBuilder;

public class Game {

	private final static int MAX_ATTEMTPS = 10;
	private Combination secret;
	private Attempt[] attempts;
	private int numAttempts;
	private GestorIO io = new GestorIO();
	public Game() {
		this.secret = new CombinationBuilder().withMachine().build();
		this.attempts = new Attempt[MAX_ATTEMTPS];
		this.numAttempts = 0;
	}
	public void play() {
		do {
			io.write("Attempt " + this.numAttempts);
			io.write(secret.toString());
			attempts[this.numAttempts] = new Attempt().result(secret);
			this.numAttempts++;
			for(int j = 0 ; j < this.numAttempts ; j++) {
				attempts[j].print();
			}
			io.write("");
		}while(moreAttempts());
		finish();
	}
	private boolean moreAttempts() {
		Attempt attempt = this.attempts[this.numAttempts - 1];
		return attempt.isLoser() && attemptsRemain();
	}
	private boolean attemptsRemain() {
		return this.attempts[MAX_ATTEMTPS - 1] == null;
	}
	private void finish() {
		if(hasWon()) {
			io.write("You're winner :-)!!");
		}else {
			io.write("You loose :-(");
		}
	}
	public boolean hasWon() {
		Attempt attempt = this.attempts[this.numAttempts - 1];
		return attempt.isWinner();
	}
}
