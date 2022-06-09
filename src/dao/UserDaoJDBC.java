package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DB;
import db.DbException;
import entities.User;

public class UserDaoJDBC implements UserDao {

	private Connection conn;

	public UserDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public User findById(User obj) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM banco_estoque.user WHERE Login = ? and senha = ?");
			st.setString(1, obj.getLogin());
			st.setString(2, obj.getPassword());
			rs = st.executeQuery();
			if (rs.next()) {

				User usuario = new User();
				usuario.setLogin(rs.getString("Login"));
				usuario.setLogin(rs.getString("senha"));

				return usuario;

			}

			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());

		} finally {
			DB.closeStatement(st);
			DB.closeConnection(rs);

		}

	}

}
