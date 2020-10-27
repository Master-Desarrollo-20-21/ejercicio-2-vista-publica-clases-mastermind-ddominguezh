package com.ddominguezh.master.v4.exercise.entity;

import com.ddominguezh.master.v4.exercise.enums.Color;
import com.ddominguezh.master.v4.exercise.exception.ColorException;
import com.ddominguezh.master.v4.exercise.exception.Exception;
import com.ddominguezh.master.v4.exercise.exception.LengthException;
import com.ddominguezh.master.v4.exercise.exception.RepeatedColorsException;

public class Combination {

	private static int COLORS_LENGTH = 4;
	private Color[] colors;
	public Combination isValid() throws Exception{
		isValidLength();
		isValidColors();
		haveRepeatingColors();
		return this;
	}
	private void isValidLength() throws LengthException {
		if(this.colors.length != COLORS_LENGTH) {
			throw new LengthException();
		}
	}
	private void isValidColors() throws ColorException {
		for(Color color : this.colors) {
			if(color == null) {
				throw new ColorException();
			}
		}
	}
    private void haveRepeatingColors() throws RepeatedColorsException {
    		for(int i = 0 ; i < this.colors.length ; i++) {
    			Color color = this.colors[i];
    			for( int j = i+1; j < this.colors.length ; j++) {
    				Color nextColor = this.colors[j];
    				if(color.equals(nextColor)) {
    					throw new RepeatedColorsException();
    				}
    			}
    		}
    }
    @Override
    public String toString() {
    		String result = "";
    		for(Color color : this.colors) {
    			result += ""+color.shortName();
    		}
    		return result;
    }
    
    public boolean equals(Combination combination) {
    		for (int i = 0 ; i < this.colors.length ; i++ ) {
    			if(notEquals(combination, i)) {
    				return false;
    			}
    		}
    		return true;
    }
    
    public boolean equals(Combination combination, int index) {
		return this.colors[index].equals(combination.colors[index]);
    }
    public boolean notEquals(Combination combination, int index) {
		return !equals(combination, index);
    }
    public boolean contains(Combination combination, int index) {
    		Color searchedColor = combination.colors[index];
    		for (int i = 0 ; i < this.colors.length ; i++ ) {
			if(this.colors[i].equals(searchedColor)) {
				return true;
			}
		}
		return false;
    }
    public int lenght() {
    		return COLORS_LENGTH;
    }
    public Combination(String colors) {
		this.colors = Color.values(colors);
	}
    public Combination(Color[] colors) {
		this.colors = colors;
	}
	public Combination(Combination combination) {
		this(combination.colors);
	}
}
