package business;

import java.sql.SQLException;

import model.Usuario;

public interface IBusinessUsuarios {
	
	public Usuario verificarLogin(String login, String senha) throws SQLException;
	
	public Usuario buscarUsuarioLogin(String login) throws SQLException;
	
	public Usuario buscarUsuarioID(int id) throws SQLException;
	
	public boolean cadastrarUsuario(Usuario usuario) throws SQLException;
	
	public boolean existeUsuario(String login) throws SQLException;
	
	public void editarUsuario(Usuario usuario, String login, String senha);
	
	public void deletarUsuario(Usuario usuario);
	
	public String[][] dataUsuarios() throws SQLException;
	
	public String[] colunasUsuarios();
	
}
