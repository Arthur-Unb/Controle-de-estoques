package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import entities.ModelProdutos;
import entities.ModelTransacao;

public class DaoProdutosJDBC implements DaoProdutos {

	private Connection conn;

	public DaoProdutosJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(ModelProdutos obj) {

		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("INSERT INTO banco_estoque.tbl_produto " + "(pro_nome, " + "pro_valor,"
					+ "pro_estoque)" + "VALUES" + "(?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

			st.setString(1, obj.getProNome());
			st.setDouble(2, obj.getProValor());
			st.setInt(3, obj.getProEstoque());

			st.executeUpdate();

		} catch (SQLException e) {

			throw new DbException(e.getMessage());

		} finally {

			DB.closeStatement(st);

		}

	}

	@Override
	public void update(ModelProdutos obj) {
		PreparedStatement st = null;

		try {

			st = conn.prepareStatement("UPDATE banco_estoque.tbl_produto "
					+ "SET pro_nome = ?, pro_valor = ?, pro_estoque = ?" + "WHERE pk_id_produto = ?");

			st.setString(1, obj.getProNome());
			st.setDouble(2, obj.getProValor());
			st.setInt(3, obj.getProEstoque());
			st.setInt(4, obj.getIdProduto());

			st.executeUpdate();
		} catch (SQLException e) {

			throw new DbException(e.getMessage());

		} finally {

			DB.closeStatement(st);
		}

	}

	@Override
	public void deleteById(Integer id) {

		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM banco_estoque.tbl_produto WHERE pk_id_produto = ?");

			st.setInt(1, id);

			st.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public ModelProdutos findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM banco_estoque.tbl_produto WHERE pk_id_produto = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {

				ModelProdutos obj = new ModelProdutos();

				obj.setIdProduto(rs.getInt("pk_id_produto"));
				obj.setProNome(rs.getString("pro_nome"));
				obj.setProValor(rs.getDouble("pro_valor"));
				obj.setProEstoque(rs.getInt("pro_estoque"));

				return obj;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<ModelProdutos> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM banco_estoque.tbl_produto ORDER BY pro_nome");
			rs = st.executeQuery();

			List<ModelProdutos> list = new ArrayList<>();

			while (rs.next()) {
				ModelProdutos obj = new ModelProdutos();
				obj.setIdProduto(rs.getInt("pk_id_produto"));
				obj.setProNome(rs.getString("pro_nome"));
				obj.setProValor(rs.getDouble("pro_valor"));
				obj.setProEstoque(rs.getInt("pro_estoque"));

				list.add(obj);
			}
			return list;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public void alterarEstoque(Integer x) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("update banco_estoque.tbl_produto" + "set pro_estoque = pro_estoque + ?"
					+ "where pk_id_produto = 1;");

			st.setInt(1, x);

			st.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public void updateEstoque(ModelTransacao obj) {
		PreparedStatement st = null;

		try {

			st = conn.prepareStatement(
					"UPDATE banco_estoque.tbl_produto " + "SET pro_estoque = ?" + "WHERE pk_id_produto = ?");

			st.setInt(1, obj.getQuantidadeProduto());
			st.setInt(2, obj.getIdProduto());

			st.executeUpdate();
		} catch (SQLException e) {

			throw new DbException(e.getMessage());

		} finally {

			DB.closeStatement(st);
		}
		
	}

}
