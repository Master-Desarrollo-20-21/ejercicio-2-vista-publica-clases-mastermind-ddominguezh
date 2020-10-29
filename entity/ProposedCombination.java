package com.ddominguezh.master.v4.exercise.entity;

import com.ddominguezh.master.v4.exercise.enums.Color;

public class ProposedCombination extends Combination {

	public ProposedCombination() {
		super();
		GestorIO gestor = new GestorIO();
		boolean isValid = false;
		do {
			this.colors = Color.values(gestor.read());
			isValid = isValid();
		}while(!isValid);
	}
}
