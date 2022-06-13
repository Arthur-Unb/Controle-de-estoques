package dao;

import java.util.List;

import entities.ModelTransacao;

public interface DaoTransacao {

	void insert(ModelTransacao obj);

	void update(ModelTransacao obj);

	ModelTransacao findById(Integer id);

	List<ModelTransacao> findAll();

}
