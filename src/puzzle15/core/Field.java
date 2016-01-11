package puzzle15.core;

import java.util.Random;

public class Field {

	private final int rowCount;
	private final int columnCount;
	private final Rock[][] rocks;
	private long startMillis;

	// private Rock = new Rock(rowCount, columnCount, value);

	public Field(int rowCount, int columnCount) {
		this.rowCount = rowCount;
		this.columnCount = columnCount;

		if (!(rowCount > 0 && columnCount > 0)) {
			throw new IllegalArgumentException("Cele zle");
		}

		rocks = new Rock[rowCount][columnCount];

		generateRocks();
		// showField();
		System.out.println("");

		startMillis = System.currentTimeMillis();
	}

	private void generateRocks() {
		Random random = new Random();
		int value = 0;
		for (int row = 0; row < rowCount; row++) {
			for (int column = 0; column < columnCount; column++) {
				// value = random.nextInt(row*column);

				value = value + 1;
				if (value == rowCount * columnCount)
					value = 0;
				// System.out.println(value);
				if (rocks[row][column] == null) {
					rocks[row][column] = new Rock(row, column, value);
				}
			}
		}

	}

	public boolean isFinished() {
		int control = 0;
		for (int row = 0; row < rowCount; row++) {
			for (int column = 0; column < columnCount; column++) {
				control++;
				if (rocks[row][column].getValue() == 0)
					control = 0;
				if (rocks[row][column].getValue() != control)
					return false;
			}
		}

		System.out.println("\nBlahozelame!!\n");
		return true;
	}

	private boolean alreadyExists(int row, int column, int value) {
		for (int r = 0; r < rowCount; r++) {
			for (int col = 0; col < columnCount; col++) {
				if (rocks[r][col].getValue() == value) {
					return false;
				}
			}
		}

		return true;
	}

	public void showField() {
		for (int row = 0; row < rowCount; row++) {
			System.out.print("");

			for (int column = 0; column < columnCount; column++) {
				System.out.print(" ");

				if (rocks[row][column].getValue() != 0)
					System.out.print(rocks[row][column].getValue());
				else {
					System.out.print(" ");
				}

				if (rocks[row][column].getValue() < 10)
					System.out.print(" ");
			}

			System.out.println();

		}
		System.out.println("\n");
	}

	/**
	 * @return the rowCount
	 */
	public int getRowCount() {
		return rowCount;
	}

	/**
	 * @return the columnCount
	 */
	public int getColumnCount() {
		return columnCount;
	}

	/**
	 * @return the rocks
	 */
	public Rock[][] getRocks() {
		return rocks;
	}

	public Rock getRock(int row, int column) {
		return rocks[row][column];
	}

	public void moveLeft(int row, int column) {
		// Rock rock = new
		// Rock(rocks[row][column-1].getPositionX(),rocks[row][column-1].getPositionY(),
		// rocks[row][column-1].getValue());

		if (column - 1 > -1) {
			int oldPosition = rocks[row][column - 1].getValue();
			rocks[row][column - 1].setValue(rocks[row][column].getValue());
			rocks[row][column].setValue(oldPosition);

		}

	}

	public void moveRight(int row, int column) {
		// Rock rock = new
		// Rock(rocks[row][column-1].getPositionX(),rocks[row][column-1].getPositionY(),
		// rocks[row][column-1].getValue());

		if (column + 1 < columnCount) {
			int oldPosition = rocks[row][column + 1].getValue();
			rocks[row][column + 1].setValue(rocks[row][column].getValue());
			rocks[row][column].setValue(oldPosition);

		}

	}

	public void moveUp(int row, int column) {
		// Rock rock = new
		// Rock(rocks[row][column-1].getPositionX(),rocks[row][column-1].getPositionY(),
		// rocks[row][column-1].getValue());

		if (row - 1 > -1) {
			int oldPosition = rocks[row - 1][column].getValue();
			rocks[row - 1][column].setValue(rocks[row][column].getValue());
			rocks[row][column].setValue(oldPosition);

		}

	}

	public void moveDown(int row, int column) {
		// Rock rock = new
		// Rock(rocks[row][column-1].getPositionX(),rocks[row][column-1].getPositionY(),
		// rocks[row][column-1].getValue());

		if (row + 1 < rowCount) {
			int oldPosition = rocks[row + 1][column].getValue();
			rocks[row + 1][column].setValue(rocks[row][column].getValue());
			rocks[row][column].setValue(oldPosition);

		}

	}

	public int getXPositionOfZero() {
		int Xposition = 0;
		for (int row = 0; row < rowCount; row++) {
			for (int column = 0; column < columnCount; column++) {
				if (rocks[row][column].getValue() == 0)
					Xposition = rocks[row][column].getPositionX();
			}
		}

		return Xposition;
	}

	public int getYPositionOfZero() {
		int Yposition = 0;
		for (int row = 0; row < rowCount; row++) {
			for (int column = 0; column < columnCount; column++) {
				if (rocks[row][column].getValue() == 0)
					Yposition = rocks[row][column].getPositionY();
			}
		}

		return Yposition;
	}

	public int getPlayingSeconds() {
		return (int) ((System.currentTimeMillis() - startMillis) / 1000);
	}

}
