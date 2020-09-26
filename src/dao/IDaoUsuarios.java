package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Endereco;
import model.Usuario;

public interface IDaoUsuarios {
	
	public Usuario salvar(Usuario usuario) throws SQLException;
	
	public void setEndereco(Usuario usuario, Endereco endereco) throws SQLException;
	
	public ArrayList<Usuario> dataUsuarios() throws SQLException;
	
	public ArrayList<Usuario> dataUsuariosBusca(String busca) throws SQLException;
	
	public void edit(Usuario usuario, String login, String senha, String email) throws SQLException;
	
	public void deletar(Usuario usuario) throws SQLException;
	
}
