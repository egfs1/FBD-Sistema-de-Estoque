package business;

import java.sql.SQLException;

import model.Endereco;
import model.Usuario;

public interface IBusinessEndereco {
	
	public void cadastrarEndereco(Endereco endereco) throws SQLException;
	
	public Endereco buscarEndereco(Usuario usuario) throws SQLException;
	
	public String[][] dataEndereco() throws SQLException;
	
	public String[][] dataEnderecoBusca(String busca) throws SQLException;
	
	public String[] colunasEndereco();
	
	public void deletarEndereco(int id) throws SQLException;
	
}
