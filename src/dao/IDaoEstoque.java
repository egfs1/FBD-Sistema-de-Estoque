package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import model.Produto;

public interface IDaoEstoque {
	
	public Produto salvar(Produto produto) throws SQLException;
	
	public void adicionarQnt(int id_produto, int qnt) throws SQLException;
	
	public void removerQnt(int id_produto, int qnt) throws SQLException;
	
	public ArrayList<Produto> dataEstoque() throws SQLException;
	
	public ArrayList<Produto> dataEstoqueBusca(String busca) throws SQLException;
	
	public void delete(Produto produto) throws SQLException;
	
	public void edit(Produto produto, String login, double valor_encomenda, double valor_venda) throws SQLException;
	
}
