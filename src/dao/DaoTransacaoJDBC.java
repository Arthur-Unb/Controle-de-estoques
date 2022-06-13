package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;
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

}
