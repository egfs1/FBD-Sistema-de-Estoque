package model;

import java.util.ArrayList;

public class Fornecedor extends Usuario {
	
	private ArrayList<Compra>compras = new ArrayList<>();
	
	public Fornecedor(String login, String senha) {
		super(login, senha, "Fornecedor");
	}
	
	public void addCompras(Compra compra) {
		compras.add(compra);
	}
	
	public ArrayList<Compra> getCompras() {
		return compras;
	}

	public void setCompras(ArrayList<Compra> compras) {
		this.compras = compras;
	}
	
	
	
}
