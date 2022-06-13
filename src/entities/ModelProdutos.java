package entities;

public class ModelProdutos {

	private Integer idProduto;

	private String proNome;

	private Double proValor;

	private Integer proEstoque;

	public ModelProdutos() {

	}

	public ModelProdutos(Integer idProduto, String proNome, Double proValor, Integer proEstoque) {
		this.idProduto = idProduto;
		this.proNome = proNome;
		this.proValor = proValor;
		this.proEstoque = proEstoque;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public String getProNome() {
		return proNome;
	}

	public void setProNome(String proNome) {
		this.proNome = proNome;
	}

	public Double getProValor() {
		return proValor;
	}

	public void setProValor(Double proValor) {
		this.proValor = proValor;
	}

	public Integer getProEstoque() {
		return proEstoque;
	}

	public void setProEstoque(Integer proEstoque) {
		this.proEstoque = proEstoque;
	}

}
