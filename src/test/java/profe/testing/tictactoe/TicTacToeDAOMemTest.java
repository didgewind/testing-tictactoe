package profe.testing.tictactoe;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicTacToeDAOMemTest {

	private TicTacToeDAO dao;
	
	@BeforeEach
	public final void before() {
		dao = new TicTacToeDAOMem();
	}
	
	@Test
	public void whenSaveMoveReturnMove() {
		TicTacToeMove moveExpected = new TicTacToeMove(1, 1, 1, Valor.X);
		TicTacToeMove move = new TicTacToeMove(0, 1, 1, Valor.X);
		assertEquals(moveExpected, dao.saveMove(move));
	}
	
	@Test
	public void whenSomePlaysNumberOfMovementsRight() {
		dao.saveMove(new TicTacToeMove(0, 1, 1, Valor.X));
		dao.saveMove(new TicTacToeMove(0, 1, 1, Valor.O));
		dao.saveMove(new TicTacToeMove(0, 1, 1, Valor.X));
		TicTacToeMove move = dao.saveMove(new TicTacToeMove(0, 1, 1, Valor.O));
		assertEquals(4, move.getMoveNumber());
	}
	
	@Test
	public void givenMoveNumberReturnsMove() {
		dao.saveMove(new TicTacToeMove(0, 1, 1, Valor.X));
		TicTacToeMove moveExpected = dao.saveMove(new TicTacToeMove(0, 1, 1, Valor.O));
		dao.saveMove(new TicTacToeMove(0, 1, 1, Valor.X));
		dao.saveMove(new TicTacToeMove(0, 1, 1, Valor.O));
		assertEquals(moveExpected, dao.getMove(2));
	}
	
}
