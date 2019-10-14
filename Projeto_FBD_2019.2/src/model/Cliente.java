package model;

import java.util.ArrayList;

public class Cliente extends Usuario {
	
	private ArrayList<Pedido>pedidos = new ArrayList<>();
	
	
	public Cliente(String login, String senha) {
		super(login, senha, "Cliente");
	}
	
	public String dadosPedidos() {
		String s="  =-=-=-=-= Pedidos =-=-=-=-=  \n";
		
		for (Pedido p: pedidos) {
			s += p.toString();
		}
		
		if (s.equals("  =-=-=-=-= Pedidos =-=-=-=-=  \n"))
			s = "=-= Nenhum Pedido Realizado =-=";
		
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
