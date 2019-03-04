package profe.testing.tictactoe.negocio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import profe.testing.tictactoe.daos.TicTacToeDAO;
import profe.testing.tictactoe.model.TicTacToeMove;
import profe.testing.tictactoe.model.Valor;
import profe.testing.tictactoe.negocio.TicTacToe;

@ExtendWith(MockitoExtension.class)
class TicTacToeTest {

	@InjectMocks
	private TicTacToe ticTacToe;
	
	@Mock
	private TicTacToeDAO dao;

	@BeforeEach
	public final void before() {
/*		ticTacToe = new TicTacToe();
		dao = new TicTacToeDAOMem();
		ticTacToe.setDao(dao);*/
	}

	@Test
	public void whenXOutsideBoardThenRuntimeException() {
		assertThrows(RuntimeException.class, () -> ticTacToe.play(5, 2));
	}
	
	@Test
	public void whenYOutsideBoardThenRuntimeException() {
		assertThrows(RuntimeException.class, () -> ticTacToe.play(2, 5));
	}

	@Test
	public void whenOccupiedSpaceThenRuntimeException() {
		ticTacToe.play(1, 1);
		assertThrows(RuntimeException.class, () -> ticTacToe.play(1, 1));
	}

	@Test
	public void givenBeginThenNextPlayerIsX() {
		assertEquals(Valor.X, ticTacToe.nextPlayer());
	}

	@Test
	public void whenXPlaysThenNextPlayerIsO() {
		ticTacToe.play(1, 1);
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

	@Test
	public void whenAllBoxesAreFilledThenDraw() {
		ticTacToe.play(1, 1);
		ticTacToe.play(1, 2);
		ticTacToe.play(1, 3);
		ticTacToe.play(2, 1);
		ticTacToe.play(2, 3);
		ticTacToe.play(2, 2);
		ticTacToe.play(3, 1);
		ticTacToe.play(3, 3);
		Valor actual = ticTacToe.play(3, 2);
		assertEquals(Valor.EMPATE, actual);
	}
	
	@Test
	public void whenPlaySaveMoveIsInvoked() {
		ticTacToe.play(1, 1);
		verify(dao, times(1)).saveMove(any(TicTacToeMove.class));
	}
	
}
