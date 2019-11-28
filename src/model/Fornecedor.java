package model;

import java.sql.SQLException;
import java.util.ArrayList;

import fachada.Fachada;

public class Fornecedor extends Usuario {
	
	private ArrayList<Encomenda>encomendas = new ArrayList<>();
	
	public Fornecedor(String login, String senha) {
		super(login, senha, "Fornecedor");
	}
	
	public void atualizarDataEncomendas() throws SQLException{
		encomendas = Fachada.getInstance().getDaoEncomendas().dataEncomendasFornecedor(this);
	}
	
	public String [][] dadosEncomendas() {
		
		String[][] s = new String[encomendas.size()][6];
		int contador = 0;
		for (Encomenda e: encomendas) {
			s[encomendas.indexOf(e)][contador] = String.valueOf(e.getId());
			contador++;
			s[encomendas.indexOf(e)][contador] = String.valueOf(e.getFornecedor().getLogin());
			contador++;
			s[encomendas.indexOf(e)][contador] = String.valueOf(e.getId_produto());
			contador++;
			s[encomendas.indexOf(e)][contador] = String.valueOf(e.getQnt());
			contador++;
			s[encomendas.indexOf(e)][contador] = String.valueOf(e.getValor());
			contador++;
			s[encomendas.indexOf(e)][contador] = String.valueOf(e.getData());
			contador=0;
		}
		
		return s;
	}
	
	public void addEncomendas(Encomenda compra) {
		encomendas.add(compra);
	}
	
	public ArrayList<Encomenda> getEncomendas() {
		return encomendas;
	}

	public void setEncomendas(ArrayList<Encomenda> compras) {
		this.encomendas = compras;
	}
	
	
	
}
