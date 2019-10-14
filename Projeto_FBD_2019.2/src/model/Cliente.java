package model;

import java.util.ArrayList;

public class Cliente extends Usuario {
	
	private ArrayList<Pedido>pedidos = new ArrayList<>();
	
	
	public Cliente(String login, String senha) {
		super(login, senha, "Cliente");
	}
	
	public String [][] dadosPedidos() {
		String[][] s = new String[pedidos.size()][3];
		
		int contador = 0;
		for (Pedido p: pedidos) {
			s[pedidos.indexOf(p)][contador] = String.valueOf(p.getId());
			contador++;
			s[pedidos.indexOf(p)][contador] = String.valueOf(p.getQnt());
			contador++;
			s[pedidos.indexOf(p)][contador] = String.valueOf(this.getLogin());
			contador=0;
		}
		
		return s;
	}
	
	
	
	public void addPedidos(Pedido pedido) {
		pedidos.add(pedido);
	}

	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}


	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	

}
