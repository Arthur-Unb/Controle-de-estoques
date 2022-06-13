package entities;

public class ModelTransacao {

	private Integer idTransacao;

	private Integer idProduto;

	private Integer idFuncionario;

	private Integer quantidadeProduto;

	private String tipoTransacao;

	public ModelTransacao(Integer idTransacao, Integer idProduto, Integer idFuncionario, Integer quantidadeProduto,
			String tipoTransacao) {
		this.idTransacao = idTransacao;
		this.idProduto = idProduto;
		this.idFuncionario = idFuncionario;
		this.quantidadeProduto = quantidadeProduto;
		this.tipoTransacao = tipoTransacao;
	}

	public ModelTransacao() {

	}

	public Integer getIdTransacao() {
		return idTransacao;
	}

	public void setIdTransacao(Integer idTransacao) {
		this.idTransacao = idTransacao;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public Integer getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public Integer getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(Integer quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

	public String getTipoTransacao() {
		return tipoTransacao;
	}

	public void setTipoTransacao(String tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}

}