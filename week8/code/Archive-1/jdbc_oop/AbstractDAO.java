package jdbc_oop;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AbstractDAO {
	protected Connection conn = null;
	protected PreparedStatement stmt = null;
	protected ResultSet rs = null;
	
	public void connect() {
		DatabaseConnection databaseConn = new DatabaseConnection();
		try {
			conn = databaseConn.getConnection();
			System.out.println("Database connection made!!!");
		} catch (ClassNotFoundException | IOException | SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void dispose() {
		try
		{
			if (!rs.equals(null)) {
				rs.close();
			}
			if (!stmt.equals(null)) {
				stmt.close();
			}
			if (!conn.equals(null)) {
				conn.close();
			}
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
