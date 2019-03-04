package profe.testing.tictactoe.daos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import profe.testing.tictactoe.daos.TicTacToeDAO;
import profe.testing.tictactoe.model.TicTacToeMove;
import profe.testing.tictactoe.model.Valor;

@ExtendWith(MockitoExtension.class)
public class TicTacToeDAOTest {

	private TicTacToeDAO dao;
	
	@BeforeEach
	public final void init() {
		dao = mock(TicTacToeDAO.class);
	}
	
	@Test
	public void whenNewGameBoardEmpty() {
		assertEquals(false, dao.isEmpty());
		doReturn(true).when(dao).isEmpty();
		assertEquals(true, dao.isEmpty());
	}
	
	@Test
	public void whenSaveMoveReturnMoveWithMoveNumber() {
		TicTacToeMove moveExpected = new TicTacToeMove(1, 1, 1, Valor.X);
		TicTacToeMove move = new TicTacToeMove(0, 1, 1, Valor.X);
		doReturn(moveExpected).when(dao).saveMove(any(TicTacToeMove.class));
		assertEquals(move, dao.saveMove(move));
	}
	
}
