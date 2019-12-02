package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import App.App;
import fachada.Fachada;
import model.Endereco;
import model.Produto;
import model.Usuario;
import sql.SQLConnection;
import sql.SQLUtil;

public class DaoEndereco implements IDaoEndereco {
	
	private Connection conexao;
	private PreparedStatement preparedstatement;
	private Statement statement;
	private ResultSet rs;
	
	public void criarTabela() {
		try {
		
			this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRES);
	        this.statement = conexao.createStatement();
	        
	        this.statement.executeQuery(SQLUtil.Endereco.CREATE_TABLE);
	        
	        this.conexao.close();
	        
			} catch(SQLException e) {
		}
	}
	
	@Override
	public void salvar(Endereco endereco) throws SQLException {
		this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRES);
        this.preparedstatement = conexao.prepareStatement(SQLUtil.Endereco.INSERT_ALL);
        
        preparedstatement.setString(1, endereco.getUsuario().getLogin());
        preparedstatement.setString(2, endereco.getPais());
        preparedstatement.setString(3, endereco.getEstado());
        preparedstatement.setString(4, endereco.getCidade());
        preparedstatement.setString(5, endereco.getBairro());
        preparedstatement.setString(6, endereco.getRua());
        preparedstatement.setInt(7, endereco.getNumero());
        
        
        preparedstatement.execute();
        
        this.conexao.close();
        
	}

	@Override
	public ArrayList<Endereco> dataEndereco() throws SQLException {
		ArrayList<Endereco>data = new ArrayList<>();
		
		this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRES);
		
		this.statement = conexao.createStatement();
		this.rs = statement.executeQuery(SQLUtil.Endereco.SELECT_ALL);
		
		while (rs.next()) {
			int id = rs.getInt("id");
			String usuario_login = rs.getString("usuario");
			String pais = rs.getString("pais");
			String estado = rs.getString("estado");
			String cidade = rs.getString("cidade");
			String bairro = rs.getString("bairro");
			String rua = rs.getString("rua");
			int numero = rs.getInt("numero");
			
			Usuario u = App.fachada.buscarUsuarioLogin(usuario_login);
			Endereco e = new Endereco(pais,estado, cidade, bairro, rua, numero);
			e.setId(id);
			e.setUsuario(u);
			data.add(e);	
		}
		
		this.conexao.close();
		
		return data;
	}

	@Override
	public ArrayList<Endereco> dataEnderecoBusca(String busca) throws SQLException {
		ArrayList<Endereco>data = new ArrayList<>();
		
		this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRES);
		
		try {
			
			this.preparedstatement = conexao.prepareStatement(SQLUtil.Endereco.BUSCA_ENDERECO_INT);
			preparedstatement.setInt(1, Integer.parseInt(busca));
			preparedstatement.setInt(2, Integer.parseInt(busca));
			
		}catch(Exception e) {
			this.preparedstatement = conexao.prepareStatement(SQLUtil.Endereco.BUSCA_ENDERECO_STRING);
			preparedstatement.setString(1, busca);
			preparedstatement.setString(2, busca);
			preparedstatement.setString(3, busca);
			preparedstatement.setString(4, busca);
			preparedstatement.setString(5, busca);
			preparedstatement.setString(6, busca);
		}
		
		rs = preparedstatement.executeQuery();
		
		while (rs.next()) {
			int id = rs.getInt("id");
			String usuario_login = rs.getString("usuario");
			String pais = rs.getString("pais");
			String estado = rs.getString("estado");
			String cidade = rs.getString("cidade");
			String bairro = rs.getString("bairro");
			String rua = rs.getString("rua");
			int numero = rs.getInt("numero");
			
			Usuario u = App.fachada.buscarUsuarioLogin(usuario_login);
			Endereco e = new Endereco(pais,estado, cidade, bairro, rua, numero);
			e.setId(id);
			e.setUsuario(u);
			data.add(e);	
		}
		
		this.conexao.close();
		
		return data;
	}

	public void delete(int id) throws SQLException {
		this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRES);
        this.preparedstatement = conexao.prepareStatement(SQLUtil.Endereco.DELETE);
        
        preparedstatement.setInt(1, id);
        
        preparedstatement.execute();
        
        this.conexao.close();
		
	}
	
	
	
}
