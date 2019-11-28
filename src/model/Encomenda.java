package model;

import java.sql.Date;

public class Encomenda {
	
	private int id, id_produto, qnt;
	private double valor;
	private Fornecedor fornecedor;
	private Date data;
	
	public Encomenda(Fornecedor fornecedor, int id_produto, int qnt, double valor, Date data) {
		this.id_produto = id_produto;
		this.qnt = qnt;
		this.fornecedor = fornecedor;
		this.data = data;
		this.valor =valor;
	}
	
	public String toString() {
		return "ID da Encomenda: " + id + "\n" +
				"	Fornecedor: " + fornecedor.getLogin() + "\n" + 
				"	ID do Produto: " + id_produto + "\n" +
				"	Quantidade: " + qnt + "\n" +
				"	Valor: " + valor + "\n" +
				"	Data: " + data + "\n\n";
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

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}



	public int getId_produto() {
		return id_produto;
	}

	public void setId_produto(int id_produto) {
		this.id_produto = id_produto;
	}



	public double getValor() {
		return valor;
	}



	public void setValor(double valor) {
		this.valor = valor;
	}



	public Date getData() {
		return data;
	}



	public void setData(Date data) {
		this.data = data;
	}
	
	
	
}
