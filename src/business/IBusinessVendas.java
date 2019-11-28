package business;

import java.sql.SQLException;

import model.Pedido;

public interface IBusinessVendas {
	
	public boolean addVendas(Pedido pedido) throws SQLException;
	
	public String[][] dataVendas() throws SQLException;
	
	public String[][] dataVendasBusca(String busca) throws SQLException;
	
	public String[] colunasVendas();
	
}
