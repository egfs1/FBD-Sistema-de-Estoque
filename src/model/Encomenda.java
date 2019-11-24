package model;

import java.sql.Date;

public class Encomenda {
	
	private int id, id_produto, qnt, valor;
	private Fornecedor fornecedor;
	private Date data;
	
	public Encomenda(Fornecedor fornecedor, int id_produto, int qnt, int valor, Date data) {
		this.id_produto = id_produto;
		this.qnt = qnt;
		this.fornecedor = fornecedor;
		this.data = data;
		this.valor =valor;
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



	public int getValor() {
		return valor;
	}



	public void setValor(int valor) {
		this.valor = valor;
	}



	public Date getData() {
		return data;
	}



	public void setData(Date data) {
		this.data = data;
	}
	
	
	
}
