package business;

import java.sql.SQLException;

import model.Encomenda;

public interface IBusinessEncomenda {
	
	public boolean encomendarProduto(Encomenda encomenda) throws SQLException;
	
	public String[][] dataEncomendas() throws SQLException;
	
	public String[] colunasEncomenda();
	
	public String[][] dataEncomendasBusca(String busca) throws SQLException;
	
}
