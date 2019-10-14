package model;

public class Compra {
	
	private int id, qnt;
	private Fornecedor fornecedor;
	
	public Compra(int id, int qnt, Fornecedor fornecedor) {
		this.id = id;
		this.qnt = qnt;
		this.fornecedor = fornecedor;
	}
	
	

	public String toString() {
		return "ID: " + id + "\n"+ 
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
	
	
	
}
