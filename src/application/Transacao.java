package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Transacao {

	private static Stage stage;

	public void start(Stage stage) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("/view/TransacaoView.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("Tela Principal");
		stage.setScene(scene);
		stage.show();
		setStage(stage);

	}

	private void setStage(Stage stage) {
		Transacao.stage = stage;

	}

	public static Stage getStage() {
		return stage;
	}

}
