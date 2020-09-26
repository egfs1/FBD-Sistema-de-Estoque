package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Administrador;
import model.Cliente;
import model.Endereco;
import model.Fornecedor;
import model.Usuario;
import sql.SQLConnection;
import sql.SQLUtil;

public class DaoUsuarios implements IDaoUsuarios {
	
	private Connection conexao;
	private PreparedStatement preparedstatement;
	private Statement statement;
	private ResultSet rs;
	
	public void criarTabela() {
		try {
			
			this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRES);
	        this.statement = conexao.createStatement();
	        
	        this.statement.executeQuery(SQLUtil.Usuarios.CREATE_TABLE);
	        
	        this.conexao.close();
	        
			} catch(SQLException e) {
				
		}
	}
	
	
	@Override
	public Usuario salvar(Usuario usuario) throws SQLException {
		
		this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRES);
        this.preparedstatement = conexao.prepareStatement(SQLUtil.Usuarios.INSERT_ALL);
        
        preparedstatement.setString(1, usuario.getLogin());
        preparedstatement.setString(2,usuario.getSenha());
        preparedstatement.setString(3, usuario.getEmail());
        preparedstatement.setInt(4, 0);
        preparedstatement.setString(5, usuario.getTipo());
        
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
			String email = rs.getString("email");
			int id_endereco = rs.getInt("endereco");
			String tipo = rs.getString("tipo");
			
			Usuario u = null;
			
			switch (tipo) {
			case "ADM":
				u = new Administrador(login, senha, email);
				if (id_endereco!=0) {
					u.setEndereco(id_endereco);
				}else {
					u.setEndereco(0);
				}
				break;

			case "Cliente":
				u = new Cliente(login, senha, email);
				if (id_endereco!=0) {
					u.setEndereco(id_endereco);
				}else {
					u.setEndereco(0);
				}
				break;
			
			case "Fornecedor":
				u = new Fornecedor(login, senha, email);
				if (id_endereco!=0) {
					u.setEndereco(id_endereco);
				}else {
					u.setEndereco(0);
				}
				break;
			
			}
			u.setId(id);
			data.add(u);	
		}
		
		this.conexao.close();
		
		return data;
	}



	@Override
	public void edit(Usuario usuario, String login, String senha, String email) throws SQLException {
		
		this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRES);
        this.preparedstatement = conexao.prepareStatement(SQLUtil.Usuarios.EDIT_ALL);
        
        preparedstatement.setString(1, login);
        preparedstatement.setString(2, senha);
        preparedstatement.setString(3, email);
        preparedstatement.setInt(4, usuario.getId());
        
        
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


	@Override
	public ArrayList<Usuario> dataUsuariosBusca(String busca) throws SQLException {
		ArrayList<Usuario>data = new ArrayList<>();
		
		this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRES);
		
		try {
			
			this.preparedstatement = conexao.prepareStatement(SQLUtil.Usuarios.BUSCAR_USUARIO_INT);
			preparedstatement.setInt(1, Integer.parseInt(busca));
			preparedstatement.setInt(2, Integer.parseInt(busca));
			
		}catch(Exception e) {
			this.preparedstatement = conexao.prepareStatement(SQLUtil.Usuarios.BUSCAR_USUARIO_STRING);
			preparedstatement.setString(1, busca);
			preparedstatement.setString(2, busca);
			preparedstatement.setString(3, busca);
		}
		
		rs = preparedstatement.executeQuery();
		
		while (rs.next()) {
			int id = rs.getInt("id");
			String login = rs.getString("login");
			String senha = rs.getString("senha");
			String email = rs.getString("email");
			int id_endereco = rs.getInt("endereco");
			String tipo = rs.getString("tipo");
			
			Usuario u = null;
			
			switch (tipo) {
			case "ADM":
				u = new Administrador(login, senha, email);
				if (id_endereco!=0) {
					u.setEndereco(id_endereco);
				}else {
					u.setEndereco(0);
				}
				break;

			case "Cliente":
				u = new Cliente(login, senha, email);
				if (id_endereco!=0) {
					u.setEndereco(id_endereco);
				}else {
					u.setEndereco(0);
				}
				break;
			
			case "Fornecedor":
				u = new Fornecedor(login, senha, email);
				if (id_endereco!=0) {
					u.setEndereco(id_endereco);
				}else {
					u.setEndereco(0);
				}
				break;
			
			}
			u.setId(id);
			data.add(u);	
		}
		
		this.conexao.close();
		
		return data;
		
	}
	
	public void setEndereco(Usuario usuario, Endereco endereco) throws SQLException {
		
		this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRES);
        this.preparedstatement = conexao.prepareStatement(SQLUtil.Usuarios.INSERT_ENDERECO);
        
        preparedstatement.setInt(1, endereco.getId());
        preparedstatement.setInt(2, usuario.getId());
        
        preparedstatement.execute();
        
        this.conexao.close();
		
	}
	
	public Usuario buscarUsuarioLoginSenha(String login, String senha) throws SQLException {
		Usuario u=null;
		
		this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRES);
		
		this.preparedstatement = conexao.prepareStatement(SQLUtil.Usuarios.BUSCAR_USUARIO_LOGIN_SENHA);
		
		preparedstatement.setString(1, login);
		preparedstatement.setString(2, senha);
		
		rs = preparedstatement.executeQuery();
		
		while (rs.next()) {
			int id = rs.getInt("id");
			String l = rs.getString("login");
			String s = rs.getString("senha");
			String email = rs.getString("email");
			int id_endereco = rs.getInt("endereco");
			String tipo = rs.getString("tipo");
			
			switch (tipo) {
			case "ADM":
				u = new Administrador(l, s, email);
				break;

			case "Cliente":
				u = new Cliente(l, s, email);
				break;
			
			case "Fornecedor":
				u = new Fornecedor(l, s, email);
				break;
			
			}
			u.setId(id);
			u.setEndereco(id_endereco);
		}
		
		this.conexao.close();
		
		return u;
	}
	
	public Usuario buscarUsuarioLogin(String login) throws SQLException {
		Usuario u=null;
		
		this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRES);
		
		this.preparedstatement = conexao.prepareStatement(SQLUtil.Usuarios.BUSCAR_USUARIO_LOGIN);
		
		preparedstatement.setString(1, login);
		
		rs = preparedstatement.executeQuery();
		
		while (rs.next()) {
			int id = rs.getInt("id");
			String l = rs.getString("login");
			String s = rs.getString("senha");
			String email = rs.getString("email");
			int id_endereco = rs.getInt("endereco");
			String tipo = rs.getString("tipo");
			
			switch (tipo) {
			case "ADM":
				u = new Administrador(l, s, email);
				break;

			case "Cliente":
				u = new Cliente(l, s, email);
				break;
			
			case "Fornecedor":
				u = new Fornecedor(l, s, email);
				break;
			
			}
			u.setId(id);
			u.setEndereco(id_endereco);
		}
		
		this.conexao.close();
		
		return u;
	}
	
	public Usuario buscarUsuarioID(int id) throws SQLException {
		Usuario u=null;
		
		this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRES);
		
		this.preparedstatement = conexao.prepareStatement(SQLUtil.Usuarios.BUSCAR_USUARIO_ID);
		
		preparedstatement.setInt(1, id);
		
		rs = preparedstatement.executeQuery();
		
		while (rs.next()) {
			int i = rs.getInt("id");
			String login = rs.getString("login");
			String senha = rs.getString("senha");
			String email = rs.getString("email");
			int id_endereco = rs.getInt("endereco");
			String tipo = rs.getString("tipo");
			
			switch (tipo) {
			case "ADM":
				u = new Administrador(login, senha, email);
				break;

			case "Cliente":
				u = new Cliente(login, senha, email);
				break;
			
			case "Fornecedor":
				u = new Fornecedor(login, senha, email);
				break;
			
			}
			u.setId(i);
			u.setEndereco(id_endereco);
		}
		
		this.conexao.close();
		
		return u;
	}
	
	
}
