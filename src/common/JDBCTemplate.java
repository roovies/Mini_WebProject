package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTemplate {
	private static Connection conn;
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "DEVS";
	private static final String PASSWORD = "DEVS";
	
	public JDBCTemplate() {}
	
	/**-------------------------------------------------------------------------------------------------
	/ Connection 객체 생성
	/-------------------------------------------------------------------------------------------------*/
	public static Connection getConnection() {
		try {
			if(conn==null || conn.isClosed()) { 							// Connection 객체가 현재 존재하지 않으면, 드라이버 등록 후 생성
				Class.forName(DRIVER);
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
				conn.setAutoCommit(false);					
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**-------------------------------------------------------------------------------------------------
	/ Commit & Rollback
	/-------------------------------------------------------------------------------------------------*/
	public static void commit(Connection conn) {
		try {
			if(conn!=null || !conn.isClosed()) {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection conn) {
		try {
			if(conn!=null || !conn.isClosed()) {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
