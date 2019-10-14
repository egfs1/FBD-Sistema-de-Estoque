package model;

public class Pedido {
	
	private int id, qnt;
	private Cliente cliente;
	
	public Pedido(int id, int qnt, Cliente cliente) {
		this.id = id;
		this.qnt = qnt;
		this.cliente = cliente;
	}
	
	public String toString() {
		return "ID: " + id + "\n"+ 
				"Qnt: " + qnt + "\n" + 
				"Cliente: " + cliente.getLogin() + "\n\n";
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
	
	
	
	
}
