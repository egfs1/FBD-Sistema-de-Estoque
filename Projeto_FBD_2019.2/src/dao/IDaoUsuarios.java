package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Usuario;

public interface IDaoUsuarios {
	
	public Usuario salvar(Usuario usuario) throws SQLException;
	
	public ArrayList<Usuario> dataUsuarios() throws SQLException;
	
}