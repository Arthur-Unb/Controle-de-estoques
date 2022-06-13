package entities;

public class ModelUsuario {

	private Integer idUsuario;

	private String nome;

	private String funcao;

	public ModelUsuario(Integer idUsuario, String nome, String funcao) {
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.funcao = funcao;
	}

	public ModelUsuario() {

	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

}
