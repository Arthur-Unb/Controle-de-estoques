package view;

import dao.ProductsDaoJDBC;
import db.DB;
import entities.Products;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CadastroViewController {

	@FXML
	private TextField txtproductId;

	@FXML
	private TextField txtproductName;

	@FXML
	private TextField txtproductQuantity;

	@FXML
	private TextField txtproductPrice;

	@FXML
	private TextField txtproductIdSearch;

	@FXML
	private Button buttonCadastro;

	@FXML
	private Button buttonSearch;

	@FXML
	private Button buttonExclude;

	@FXML
	public void onBtNewActionCadastrar() {

		ProductsDaoJDBC gravar = new ProductsDaoJDBC(DB.getConnection());

		Products p = new Products();

		p.setProductId(Integer.valueOf(txtproductId.getText()));
		p.setProductName(txtproductName.getText());
		p.setQuantity(Integer.valueOf(txtproductQuantity.getText()));
		p.setPrice(Double.valueOf(txtproductPrice.getText()));

		System.out.println(p);

		gravar.insert(p);

	}

	@FXML
	public void onBtNewActionSearch() {

	}

	@FXML
	public void onBtNewActionExclude() {

	}

}
