package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Produto;

public interface IDaoEstoque {
	
	public Produto salvar(Produto produto) throws SQLException;
	
	public void adicionarQnt(Produto produto, int qnt) throws SQLException;
	
	public void removerQnt(Produto produto, int qnt) throws SQLException;
	
	public ArrayList<Produto> dataEstoque() throws SQLException;
	
}
