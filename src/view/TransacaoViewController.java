package view;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.mysql.cj.Session;

import dao.DaoTransacaoJDBC;
import db.DB;
import entities.ModelTransacao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import model.service.ModelTransacaoService;

public class TransacaoViewController implements Initializable {

	private ModelTransacaoService service;

	public void setModelTransactionService(ModelTransacaoService service) {
		this.service = service;
	}

	private ObservableList<ModelTransacao> obsList;

	@FXML
	private Button testeButton;

	@FXML
	public void updateTableView() {
		if (service == null) {
			throw new IllegalStateException("Service was null!");
		}
		List<ModelTransacao> list = service.findAll();
		obsList = FXCollections.observableArrayList(list);
		tableViewTransacao.setItems(obsList);

	}

	@FXML
	private TextField txtIdProdutoField;

	@FXML
	private TextField txtIdProdutoBuscarField;

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
	private TableView<ModelTransacao> tableViewTransacao;

	@FXML
	private TableColumn<ModelTransacao, Integer> tableColumnIdTransacao;

	@FXML
	private TableColumn<ModelTransacao, Integer> tableColumnIdProduto;

	@FXML
	private TableColumn<ModelTransacao, Integer> tableColumnIdFuncionario;

	@FXML
	private TableColumn<ModelTransacao, Integer> tableColumnQuantidade;

	@FXML
	private TableColumn<ModelTransacao, String> tableColumnTipoTransacao;

	@FXML
	private void onBtCadastrar() {

		DaoTransacaoJDBC cadastrar = new DaoTransacaoJDBC(DB.getConnection());

		ModelTransacao item = new ModelTransacao();

		item.setIdProduto(Integer.valueOf(txtIdProdutoField.getText()));
		item.setIdFuncionario(Integer.valueOf(txtIdFuncionario.getText()));
		item.setQuantidadeProduto(Integer.valueOf(txtQuantidadeField.getText()));
		item.setTipoTransacao(txtTipoField.getText());

		cadastrar.insert(item);

		String tipo = item.getTipoTransacao();

		if (tipo.equals("ENTRADA")) {

			cadastrar.update(item);

			System.out.println(item.getTipoTransacao().toString());

		} else if (tipo.equals("SAIDA")) {

			item.setQuantidadeProduto(-item.getQuantidadeProduto());

			System.out.println(item.getTipoTransacao().toString());

			cadastrar.update(item);

		} else {

			System.out.println("OK");
		}

	}

	@FXML
	private void onBtBuscar() {

		DaoTransacaoJDBC buscar = new DaoTransacaoJDBC(DB.getConnection());

		int x = Integer.valueOf(txtIdProdutoBuscarField.getText());

		System.out.println(buscar.findById(x));

	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		initializeNodes();

	}

	private void initializeNodes() {

		tableColumnIdTransacao.setCellValueFactory(new PropertyValueFactory<>("Id da transação"));
		tableColumnIdProduto.setCellValueFactory(new PropertyValueFactory<>("Id do produto"));
		tableColumnIdFuncionario.setCellValueFactory(new PropertyValueFactory<>("Id do funcionario"));
		tableColumnQuantidade.setCellValueFactory(new PropertyValueFactory<>("Quantidade"));
		tableColumnTipoTransacao.setCellValueFactory(new PropertyValueFactory<>("Tipo de transação"));

	}

}
