package model;

public class Produto {
	
	private String nome;
	private int id, qnt;
	
	
	public Produto(String nome) {
		this.nome = nome;
	}
	
	
	
	public String toString() {
		return "ID: " + id + "\n" +
				 "Nome: " + nome + "\n" +
				 "Qnt: " + qnt + "\n\n";
	}



	public void addQnt(int qnt) {
		this.qnt += qnt;
	}
	

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getQnt() {
		return qnt;
	}


	public void setQnt(int qnt) {
		this.qnt = qnt;
	}
	
	
	
	
}
