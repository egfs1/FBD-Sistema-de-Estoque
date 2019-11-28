package model;


public abstract class Usuario {
	
	private String login, senha;
	private String TIPO; //ADM, Cliente, Fornecedor
	private int id;


	public Usuario(String login, String senha, String tipo) {
		this.login = login;
		this.senha = senha;
		this.TIPO = tipo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipo() {
		return TIPO;
	}

	public void setTipo(String tipo) {
		this.TIPO = tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	
}
