package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Endereco;
import model.Pedido;
import model.Usuario;

public interface IDaoEndereco {
	
	public void salvar(Endereco endereco) throws SQLException;
	
	public ArrayList<Endereco> dataEndereco() throws SQLException;
	
	public ArrayList<Endereco> dataEnderecoBusca(String busca) throws SQLException;
	
	public void delete(int id) throws SQLException;
	
	
	
}
