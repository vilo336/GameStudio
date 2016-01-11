package minesweeper;

import minesweeper.consoleui.ConsoleUI;
import minesweeper.core.Field;
import score.HallOfFameDB;

public class Main {

	public static void main(String[] args) {
		
		Field field = new Field(9, 9, 1);
		ConsoleUI ui = new ConsoleUI(field);
		ui.play();	
		
	}
}
