package view;

import dao.DaoProdutosJDBC;
import db.DB;
import entities.ModelProdutos;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CadastroViewController {

	@FXML
	private TextField txtId;

	@FXML
	private TextField txtNome;

	@FXML
	private TextField txtQuantidade;

	@FXML
	private TextField txtNomeBusca;

	@FXML
	private TextField txtQuantidadeBusca;

	@FXML
	private TextField txtValor;

	@FXML
	private TextField txtValorBusca;

	@FXML
	private Button cadastrarButton;

	@FXML
	private Button buscarButton;

	@FXML
	private Button excluirButton;

	@FXML
	public void onBtCadastrar() {

		DaoProdutosJDBC cadastrar = new DaoProdutosJDBC(DB.getConnection());

		ModelProdutos produto = new ModelProdutos();

		produto.setProNome(txtNome.getText());
		produto.setProValor(Double.valueOf(txtValor.getText()));
		produto.setProEstoque(Integer.valueOf(txtQuantidade.getText()));

		cadastrar.insert(produto);

	}

	@FXML
	public void onBtBuscar() {
		DaoProdutosJDBC buscar = new DaoProdutosJDBC(DB.getConnection());

		Integer id = Integer.valueOf(txtId.getText());

		txtNomeBusca.setText(buscar.findById(id).getProNome());

		txtQuantidadeBusca.setText(buscar.findById(id).getProEstoque().toString());

		txtValorBusca.setText(buscar.findById(id).getProValor().toString());

	}

	@FXML
	public void onBtExcluir() {

		DaoProdutosJDBC excluir = new DaoProdutosJDBC(DB.getConnection());

		Integer id = Integer.valueOf(txtId.getText());

		excluir.deleteById(id);

	}

}
