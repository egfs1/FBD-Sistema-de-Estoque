package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Encomenda;
import model.Fornecedor;

public interface IDaoEncomendas {
	
	public Encomenda salvar(Encomenda encomenda) throws SQLException;
	
	public void deletarEncomendaFornecedor(String fornecedor) throws SQLException;
	
	public void deletarEncomendaProduto(int id_produto) throws SQLException;
	
	public ArrayList<Encomenda> dataEncomendas() throws SQLException;
	
	public ArrayList<Encomenda> dataEncomendasFornecedor(Fornecedor fornecedor) throws SQLException;
	
	public ArrayList<Encomenda> dataEncomendasBusca(String busca) throws SQLException;
	
}
