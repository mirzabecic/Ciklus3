package Model;

import java.sql.*;
/**
 * Class which connects to our database.
 * Also this class execute all the queries we want.
 * Any direct connection to database or any actions on database
 * are from this class.
 * @author mirza
 *
 */
public class Application {
	protected static Connection db;
	/**
	 * Static method for initial connecting to db.
	 * @throws SQLException
	 */
	public static void init(String databaseName) throws SQLException {
		db = DriverManager.getConnection("jdbc:sqlite:" + databaseName + ".db");
	}
	/**
	 * Method which is searching in our db.
	 * It has 2 parameters. ID of item we want
	 * and table name which we're searching.
	 * @param id	- ID of element we're searching
	 * @param tableName -table name we're searching in.
	 * @return	ResultSet as result of our search.
	 */
	protected static ResultSet find(int id, String tableName) {
		try {
			Statement stmt = db.createStatement();
			String sql = String.format("SELECT * FROM %s WHERE id = '%d' ;",
					tableName, id);
			return stmt.executeQuery(sql);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return null;
		}

	}
	/**
	 * Method for saving into our database.
	 * It actually execute INSERT query.
	 * @param tableName - name of table we're inserting in.
	 * @param values 	- values we're inserting
	 * @return			- true if saving went good or false if it failed.
	 */
	protected static boolean save(String tableName, String values) {
		Statement stmt = null;
		try {
			stmt = db.createStatement();
			String sql = String.format("INSERT INTO %s  VALUES %s;", tableName,
					values);
			stmt.execute("begin;");
			stmt.execute(sql);
			stmt.execute("commit;");
			return true;
		} catch (SQLException e) {
			if (stmt != null) {
				try {
					stmt.execute("rollback;");
				} catch (SQLException e1) {
					System.err.println(e1.getMessage());
					return false;
				}
			}
			System.err.println(e.getMessage());
			return false;

		}
	}
	/**
	 * Method which returns all items(columns) user send as parameter.
	 * Similar to find method.
	 * @param tableName	-name of table we're searching.
	 * @param columns	-columns we want to get ( *  should be acceptable)
	 * @return  
	 */
	protected static ResultSet all(String tableName, String columnNames) {
		try {
			Statement stmt = db.createStatement();
			String sql = String.format("SELECT %s  FROM %s;", columnNames,
					tableName);
			return stmt.executeQuery(sql);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return null;
		}

	}
	 
}