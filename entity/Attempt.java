package com.ddominguezh.master.v4.exercise.entity;

import java.util.Arrays;

package com.ddominguezh.master.v4.exercise.entity;

import java.util.Arrays;

import com.ddominguezh.master.v4.exercise.enums.Spike;

public class Attempt {

	private Combination proposed;
	private Spike[] spikes;
	private GestorIO io = new GestorIO();
	public Attempt() {
		this.proposed = new ProposedCombination();
		this.spikes = new Spike[4];
	}

	public Attempt result(Combination secret) {
		if(proposed.equals(secret)) {
			Arrays.fill(this.spikes, Spike.BLACK);
		}else {
			for(int i = 0 ; i < this.proposed.lenght() ; i++ ) {
				if(secret.equals(proposed, i)) {
					this.spikes[i] = Spike.BLACK;
				}else if(secret.contains(proposed, i)) {
					this.spikes[i] = Spike.WHITE;
				}
			}
		}
		return this;
	}

	public Attempt print() {
		io.writeln(proposed.toString() + " ---> " + numSpikes(Spike.BLACK)  + " blacks - " + numSpikes(Spike.WHITE) + " whites.");
		return this;
	}
	
	private int numSpikes(Spike foundSpike) {
		int count = 0;
		for(Spike spike : this.spikes) {
			if(foundSpike.equals(spike)) {
				count++;
			}
		}
		return count;
	}
	
	public boolean isWinner() {
		return numSpikes(Spike.BLACK) == 4;
		
	}
	
	public boolean isLoser() {
		return !isWinner();
	}

}
