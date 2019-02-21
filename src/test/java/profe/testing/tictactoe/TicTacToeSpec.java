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
	
	@Test
	public void whenPlayThenNoWinner() {
		assertEquals(Valor.EMPTY, ticTacToe.play(1, 1));
	}

	@Test
	public void whenRowFullThenWinner() {
		ticTacToe.play(1, 1);
		ticTacToe.play(1, 3);
		ticTacToe.play(1, 2);
		ticTacToe.play(2, 3);
		ticTacToe.play(2, 2);
		assertEquals(Valor.O, ticTacToe.play(3, 3));
	}

	@Test
	public void whenColumnFullThenWinner() {
		ticTacToe.play(1, 1);
		ticTacToe.play(2, 1);
		ticTacToe.play(1, 2);
		ticTacToe.play(3, 2);
		assertEquals(Valor.X, ticTacToe.play(1, 3));
	}

	@Test
	public void whenDiagonalBottomTopFullThenWinner() {
		ticTacToe.play(1, 1);
		ticTacToe.play(2, 1);
		ticTacToe.play(2, 2);
		ticTacToe.play(3, 2);
		assertEquals(Valor.X, ticTacToe.play(3, 3));
	}

	@Test
	public void whenDiagonalTopBottomFullThenWinner() {
		ticTacToe.play(1, 1);
		ticTacToe.play(1, 3);
		ticTacToe.play(1, 2);
		ticTacToe.play(2, 2);
		ticTacToe.play(3, 3);
		assertEquals(Valor.O, ticTacToe.play(3, 1));
	}

}
