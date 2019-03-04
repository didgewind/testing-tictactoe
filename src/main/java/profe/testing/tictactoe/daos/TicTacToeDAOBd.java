package profe.testing.tictactoe.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import profe.testing.tictactoe.model.TicTacToeMove;

public class TicTacToeDAOBd implements TicTacToeDAO {

	private Connection connection;
	private int numberOfMoves;
	
	private interface ConstantesSQL {
		
		String INSERTA_MOVIMIENTO = "INSERT INTO movimientos (numMovimiento, x, y, player) VALUES(?, ?, ?, ?)";
		
	}
	
	public TicTacToeDAOBd() throws Exception {
		Class driverClass = Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tictactoe", "maza",
				"maza");
	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TicTacToeMove saveMove(TicTacToeMove move) {
		move.setMoveNumber(++numberOfMoves);
		try {
			PreparedStatement pst = connection.prepareStatement(ConstantesSQL.INSERTA_MOVIMIENTO);
			pst.setInt(1, move.getMoveNumber());
			pst.setInt(2, move.getX());
			pst.setInt(3, move.getY());
			pst.setString(4, move.getPlayer().toString());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return move;
	}

	@Override
	public TicTacToeMove getMove(int moveNumber) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void dispose() {
		if (connection != null) {
			try {
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}

}
