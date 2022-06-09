package view;

import java.io.IOException;

import application.Cadastro;
import application.Main;
import dao.UserDaoJDBC;
import db.DB;
import entities.User;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import util.Alerts;

public class MainViewController {

	@FXML
	private TextField txtLogin;

	@FXML
	private TextField txtPassword;

	@FXML
	private Button loginButton;

	@FXML
	public void onButtonLogin() throws Exception {

		UserDaoJDBC userConn = new UserDaoJDBC(DB.getConnection());

		User user = new User();

		user.setLogin(txtLogin.getText());
		user.setPassword(txtPassword.getText());

		if (userConn.findById(user) != null) {
			Cadastro p = new Cadastro();

			p.start(new Stage());

			Main.getStage().close();
		} else {

			IOException e = new IOException();

			Alerts.showAlert("IO Exception", "Usuário ou senha inválidos", e.getMessage(), AlertType.ERROR);

		}

	}

}
