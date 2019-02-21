package profe.testing.tictactoe;

public class TicTacToe {
	
	private Valor[][] tablero = new Valor[3][3];
	private Valor lastPlayer = Valor.O;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public TicTacToe() {
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				tablero[i][j] = Valor.EMPTY;
			}
		}
	}
	
	public Valor play(int x, int y) {
		String errorMessage = "";
		boolean bError = false;
		if (xIsOutOfBounds(x)) {
			errorMessage = "X debe estar entre 1 y 3. ";
			bError = true;
		}
		if (yIsOutOfBounds(y)) {
			errorMessage += "Y debe estar entre 1 y 3.";
			bError = true;
		}
		if (bError) {
			throw new RuntimeException(errorMessage);
		}
		checkPlaceNotEmpty(x, y);
		tablero[x-1][y-1] = nextPlayer();
		if (theresWinner(x, y)) {
			return nextPlayer();
		}
		lastPlayer = nextPlayer();
		return Valor.EMPTY;
	}

	private boolean theresWinner(int x, int y) {
		// checking vertical row from x
		int numMatches = 0;
		for (int i=0; i<3; i++) {
			if (tablero[x-1][i] == nextPlayer()) {
				numMatches++;
			}
		}
		if (numMatches == 3) {
			return true;
		}
		// checking horizontal row from y
		numMatches = 0;
		for (int i=0; i<3; i++) {
			if (tablero[i][y-1] == nextPlayer()) {
				numMatches++;
			}
		}
		if (numMatches == 3) {
			return true;
		}
		// checking diagonals
		numMatches = 0;
		for (int i=0; i<3; i++) {
			if (tablero[i][i] == nextPlayer()) {
				numMatches++;
			}
		}
		if (numMatches == 3) {
			return true;
		}
		numMatches = 0;
		for (int i=0, j=2; i<3; i++, j--) {
			if (tablero[i][j] == nextPlayer()) {
				numMatches++;
			}
		}
		if (numMatches == 3) {
			return true;
		}
		return false;
	}
	
	private boolean xIsOutOfBounds(int x) {
		return x < 1 || x > 3;
	}

	private boolean yIsOutOfBounds(int y) {
		return y < 1 || y > 3;
	}
	
	private void checkPlaceNotEmpty(int x, int y) {
		if (tablero[x-1][y-1] != Valor.EMPTY) {
			throw new RuntimeException(String.format("Lo siento, la posición %s,%s ya está ocupada", x, y));
		}
	}
	
	public Valor nextPlayer() {
		if (lastPlayer == Valor.X) {
			return Valor.O;
		} else {
			return Valor.X;
		}
	}
}
