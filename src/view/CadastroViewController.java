package view;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import dao.DaoProdutosJDBC;
import db.DB;
import entities.ModelProdutos;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import util.Constraints;

public class CadastroViewController implements Initializable {

	@FXML
	private Text txtShowMessage;

	@FXML
	private Text txtShowMessage2;

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

	Timer timer = new Timer();

	public void LimparTexto(Text t) {
		int delay = 2000;
		int interval = 15000;

		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				t.setText("");
			}
		}, delay, interval);
	}

	@FXML
	public void onBtCadastrar() {

		DaoProdutosJDBC cadastrar = new DaoProdutosJDBC(DB.getConnection());

		ModelProdutos produto = new ModelProdutos();

		produto.setProNome(txtNome.getText());
		produto.setProValor(Double.valueOf(txtValor.getText()));
		produto.setProEstoque(Integer.valueOf(txtQuantidade.getText()));

		cadastrar.insert(produto);

		txtShowMessage.setText("Produto cadastrado com sucesso!");

		LimparTexto(txtShowMessage);

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

		txtShowMessage2.setText("Produto excluído com sucesso!");

		LimparTexto(txtShowMessage2);

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		initializeNodes();

	}

	private void initializeNodes() {

		Constraints.setTextFieldDouble(txtValor);
		Constraints.setTextFieldInteger(txtQuantidade);
		Constraints.setTextFieldInteger(txtId);

	}

}
