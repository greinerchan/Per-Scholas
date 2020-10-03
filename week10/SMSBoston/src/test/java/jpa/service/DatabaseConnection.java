package jpa.service;
import java.sql.*;

public class DatabaseConnection {
	public static final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String DBURL = "jdbc:mysql://localhost:3306/SMSBOSTON?serverTimezone=UTC";
	public static final String DBUSER = "root";
	public static final String DBPASSWORD = "19930131";
	private Connection conn = null;

	public DatabaseConnection() {
		try {
		Class.forName(DBDRIVER);
			try {
				this.conn = DriverManager.getConnection(DBURL, DBUSER,DBPASSWORD);
			} catch (SQLException e) {
			e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return this.conn;
	}

	// 数据库链接关闭
	public void close() {
		if (this.conn != null) {
		try {
			this.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	  }
	}
}
