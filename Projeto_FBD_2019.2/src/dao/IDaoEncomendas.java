package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Encomenda;
import model.Fornecedor;

public interface IDaoEncomendas {
	
	public Encomenda salvar(Encomenda encomenda) throws SQLException;
	
	public ArrayList<Encomenda> dataEncomendas() throws SQLException;
	
	public ArrayList<Encomenda> dataEncomendasFornecedor(Fornecedor fornecedor) throws SQLException;
	
}
