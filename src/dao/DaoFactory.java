package dao;

import db.DB;

public class DaoFactory {

	public static DaoProdutos createDaoProdutos() {
		return new DaoProdutosJDBC(DB.getConnection());
	}

}
