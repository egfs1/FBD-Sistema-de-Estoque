package business;

import java.sql.SQLException;

import model.Pedido;

public interface IBusinessVendas {
	
	public void addVendas(Pedido pedido) throws SQLException;
	
	public void updateCliente(String login_novo, String login_antigo) throws SQLException;
	
	public String[][] dataVendas() throws SQLException;
	
	public String[][] dataVendasBusca(String busca) throws SQLException;
	
	public String[] colunasVendas();
	
}
