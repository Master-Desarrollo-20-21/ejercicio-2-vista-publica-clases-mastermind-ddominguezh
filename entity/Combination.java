package com.ddominguezh.master.v4.exercise.entity;

import com.ddominguezh.master.v4.exercise.enums.Color;

public class Combination {

	private static int COLORS_LENGTH = 4;
	private Color[] colors;
	private GestorIO io = new GestorIO();
	public boolean isValid() {
		if(!isValidLength()) {
			return false;
		}
		if(!isValidColors()) {
			return false;
		}
		if(!haveRepeatingColors()) {
			return false;
		}
		return true;
	}
	private boolean isValidLength() {
		if(this.colors.length != COLORS_LENGTH) {
			io.write("Wrong proposed combination length");
			return false;
		}
		return true;
	}
	private boolean isValidColors() {
		for(Color color : this.colors) {
			if(color == null) {
				io.write("Wrong colors they must be: " + Color.shortNames());
				return false;
			}
		}
		return true;
	}
    private boolean haveRepeatingColors() {
    		for(int i = 0 ; i < this.colors.length ; i++) {
    			Color color = this.colors[i];
    			for( int j = i+1; j < this.colors.length ; j++) {
    				Color nextColor = this.colors[j];
    				if(color.equals(nextColor)) {
    					io.write("Wrong proposed, can not repeat color.");
    					return false;
    				}
    			}
    		}
    		return true;
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
