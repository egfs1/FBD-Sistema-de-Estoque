package business;

import java.sql.SQLException;

import model.Encomenda;

public interface IBusinessEncomenda {
	
	public void encomendarProduto(Encomenda encomenda) throws SQLException;
	
	public void updateFornecedor(String login_novo, String login_antigo) throws SQLException;
	
	public String[][] dataEncomendas() throws SQLException;
	
	public String[] colunasEncomenda();
	
	public String[][] dataEncomendasBusca(String busca) throws SQLException;
	
}
