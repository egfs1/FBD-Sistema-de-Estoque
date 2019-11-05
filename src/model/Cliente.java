package model;

import java.sql.SQLException;
import java.util.ArrayList;

public class Cliente extends Usuario {
	
	private ArrayList<Pedido>pedidos = new ArrayList<>();
	
	
	public Cliente(String login, String senha) {
		super(login, senha, "Cliente");
	}
	
	public void atualizarDataPedidos() throws SQLException{
		pedidos = BaseDados.daoVendas.dataVendasCliente(this);
	}
	
	public String [][] dadosPedidos() {
		
		String[][] s = new String[pedidos.size()][4];
		int contador = 0;
		for (Pedido p: pedidos) {
			s[pedidos.indexOf(p)][contador] = String.valueOf(p.getId());
			contador++;
			s[pedidos.indexOf(p)][contador] = String.valueOf(p.getId_produto());
			contador++;
			s[pedidos.indexOf(p)][contador] = String.valueOf(this.getLogin());
			contador++;
			s[pedidos.indexOf(p)][contador] = String.valueOf(p.getQnt());
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
