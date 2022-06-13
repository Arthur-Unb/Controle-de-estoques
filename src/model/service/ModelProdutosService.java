package model.service;

import java.util.ArrayList;
import java.util.List;

import entities.ModelProdutos;

public class ModelProdutosService {

	public List<ModelProdutos> findAll() {

		List<ModelProdutos> list = new ArrayList<>();

		list.add(new ModelProdutos(3, "MARTELO", 50.0, 100));
		list.add(new ModelProdutos(4, "CHAVE", 40.0, 100));
		list.add(new ModelProdutos(5, "ALICATE", 70.0, 100));
		list.add(new ModelProdutos(6, "ARAME", 80.0, 100));

		return list;

	}

}
