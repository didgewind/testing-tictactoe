package profe.testing.tictactoe.daos;

import profe.testing.tictactoe.model.TicTacToeMove;

public interface TicTacToeDAO {

	boolean isEmpty();
	
	TicTacToeMove saveMove(TicTacToeMove move);
	
	TicTacToeMove getMove(int moveNumber);
	
}
