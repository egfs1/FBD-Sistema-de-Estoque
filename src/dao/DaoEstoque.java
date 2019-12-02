package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Produto;
import sql.SQLConnection;
import sql.SQLUtil;

public class DaoEstoque implements IDaoEstoque {
	
	private Connection conexao;
	private PreparedStatement preparedstatement;
	private Statement statement;
	private ResultSet rs;
	
	public void criarTabela() {
		try {
			
			this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRES);
	        this.statement = conexao.createStatement();
	        
	        this.statement.executeQuery(SQLUtil.Estoque.CREATE_TABLE);
	        
	        this.conexao.close();
	        
			} catch(SQLException e) {
		}
		
	}
	
	
	
	@Override
	public Produto salvar(Produto produto) throws SQLException {
		
		this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRES);
        this.preparedstatement = conexao.prepareStatement(SQLUtil.Estoque.INSERT_ALL);
        
        preparedstatement.setString(1, produto.getNome());
        preparedstatement.setDouble(2, produto.getValor_encomenda());
        preparedstatement.setDouble(3, produto.getValor_venda());
        preparedstatement.setInt(4,produto.getQnt());
        
        preparedstatement.execute();
        
        this.conexao.close();
        
		return produto;
	}


	@Override
	public void adicionarQnt(Produto produto, int qnt) throws SQLException {
		
		this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRES);
        this.preparedstatement = conexao.prepareStatement(SQLUtil.Estoque.ADD_QNT);
        
        preparedstatement.setInt(1, qnt);
        preparedstatement.setInt(2, produto.getId());
		
        preparedstatement.execute();
        
        this.conexao.close();
        
	}
	
	public void removerQnt(Produto produto, int qnt) throws SQLException {
		
		this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRES);
        this.preparedstatement = conexao.prepareStatement(SQLUtil.Estoque.REMOVER_QNT);
        
        preparedstatement.setInt(1, qnt);
        preparedstatement.setInt(2, produto.getId());
		
        preparedstatement.execute();
        
        this.conexao.close();
	}


	@Override
	public ArrayList<Produto> dataEstoque() throws SQLException {
		ArrayList<Produto>data = new ArrayList<>();
		
		this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRES);
		
		this.statement = conexao.createStatement();
		this.rs = statement.executeQuery(SQLUtil.Estoque.SELECT_ALL);
		
		while (rs.next()) {
			int id = rs.getInt("id");
			String nome = rs.getString("nome");
			double valor_encomenda = rs.getDouble("valor_encomenda");
			double valor_venda = rs.getDouble("valor_venda");
			int qnt = rs.getInt("qnt");
			
			Produto p = new Produto(nome, valor_encomenda, valor_venda);
			p.setId(id);
			p.setQnt(qnt);
			data.add(p);	
		}
		
		this.conexao.close();
		
		return data;
	}


	@Override
	public void delete(Produto produto) throws SQLException {
		
		this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRES);
        this.preparedstatement = conexao.prepareStatement(SQLUtil.Estoque.DELETE_PRODUTO);
        
        preparedstatement.setInt(1, produto.getId());
		
        preparedstatement.execute();
        
        this.conexao.close();
		
		
	}


	@Override
	public void edit(Produto produto, String login, double valor_encomenda, double valor_venda) throws SQLException {
		
		this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRES);
        this.preparedstatement = conexao.prepareStatement(SQLUtil.Estoque.EDIT_PRODUTO);
        
        preparedstatement.setString(1, login);
        preparedstatement.setDouble(2, valor_encomenda);
        preparedstatement.setDouble(3, valor_venda);
        preparedstatement.setInt(4, produto.getId());
		
        preparedstatement.execute();
        
        this.conexao.close();
		
	}



	@Override
	public ArrayList<Produto> dataEstoqueBusca(String busca) throws SQLException {
		ArrayList<Produto>data = new ArrayList<>();
		
		this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRES);
		
		try {
			
			this.preparedstatement = conexao.prepareStatement(SQLUtil.Estoque.BUSCAR_PRODUTO_INT);
			preparedstatement.setInt(1, Integer.parseInt(busca));
			
			
		}catch(Exception e) {
			this.preparedstatement = conexao.prepareStatement(SQLUtil.Estoque.BUSCAR_PRODUTO_STRING);
			preparedstatement.setString(1, busca);
		}
		
		rs = preparedstatement.executeQuery();
		
		while (rs.next()) {
			int id = rs.getInt("id");
			String nome = rs.getString("nome");
			double valor_encomenda = rs.getDouble("valor_encomenda");
			double valor_venda = rs.getDouble("valor_venda");
			int qnt = rs.getInt("qnt");
			
			Produto p = new Produto(nome, valor_encomenda, valor_venda);
			p.setId(id);
			p.setQnt(qnt);
			data.add(p);	
		}
		
		this.conexao.close();
		
		return data;
		
		
	}
	
	
	
	
	
	
	
	
}
