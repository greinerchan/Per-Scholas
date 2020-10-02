package intro_to_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Slide10JdbcConnect {
	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3307/"
					+ "jdbctest?user=root&password=root");
			System.out.println("Connection made!!!");
			String sql = "INSERT INTO users (name, email, password) values ('John', 'john@doe.com', 'john1234')";
			stmt = conn.createStatement();
			stmt.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally
		{
			if (!stmt.equals(null)) {
				stmt.close();
			}
			if (!conn.equals(null)) {
				conn.close();
			}
		}
	}
}