package model;

public class Produto {
	
	private String nome;
	private int id, qnt;
	private double valor_encomenda, valor_venda;
	
	
	public Produto(String nome, double valor_encomenda, double valor_venda) {
		this.nome = nome;
		this.valor_encomenda = valor_encomenda;
		this.valor_venda = valor_venda;
	
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

	public double getValor_encomenda() {
		return valor_encomenda;
	}

	public void setValor_encomenda(double valor_encomenda) {
		this.valor_encomenda = valor_encomenda;
	}

	public double getValor_venda() {
		return valor_venda;
	}

	public void setValor_venda(double valor_venda) {
		this.valor_venda = valor_venda;
	}

	public int getQnt() {
		return qnt;
	}

	public void setQnt(int qnt) {
		this.qnt = qnt;
	}


	
	
	
}
