package entities;

public class Products {

	private Integer productId;

	private String productName;

	private Integer quantity;

	private Double price;

	public Products(Integer id, String productName, Integer quantity, Double priceBuy, Double priceSell) {
		this.productId = id;
		this.productName = productName;
		this.quantity = quantity;
		this.price = priceBuy;
		this.price = priceSell;
	}

	public Integer getId() {
		return productId;
	}

	public void setId(Integer id) {
		this.productId = id;
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

	public Double getPriceBuy() {
		return price;
	}

	public void setPriceBuy(Double priceBuy) {
		this.price = priceBuy;
	}

	public Double getPriceSell() {
		return price;
	}

	public void setPriceSell(Double priceSell) {
		this.price = priceSell;
	}

	// Métodos:
	// cadastrarProdutos();
	// alterarProdutos();
	// excluirProdutos();

}
