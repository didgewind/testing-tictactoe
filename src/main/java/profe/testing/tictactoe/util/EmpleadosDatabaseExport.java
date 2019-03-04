package profe.testing.tictactoe.util;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.database.search.TablesDependencyHelper;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;

public class EmpleadosDatabaseExport {

	private static IDatabaseConnection connection;

	public static void main(String[] args) throws Exception {
		// database connection
		Class driverClass = Class.forName("com.mysql.jdbc.Driver");
		Connection jdbcConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/empleados_simple", "maza",
				"maza");
		connection = new DatabaseConnection(jdbcConnection);

//		doPartialExport(connection);
		doFullExport(connection);
//		doDependentTablesExport(connection);
	}

	// partial database export
	private static void doPartialExport(IDatabaseConnection connection) throws Exception {
		QueryDataSet partialDataSet = new QueryDataSet(connection);
		partialDataSet.addTable("FOO", "SELECT * FROM TABLE WHERE COL='VALUE'");
		partialDataSet.addTable("BAR");
		FlatXmlDataSet.write(partialDataSet, new FileOutputStream("partial.xml"));
	}

	// full database export
	private static void doFullExport(IDatabaseConnection connection) throws Exception {
		IDataSet fullDataSet = connection.createDataSet();
		FlatXmlDataSet.write(fullDataSet, new FileOutputStream("empleadosFull.xml"));
	}

	// dependent tables database export: export table X and all tables that
	// have a PK which is a FK on X, in the right order for insertion
	private static void doDependentTablesExport(IDatabaseConnection connection) throws Exception {
		String[] depTableNames = TablesDependencyHelper.getAllDependentTables(connection, "X");
		IDataSet depDataSet = connection.createDataSet(depTableNames);
		FlatXmlDataSet.write(depDataSet, new FileOutputStream("dependents.xml"));
	}

}
