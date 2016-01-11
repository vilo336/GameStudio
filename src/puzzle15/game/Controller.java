package puzzle15.game;

import java.util.Random;
import java.util.Scanner;

import puzzle15.core.Field;
import score.HallOfFame;
import score.HallOfFameDatabase;
import score.HallOfFameFile;

public class Controller {

	String name = System.getProperty("user.name");
	private Field field;
	// private HallOfFame hallOfFame = new HallOfFameFile();
	private HallOfFame hallOfFame = new HallOfFameDatabase();

	public Controller(Field field) {
		this.field = field;
	}

	public void randomizing(Field field) {
		Random random = new Random();
		int value = 0;
		// field.showField();
		for (int i = 0; i < 10; i++) {
			value = random.nextInt(4);
			switch (value + 1) {
			case 1: {
				field.moveUp(field.getXPositionOfZero(), field.getYPositionOfZero());
				break;
			}
			case 2: {
				field.moveDown(field.getXPositionOfZero(), field.getYPositionOfZero());
				break;
			}

			case 3: {
				field.moveLeft(field.getXPositionOfZero(), field.getYPositionOfZero());
				break;
			}
			case 4: {
				field.moveRight(field.getXPositionOfZero(), field.getYPositionOfZero());
				break;
			}

			}

		}
		field.showField();
	}

	public void play() {

		Scanner sc = new Scanner(System.in);
		String option = "";
		while (option != "x") {

			option = sc.nextLine();
			switch (option) {
			case "w": {
				field.moveUp(field.getXPositionOfZero(), field.getYPositionOfZero());
				field.showField();
				if (isEnd())
					option = "x";

				break;
			}
			case "s": {
				field.moveDown(field.getXPositionOfZero(), field.getYPositionOfZero());
				field.showField();
				if (isEnd())
					option = "x";
				break;
			}

			case "a": {
				field.moveLeft(field.getXPositionOfZero(), field.getYPositionOfZero());
				field.showField();
				if (isEnd())
					option = "x";
				break;
			}
			case "d": {
				field.moveRight(field.getXPositionOfZero(), field.getYPositionOfZero());
				field.showField();
				if (isEnd())
					option = "x";
				break;
			}

			case "x": {
				option = "x";
				break;
			}
			default:
				break;

			}
		}
	}

	private boolean isEnd() {
		if (field.isFinished()) {
			try {
				// hallOfFame.load();
				hallOfFame.addScore(name, field.getPlayingSeconds());
				// hallOfFame.save();
			} catch (Exception e) {
				System.err.println("Nepodarilo sa ulozit score");
				e.printStackTrace();
			}

			System.out.println("Vyhral si!");
			System.out.println(hallOfFame);
			return true;
		}
		return false;
	}
}
