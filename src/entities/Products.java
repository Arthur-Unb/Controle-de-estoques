package entities;

public class Products {

	private Integer productId;

	private String productName;

	private Integer quantity;

	private Double price;

	public Products(Integer productId, String productName, Integer quantity, Double price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
	}

	public Products() {

	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	// M�todos:
	// cadastrarProdutos();
	// alterarProdutos();
	// excluirProdutos();

}
