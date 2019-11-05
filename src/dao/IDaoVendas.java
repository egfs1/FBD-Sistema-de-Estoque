package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Cliente;
import model.Pedido;

public interface IDaoVendas {
	
	public Pedido salvar(Pedido pedido) throws SQLException;
	
	public ArrayList<Pedido> dataVendas() throws SQLException;
	
	public ArrayList<Pedido> dataVendasCliente(Cliente cliente) throws SQLException;
	
}
