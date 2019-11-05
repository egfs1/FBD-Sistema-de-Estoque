package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Administrador;
import model.Caixa;
import model.Cliente;
import model.Fornecedor;
import model.Usuario;
import sql.SQLConnection;
import sql.SQLUtil;

public class DaoUsuarios implements IDaoUsuarios {
	
	private Connection conexao;
	private PreparedStatement preparedstatement;
	private Statement statement;
	private ResultSet rs;
	
	
	@Override
	public Usuario salvar(Usuario usuario) throws SQLException {
		
		this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRES);
        this.preparedstatement = conexao.prepareStatement(SQLUtil.Usuarios.INSERT_ALL);
        
        preparedstatement.setString(1, usuario.getLogin());
        preparedstatement.setString(2,usuario.getSenha());
        preparedstatement.setString(3, usuario.getTipo());
        
        preparedstatement.execute();
        
        this.conexao.close();
        
		return usuario;
	}
	
	
	
	@Override
	public ArrayList<Usuario> dataUsuarios() throws SQLException {
		ArrayList<Usuario>data = new ArrayList<>();
		
		this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRES);
		
		this.statement = conexao.createStatement();
		this.rs = statement.executeQuery(SQLUtil.Usuarios.SELECT_ALL);
		
		while (rs.next()) {
			int id = rs.getInt("id");
			String login = rs.getString("login");
			String senha = rs.getString("senha");
			String tipo = rs.getString("tipo");
			Usuario u = null;
			
			switch (tipo) {
			case "ADM":
				u = new Administrador(login, senha);
				break;

			case "Cliente":
				u = new Cliente(login, senha);
				break;
			
			case "Caixa":
				u = new Caixa(login, senha);
				break;
			
			
			case "Fornecedor":
				u = new Fornecedor(login, senha);
				break;
			
			}
			u.setId(id);
			data.add(u);	
		}
		
		this.conexao.close();
		
		return data;
	}



	@Override
	public void edit(Usuario usuario, String login, String senha) throws SQLException {
		
		this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRES);
        this.preparedstatement = conexao.prepareStatement(SQLUtil.Usuarios.EDIT_ALL);
        
        preparedstatement.setString(1, login);
        preparedstatement.setString(2, senha);
        preparedstatement.setInt(3, usuario.getId());
        
        
        preparedstatement.execute();
        
        this.conexao.close();
		
	}



	@Override
	public void deletar(Usuario usuario) throws SQLException {
		
		this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRES);
        this.preparedstatement = conexao.prepareStatement(SQLUtil.Usuarios.DELETE_USUARIO);
        
        preparedstatement.setInt(1, usuario.getId());
        
        
        preparedstatement.execute();
        
        this.conexao.close();
		
	}
	
	
	
}
