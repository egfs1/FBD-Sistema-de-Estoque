package model;

public class Pedido {
	
	private int id, id_produto, qnt;
	private Cliente cliente;
	
	public Pedido(int id_produto, int qnt, Cliente cliente) {
		this.id_produto = id_produto;
		this.qnt = qnt;
		this.cliente = cliente;
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
	
	
	
	
}
