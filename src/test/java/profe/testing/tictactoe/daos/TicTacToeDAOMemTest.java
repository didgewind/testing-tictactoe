package profe.testing.tictactoe.daos;

import org.junit.jupiter.api.BeforeEach;

public class TicTacToeDAOMemTest extends TicTacToeDAOCommonTests {

	@BeforeEach
	public final void before() {
		dao = new TicTacToeDAOMem();
	}
	
}
