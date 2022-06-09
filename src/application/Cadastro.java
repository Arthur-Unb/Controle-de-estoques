package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Cadastro extends Application {

	private static Stage stage;

	public void start(Stage stage) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("/view/CadastroView.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("Tela Principal");
		stage.setScene(scene);
		stage.show();
		setStage(stage);

	}

	private void setStage(Stage stage) {
		Cadastro.stage = stage;

	}

	public static Stage getStage() {
		return stage;
	}

}
