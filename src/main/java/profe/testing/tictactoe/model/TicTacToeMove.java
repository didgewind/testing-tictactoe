package profe.testing.tictactoe.model;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((player == null) ? 0 : player.hashCode());
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TicTacToeMove other = (TicTacToeMove) obj;
		if (player != other.player)
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	public void setMoveNumber(int moveNumber) {
		this.moveNumber = moveNumber;
	}
	
	

}
