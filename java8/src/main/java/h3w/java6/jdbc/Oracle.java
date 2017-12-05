package h3w.java6.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Oracle {
	
	/**
	 * 128.192.167.144 ap
	 * 128.192.167.145 db
	 */
	private static final String URL = "jdbc:oracle:thin:@128.192.167.145:1521:ccveapd0";
	private static final String USER = "system";
	private static final String PASSWD = "oracle";

	private Connection conn = null;

	public Oracle() {
		conn = createConnection();
	}
	
	protected Statement createStatement() {
		try {
			return conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	protected Connection createConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			return DriverManager.getConnection(URL, USER, PASSWD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
