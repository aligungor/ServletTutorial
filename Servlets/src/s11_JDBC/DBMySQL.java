package s11_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

// https://tomcat.apache.org/tomcat-7.0-doc/jdbc-pool.html

public class DBMySQL {
	private static String url = "jdbc:mysql://localhost:3306/Football";
	private static String username = "aligungor";
	private static String password = "1234";
	private static String driver = "com.mysql.jdbc.Driver";

	private Connection connection;
	private Connection connectionFromPool;
	public DataSource dataSource;
	
	private static DBMySQL dbManager;

	public static DBMySQL getDBMySQL() {
		if (dbManager == null) {
			dbManager = new DBMySQL();
		}
		return dbManager;
	}
	
	public DBMySQL() {
		configureConnectionPool();
	}
	
	public Connection getConnectionFromPool() {
		try {
			connectionFromPool = dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connectionFromPool;
	}
	
	public void closeConnectionFromPool() {
		try {
			connectionFromPool.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		try {
			if (connection == null || connection.isClosed())
				Class.forName(driver);
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

	private void configureConnectionPool() {
		PoolProperties p = new PoolProperties();
        p.setUrl(url);
        p.setDriverClassName(driver);
        p.setUsername(username);
        p.setPassword(password);
        p.setJmxEnabled(true);
        p.setTestWhileIdle(false);
        p.setTestOnBorrow(true);
        p.setValidationQuery("SELECT 1");
        p.setTestOnReturn(false);
        p.setValidationInterval(30000);
        p.setTimeBetweenEvictionRunsMillis(30000);
        p.setMaxActive(100);
        p.setInitialSize(10);
        p.setMaxWait(10000);
        p.setRemoveAbandonedTimeout(60);
        p.setMinEvictableIdleTimeMillis(30000);
        p.setMinIdle(10);
        p.setLogAbandoned(true);
        p.setRemoveAbandoned(true);
        p.setJdbcInterceptors(
          "org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"+
          "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
        dataSource = new DataSource();
        dataSource.setPoolProperties(p);
	}
}
