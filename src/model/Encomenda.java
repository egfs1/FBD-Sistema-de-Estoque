package model;

public class Encomenda {
	
	private int id, id_produto, qnt;
	private Fornecedor fornecedor;
	
	public Encomenda(int id_produto, int qnt, Fornecedor fornecedor) {
		this.id_produto = id_produto;
		this.qnt = qnt;
		this.fornecedor = fornecedor;
	}
	
	

	public String toString() {
		return "ID: " + id + "\n" +
				"ID Produto: " + id_produto + "\n"+ 
				"Qnt: " + qnt + "\n" + 
				"Fornecedor: " + fornecedor.getLogin() + "\n\n";
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
	
	
	
}
