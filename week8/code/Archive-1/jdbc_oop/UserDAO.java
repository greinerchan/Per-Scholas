package jdbc_oop;

import java.sql.SQLException;
import java.util.List;

public class UserDAO extends AbstractDAO implements jdbc_oop.UserDAOI {
	
	@Override
	public List<User> getAllUsers() {
		List<User> users = null;
		connect();
		try {
			stmt = conn.prepareStatement(SQL.GET_ALL_USERS.getQuery());
			rs = stmt.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPassword(rs.getString(4));
				users.add(user);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		dispose();
		return users;
	}

	@Override
	public User getUserById(int id) {
		User user = null;
		connect();
		try {
			stmt = conn.prepareStatement(SQL.GET_USERS_BY_ID.getQuery());
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setUserId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPassword(rs.getString(4));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		dispose();
		return user;
	}

	@Override
	public User getUsersByName(String Name) {
		User user = null;
		connect();
		try {
			stmt = conn.prepareStatement(SQL.GET_USERS_BY_NAME.getQuery());
			stmt.setString(1, Name);
			rs = stmt.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setUserId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPassword(rs.getString(4));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		dispose();
		return user;
	}

	@Override
	public Boolean validateUser(String email, String passworld) {
		connect();
		try {
			stmt = conn.prepareStatement(SQL.VALIDATE_USER.getQuery());
			stmt.setString(1, email);
			stmt.setString(2, passworld);
			rs = stmt.executeQuery();
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		dispose();
		return false;
	}

	@Override
	public Boolean updateUser(String email, String name, String password) {
		connect();
		try {
			stmt = conn.prepareStatement(SQL.VALIDATE_USER.getQuery());
			stmt.setString(1, name);
			stmt.setString(2, password);
			stmt.setString(3, email);
			int rs = stmt.executeUpdate();
			if (rs > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		dispose();
		return false;
	}

}
