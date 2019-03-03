package profe.testing.tictactoe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TicTacToeIntgTest {

	@InjectMocks
	private TicTacToe ticTacToe;
	
	@Spy
	private TicTacToeDAO dao = new TicTacToeDAOMem();
	
	@Test
	public void whenPlaySaveMoveIsInvoked() {
		ticTacToe.play(1, 1);
		verify(dao, times(1)).saveMove(any(TicTacToeMove.class));
	}
	
	@Test
	public void whenNewGameBoardEmpty() {
		assertEquals(false, dao.isEmpty());
		doReturn(true).when(dao).isEmpty();
		assertEquals(true, dao.isEmpty());
	}
	
}
