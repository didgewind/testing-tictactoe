package profe.testing.tictactoe.daos;

import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import profe.testing.tictactoe.model.TicTacToeMove;
import profe.testing.tictactoe.model.Valor;

@TestInstance(Lifecycle.PER_CLASS)
public class TicTatToeDAOBdTest extends TicTacToeDAOCommonTests {

	private IDatabaseTester databaseTester;

	@BeforeAll
	public void beforeAll() throws Exception {
		// Acceder a la base de datos
		databaseTester = new JdbcDatabaseTester("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/tictactoe",
				"maza", "maza");
		databaseTester.setSetUpOperation(DatabaseOperation.DELETE_ALL);
		/* 
		 * Inicializar el dataset en la BD. Creo que es obligatorio para que podamos comparar la estructura más adelante,
		 * aunque en realidad no estemos haciendo nada con los datos de tictactoe.xml, puesto que el
		 * DatabaseOperation elegido es DELETE_ALL
		 */
		FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
		IDataSet dataSet = builder.build(this.getClass().getResourceAsStream("/tictactoe.xml"));
		databaseTester.setDataSet(dataSet);

	}

	@BeforeEach
	public final void before() throws Exception {
		dao = new TicTacToeDAOBd();
		// Llamar a la operación por defecto setUpOperation
		databaseTester.onSetup();
	}

	@AfterEach
	public void tearDown() throws Exception {
		databaseTester.onTearDown();
		((TicTacToeDAOBd) dao).dispose();
	}

	@Test
	public void whenSomePlaysDatabaseUpdated() throws Exception {
		// Almacenamos algunos movimientos en la bd
		dao.saveMove(new TicTacToeMove(0, 1, 1, Valor.X));
		dao.saveMove(new TicTacToeMove(0, 1, 2, Valor.O));
		dao.saveMove(new TicTacToeMove(0, 1, 3, Valor.X));
		
		/*
		 * Leemos los movimientos de la bd (como el databaseTester
		 * está inicializado con tictactoe.xml, sabe cuál es la estructura de la tabla
		 * de la que tiene que leer los datos)
		 */
		IDataSet databaseDataSet = databaseTester.getConnection().createDataSet();
		ITable actualTable = databaseDataSet.getTable("movimientos");
		
		// Leemos los movimientos expected del fichero xml
		FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
		IDataSet expectedDataSet = builder.build(this.getClass().getResourceAsStream("/tictactoe-someplays.xml"));
		ITable expectedTable = expectedDataSet.getTable("movimientos");

		// Assert actual database table match expected table
		org.dbunit.Assertion.assertEquals(expectedTable, actualTable);
	}
}
