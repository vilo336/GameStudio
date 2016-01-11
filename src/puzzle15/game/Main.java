package puzzle15.game;

import java.util.Scanner;

import puzzle15.core.Field;

public class Main {

	public static void main(String[] args) {

		Field field = new Field(4, 4);
		Controller ui = new Controller(field);
		ui.randomizing(field);
		ui.play();

	}

}
