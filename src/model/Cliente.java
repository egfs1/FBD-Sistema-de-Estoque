package model;

import java.sql.SQLException;
import java.util.ArrayList;

import fachada.Fachada;

public class Cliente extends Usuario {
	
	private ArrayList<Pedido>pedidos = new ArrayList<>();
	
	
	public Cliente(String login, String senha, String email) {
		super(login, senha, email, "Cliente");
	}
	
	public void atualizarDataPedidos() throws SQLException{
		pedidos = Fachada.getInstance().getDaoVendas().dataVendasCliente(this);
	}
	
	public String [][] dadosPedidos() {
		
		String[][] s = new String[pedidos.size()][6];
		int contador = 0;
		for (Pedido p: pedidos) {
			s[pedidos.indexOf(p)][contador] = String.valueOf(p.getId());
			contador++;
			s[pedidos.indexOf(p)][contador] = String.valueOf(p.getCliente().getLogin());
			contador++;
			s[pedidos.indexOf(p)][contador] = String.valueOf(p.getId_produto());
			contador++;
			s[pedidos.indexOf(p)][contador] = String.valueOf(p.getQnt());
			contador++;
			s[pedidos.indexOf(p)][contador] = String.valueOf(p.getValor());
			contador++;
			s[pedidos.indexOf(p)][contador] = String.valueOf(p.getData());
			contador=0;
		}
		
		return s;
	}

	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}


	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	

}
