package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import db.DB;
import db.DbException;
import entities.Products;

public class ProductsDaoJDBC implements ProductsDao {

	private Connection conn;

	public ProductsDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Products obj) {
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("INSERT INTO banco_estoque.produtos "
					+ "(productId, productName, quantity, price)" + "VALUES" + "(?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);

			st.setInt(1, obj.getProductId());
			st.setString(2, obj.getProductName());
			st.setInt(3, obj.getQuantity());
			st.setDouble(4, obj.getPrice());

			st.executeUpdate();

		} catch (SQLException e) {

			throw new DbException(e.getMessage());

		} finally {

			DB.closeStatement(st);

		}

	}

	@Override
	public void update(Products obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Products findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Products> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
