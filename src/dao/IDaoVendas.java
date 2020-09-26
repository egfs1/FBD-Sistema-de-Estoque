package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import model.Cliente;
import model.Pedido;

public interface IDaoVendas {
	
	public Pedido salvar(Pedido pedido) throws SQLException;
	
	public void deletarPedidoCliente(String cliente) throws SQLException;
	
	public void deletarPedidoProduto(int id_produto) throws SQLException;
	
	public void updateCliente(String login_cliente_novo, String login_cliente_antigo) throws SQLException;
	
	public ArrayList<Pedido> dataVendas() throws SQLException;
	
	public ArrayList<Pedido> dataVendasCliente(Cliente cliente) throws SQLException;
	
	public ArrayList<Pedido> dataVendasBusca(String busca) throws SQLException;
	
}
