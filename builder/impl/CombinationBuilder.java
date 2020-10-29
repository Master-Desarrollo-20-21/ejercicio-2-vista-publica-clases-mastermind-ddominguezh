package com.ddominguezh.master.v4.exercise.builder.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.ddominguezh.master.v4.exercise.builder.ICombinationBuilder;
import com.ddominguezh.master.v4.exercise.entity.Combination;
import com.ddominguezh.master.v4.exercise.entity.GestorIO;
import com.ddominguezh.master.v4.exercise.enums.Color;

public class CombinationBuilder implements ICombinationBuilder {

	Combination combination;

	public CombinationBuilder withMachine() {
		List<Color> values = Arrays.asList(Color.values());
	    Collections.shuffle(values);
		Color[] colors = new Color[4];
		for( int i = 0 ; i < colors.length ; i++) {
			colors[i] = values.get(i);
		}
		this.combination = new Combination(colors);
		return this;
	}

	public CombinationBuilder withPlayer() {
		GestorIO gestor = new GestorIO();
		boolean isValid = false;
		do {
			this.combination = new Combination(gestor.read());
			isValid = this.combination.isValid();
		}while(!isValid);
		return this;
	}
	
	@Override
	public Combination build() {
		return new Combination(combination);
	}
}
