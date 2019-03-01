package profe.testing.tictactoe;

import java.io.Serializable;

public class TicTacToeMove implements Serializable {
	
	private int moveNumber;
	private int x, y;
	private Valor player;
	
	public TicTacToeMove() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TicTacToeMove(int moveNumber, int x, int y, Valor player) {
		super();
		this.moveNumber = moveNumber;
		this.x = x;
		this.y = y;
		this.player = player;
	}

	public int getMoveNumber() {
		return moveNumber;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Valor getPlayer() {
		return player;
	}
	
	

}
