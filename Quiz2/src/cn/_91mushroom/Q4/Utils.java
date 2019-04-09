package cn._91msuhroom.Q4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 数据库操作工具类
 * @author H.H
 *
 */
public class Utils {
	
	private static Connection connection;
	private static Statement statement;
	
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://127.0.0.1:3306/BbcDB";
	private static String user = "root";
	private static String password = "123456";
	
	private Utils() {
	}
	
	static {
		try {
			
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
			
			statement = connection.createStatement();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	
	/**
	 * 获取Statement对象
	 * @return
	 */
	public static Statement getStatement() {
		return statement;
	}
	
	/**
	 * 获取Connection对象
	 * @return
	 */
	public static Connection getConnection() {
		return connection;
	}
	
	/**
	 * 关闭connection
	 * @param connection
	 */
	public static  void close() {
		
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
