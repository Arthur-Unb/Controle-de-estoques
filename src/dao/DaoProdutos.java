package dao;

import java.util.List;

import entities.ModelProdutos;
import entities.ModelTransacao;

public interface DaoProdutos {

	void insert(ModelProdutos obj);

	void update(ModelProdutos obj);

	void updateEstoque(ModelTransacao obj);

	void deleteById(Integer id);

	void alterarEstoque(Integer x);

	ModelProdutos findById(Integer id);

	List<ModelProdutos> findAll();

}
