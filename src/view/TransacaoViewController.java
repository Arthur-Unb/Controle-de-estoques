package view;

import java.net.URL;
import java.util.ResourceBundle;

import dao.DaoTransacaoJDBC;
import db.DB;
import entities.ModelTransacao;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class TransacaoViewController implements Initializable {

	@FXML
	private TextField txtIdProdutoField;

	@FXML
	private TextField txtIdTransacaoField;

	@FXML
	private TextField txtQuantidadeField;

	@FXML
	private TextField txtTipoField;

	@FXML
	private TextField txtIdFuncionario;

	@FXML
	private Text txtResposta;

	@FXML
	private Button cadastratButton;

	@FXML
	private Button buscarButton;

	@FXML
	private void onBtCadastrar() {

		DaoTransacaoJDBC cadastrar = new DaoTransacaoJDBC(DB.getConnection());

		ModelTransacao item = new ModelTransacao();

		item.setIdProduto(Integer.valueOf(txtIdProdutoField.getText()));
		item.setIdFuncionario(Integer.valueOf(txtIdFuncionario.getText()));
		item.setQuantidadeProduto(Integer.valueOf(txtQuantidadeField.getText()));
		item.setTipoTransacao(txtTipoField.getText());

		cadastrar.insert(item);

		if (item.getTipoTransacao() == "ENTRADA") {

			cadastrar.update(item);

		} else if (item.getTipoTransacao() == "SAIDA") {

			item.setQuantidadeProduto(-item.getQuantidadeProduto());

			cadastrar.update(item);

		}

	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {

	}

}
