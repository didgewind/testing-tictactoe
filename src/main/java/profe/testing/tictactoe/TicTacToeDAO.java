package profe.testing.tictactoe;

public interface TicTacToeDAO {

	boolean isEmpty();
	
	TicTacToeMove saveMove(TicTacToeMove move);
	
}