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

public class DaoTransacaoJDBC implements DaoTransacao {

	private Connection conn;

	public DaoTransacaoJDBC(Connection conn) {
		this.conn = conn;

	}

	@Override
	public void insert(ModelTransacao obj) {
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement(
					"INSERT INTO banco_estoque.tbl_entrada_saida " + "(fk_produto, " + "fk_funcionario,"
							+ "transacao_pro_quantidade," + "transacao_tipo)" + "VALUES" + "(?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);

			st.setInt(1, obj.getIdProduto());
			st.setInt(2, obj.getIdFuncionario());
			st.setInt(3, obj.getQuantidadeProduto());
			st.setString(4, obj.getTipoTransacao());

			st.executeUpdate();

		} catch (SQLException e) {

			throw new DbException(e.getMessage());

		} finally {

			DB.closeStatement(st);

		}

	}

	@Override
	public void update(ModelTransacao obj) {
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

	@Override
	public ModelTransacao findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"select * from banco_estoque.tbl_entrada_saida where pk_id_transacao_produto = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {

				ModelTransacao obj = new ModelTransacao();

				obj.setIdTransacao(rs.getInt("pk_id_transacao_produto"));
				obj.setIdProduto(rs.getInt("fk_produto"));
				obj.setIdFuncionario(rs.getInt("fk_funcionario"));
				obj.setQuantidadeProduto(rs.getInt("transacao_pro_quantidade"));
				obj.setTipoTransacao(rs.getString("transacao_tipo"));

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
	public List<ModelTransacao> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM banco_estoque.tbl_entrada_saida ORDER BY pro_nome");
			rs = st.executeQuery();

			List<ModelTransacao> list = new ArrayList<>();

			while (rs.next()) {
				ModelTransacao obj = new ModelTransacao();

				obj.setIdTransacao(rs.getInt("pk_id_transacao_produto"));
				obj.setIdProduto(rs.getInt("fk_produto"));
				obj.setIdFuncionario(rs.getInt("fk_funcionario"));
				obj.setQuantidadeProduto(rs.getInt("transacao_pro_quantidade"));
				obj.setTipoTransacao(rs.getString("transacao_tipo"));

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

}
