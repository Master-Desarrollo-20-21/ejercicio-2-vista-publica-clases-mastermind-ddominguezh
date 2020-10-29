package com.ddominguezh.master.v4.exercise.entity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.ddominguezh.master.v4.exercise.enums.Color;

public class SecretCombination extends Combination {

	public SecretCombination() {
		super();
		List<Color> values = Arrays.asList(Color.values());
	    Collections.shuffle(values);
		this.colors = new Color[4];
		for( int i = 0 ; i < this.colors.length ; i++) {
			this.colors[i] = values.get(i);
		}
	}
}
