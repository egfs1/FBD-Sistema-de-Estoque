package business;

import java.sql.SQLException;

import model.Produto;

public interface IBusinessEstoque {
	
	
	public Produto buscarProdutoID(int id) throws SQLException;
	
	public boolean cadastrarProduto(Produto produto) throws SQLException;
	
	public boolean existeProduto(int id) throws SQLException;
	
	public void editarProduto(Produto produto, String login, double valor_encomenda, double valor_venda) throws SQLException;
	
	public void deletarProduto(Produto produto) throws SQLException;
	
	public String[][] dataEstoque() throws SQLException;
	
	public String[] colunasEstoque();
	
	public String[][] dataEstoqueBusca(String busca) throws SQLException;
	
	
}
