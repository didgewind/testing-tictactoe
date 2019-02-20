package profe.testing.tictactoe;

import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import profe.testing.tictactoe.TicTacToe;

public class TicTacToeSpec {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	private TicTacToe ticTacToe;

	@Before
	public final void before() {
		ticTacToe = new TicTacToe();
	}

	@Test
	public void whenXOutsideBoardThenRuntimeException() {
		exception.expect(RuntimeException.class);
		ticTacToe.play(5, 2);
	}

	@Test
	public void whenYOutsideBoardThenRuntimeException() {
		exception.expect(RuntimeException.class);
		ticTacToe.play(2, 5);
	}

	@Test
	public void whenOccupiedSpaceThenRuntimeException() {
		exception.expect(RuntimeException.class);
		ticTacToe.play(1,1);
		ticTacToe.play(1,1);
	}

	@Test
	public void givenBeginThenNextPlayerIsX() {
		assertEquals(Valor.X, ticTacToe.nextPlayer());
	}

	@Test
	public void whenXPlaysThenNextPlayerIsO() {
		ticTacToe.play(1,1);
		assertEquals(Valor.O, ticTacToe.nextPlayer());
	}

}
