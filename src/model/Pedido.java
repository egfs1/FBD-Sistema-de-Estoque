package model;

import java.sql.Date;

public class Pedido {
	
	private int id, id_produto, qnt, valor;
	private Cliente cliente;
	private Date data;
	
	public Pedido(Cliente cliente, int id_produto, int qnt, int valor, Date data) {
		this.id_produto = id_produto;
		this.qnt = qnt;
		this.valor = valor;
		this.cliente = cliente;
		this.data = data;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
