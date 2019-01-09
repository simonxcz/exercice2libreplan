package BDD;
import java.io.File;
import java.sql.*;

import org.dbunit.Assertion;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;

public class JDBC {

	private static final String DRIVER= "org.postgresql.Driver";
	private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/libreplan";
	private static final String USER = "libreplan";
	private static final String PASSWORD = "libreplan";
	
	public IDataSet readDataSet(String filename)throws Exception{
		return new FlatXmlDataSetBuilder().build(new File(filename));
	}
	
	public void deleteCritere() throws Exception {
		Connection con = DriverManager.getConnection(JDBC_URL,USER,PASSWORD);
		Class.forName(DRIVER);
		Statement stmt = con.createStatement();	
		try {
			stmt.executeQuery("DELETE FROM criterion_type WHERE name ='Critère - Test bouton';");
		} catch (Exception e) {
			
		}
		
	}
	
	public void inserData(String path_to_file) throws Exception {
		IDataSet dataset = readDataSet(path_to_file);
		IDatabaseTester databaseTester =  new JdbcDatabaseTester(DRIVER,JDBC_URL,USER,PASSWORD);
		databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
		databaseTester.setDataSet(dataset);
		databaseTester.onSetup();	
	}
	
	public void deleteData(String path_to_file) throws Exception {
		IDataSet dataset = readDataSet(path_to_file);
		IDatabaseTester databaseTester =  new JdbcDatabaseTester(DRIVER,JDBC_URL,USER,PASSWORD);
		databaseTester.setSetUpOperation(DatabaseOperation.DELETE_ALL);
		databaseTester.setDataSet(dataset);
		databaseTester.onSetup();
	}
	
	public void compareData(String table, String path_to_file, String col) throws SQLException, Exception {
		IDatabaseTester databaseTester = new JdbcDatabaseTester(DRIVER, JDBC_URL, USER, PASSWORD);
		IDataSet databaseDataSet = databaseTester.getConnection().createDataSet();
		ITable actualTable =databaseDataSet.getTable(table);
		//IDataSet expectedDataSet=readDataSet(path_to_file);
		IDataSet expectedDataSet = readDataSet(path_to_file);
		ITable expectedTable =expectedDataSet.getTable(table);
		String tab[]= {col};
		Assertion.assertEqualsIgnoreCols(expectedTable, actualTable, tab);
		}
}