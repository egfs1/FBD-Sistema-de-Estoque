package model;


public abstract class Usuario {
	
	private String login, senha, email;
	private String TIPO; //ADM, Cliente, Fornecedor
	private int id;
	private int endereco;


	public Usuario(String login, String senha, String email, String tipo) {
		this.login = login;
		this.senha = senha;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEndereco() {
		return endereco;
	}

	public void setEndereco(int endereco) {
		this.endereco = endereco;
	}
	
	
	
	
	
}
