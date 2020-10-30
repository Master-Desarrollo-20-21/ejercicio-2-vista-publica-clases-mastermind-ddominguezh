package com.ddominguezh.master.v4.exercise;

import java.util.ArrayList;
import java.util.List;

import com.ddominguezh.master.v4.exercise.entity.Game;
import com.ddominguezh.master.v4.exercise.entity.GestorIO;

public class MasterMind {
	
	private static List<Game> games = new ArrayList<Game>();
	public static void main(String[] args) {
		GestorIO io = new GestorIO();
		int wons = 0;
		do {
			io.writeln("----------------- MASTERMIND -----------------");
			Game game = new Game();
			game.play();
			if(game.hasWon()) {
				wons++;
			}
			games.add(game);
		}while("Y".equalsIgnoreCase(io.write("Do you want to play again? (Y/N): ").read()));
		io.write("You have won " + wons + " times, you have lost " + (games.size() - wons) + " times");
	}

}
