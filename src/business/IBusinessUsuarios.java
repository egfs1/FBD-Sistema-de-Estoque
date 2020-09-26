package business;

import java.sql.SQLException;

import model.Endereco;
import model.Usuario;

public interface IBusinessUsuarios {
	
	public Usuario verificarLogin(String login, String senha) throws SQLException;
	
	public Usuario buscarUsuarioLogin(String login) throws SQLException;
	
	public Usuario buscarUsuarioID(int id) throws SQLException;
	
	public void cadastrarUsuario(Usuario usuario) throws SQLException;
	
	public void editarUsuario(Usuario usuario, String login, String senha, String email) throws SQLException;
	
	public void setEndereco(Usuario usuario, Endereco endereco) throws SQLException;
	
	public void deletarUsuario(Usuario usuario) throws SQLException;
	
	public String[][] dataUsuarios() throws SQLException;
	
	public String[][] dataUsuariosBusca(String busca) throws SQLException;
	
	public String[] colunasUsuarios();
	
}
