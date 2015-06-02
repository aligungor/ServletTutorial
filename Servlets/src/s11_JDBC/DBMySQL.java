package s11_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBMySQL {
	private static String url = "jdbc:mysql://localhost:3306/Football";
	private static String username = "aligungor";
	private static String password = "1234";
	private Connection connection;

	private static DBMySQL dbManager;

	public static DBMySQL getDBMySQL() {
		if (dbManager == null) {
			dbManager = new DBMySQL();
		}
		return dbManager;
	}

	public Connection getConnection() {
		try {
			if (connection == null || connection.isClosed())
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection(url, username,
						password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
