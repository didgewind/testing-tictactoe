package profe.testing.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class TicTacToeDAOMem implements TicTacToeDAO {

	private List<TicTacToeMove> listOfMoves = new ArrayList<TicTacToeMove>();
	private int numberOfMoves;
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TicTacToeMove saveMove(TicTacToeMove move) {
		move.setMoveNumber(++numberOfMoves);
		listOfMoves.add(move);
		return move;
	}

	@Override
	public TicTacToeMove getMove(int moveNumber) {
		return listOfMoves.get(moveNumber - 1);
	}

}
