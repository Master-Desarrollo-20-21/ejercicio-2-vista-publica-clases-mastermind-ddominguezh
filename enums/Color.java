package com.ddominguezh.master.v4.exercise.enums;

public enum Color {
	RED('r'),
    BLUE('b'),
    GREEN('g'),
    YELLOW('y'),
    PINK('p'),
    MAGENTE('m'),
    ORANGE('o'),
    SILVER('s');
    private char shortName;
    Color(char shortName) {
    		this.shortName = shortName;
    }
	public static Color[] values(String value) {
		char[] chars = value.toCharArray();
		Color[] colors = new Color[chars.length];
		for(int i = 0 ; i < chars.length ; i++ ) {
			colors[i] = Color.valueOf(chars[i]);
		}
		return colors;
	}
	public static Color valueOf(char value) {
		for(Color color : Color.values()) {
			if(color.shortName == value) {
				return color;
			}
		}
		return null;
	}
	public char shortName() {
		return this.shortName;
	}
	public static String shortNames() {
		String result = "";
		for(Color color : Color.values()) {
			result += color.shortName();
		}
		return result;
	}
}
