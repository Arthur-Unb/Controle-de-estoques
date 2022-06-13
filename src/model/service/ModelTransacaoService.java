package model.service;

import java.util.ArrayList;
import java.util.List;

import entities.ModelTransacao;

public class ModelTransacaoService {

	public List<ModelTransacao> findAll() {

		List<ModelTransacao> list = new ArrayList<>();

		list.add(new ModelTransacao(1, 2, 3, 4, "Entrada"));
		list.add(new ModelTransacao(5, 6, 7, 8, "Saída"));

		return list;

	}

}
