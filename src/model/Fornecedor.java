package model;

import java.util.ArrayList;

public class Fornecedor extends Usuario {
	
	private ArrayList<Encomenda>compras = new ArrayList<>();
	
	public Fornecedor(String login, String senha) {
		super(login, senha, "Fornecedor");
	}
	
	public void addCompras(Encomenda compra) {
		compras.add(compra);
	}
	
	public ArrayList<Encomenda> getCompras() {
		return compras;
	}

	public void setCompras(ArrayList<Encomenda> compras) {
		this.compras = compras;
	}
	
	
	
}
