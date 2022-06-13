package view;

import java.net.URL;
import java.util.ResourceBundle;

import application.Cadastro;
import application.Main;
import application.Transacao;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainViewController implements Initializable {

	@FXML
	private Button cadastroButton;

	@FXML
	private Button produtoButton;

	@FXML
	public void onMenuItemCadastro() throws Exception {

		Cadastro p = new Cadastro();

		p.start(new Stage());

		Main.getStage().close();

	}

	@FXML
	public void onMenuItemProduto() throws Exception {

		Transacao p = new Transacao();

		p.start(new Stage());

		Main.getStage().close();

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

}
