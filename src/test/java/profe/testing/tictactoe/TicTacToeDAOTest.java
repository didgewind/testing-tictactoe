package profe.testing.tictactoe;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

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
