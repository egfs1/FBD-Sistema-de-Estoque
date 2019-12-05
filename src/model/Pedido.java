package model;

import java.sql.Date;

public class Pedido {
	
	private int id, id_produto, qnt;
	private double valor;
	private Cliente cliente;
	private Date data;
	
	public Pedido(Cliente cliente, int id_produto, int qnt, double valor, Date data) {
		this.id_produto = id_produto;
		this.qnt = qnt;
		this.valor = valor;
		this.cliente = cliente;
		this.data = data;
	}
	
	public String toString() {
		return "ID da Venda: " + id + "\n" +
				"	Cliente: " + cliente.getLogin() + "\n" + 
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
