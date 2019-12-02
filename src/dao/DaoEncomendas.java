package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import App.App;
import fachada.Fachada;
import model.Encomenda;
import model.Fornecedor;
import sql.SQLConnection;
import sql.SQLUtil;

public class DaoEncomendas implements IDaoEncomendas {
	
	private Connection conexao;
	private PreparedStatement preparedstatement;
	private Statement statement;
	private ResultSet rs;
	
	public void criarTabela() {
		try {
		
			this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRES);
	        this.statement = conexao.createStatement();
	        
	        this.statement.executeQuery(SQLUtil.Encomendas.CREATE_TABLE);
	        
	        this.conexao.close();
	        
			} catch(SQLException e) {
		}
	}
	
	
	@Override
	public Encomenda salvar(Encomenda encomenda) throws SQLException {
		
		this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRES);
        this.preparedstatement = conexao.prepareStatement(SQLUtil.Encomendas.INSERT_ALL);
        
        preparedstatement.setString(1, encomenda.getFornecedor().getLogin());
        preparedstatement.setInt(2, encomenda.getId_produto());
        preparedstatement.setInt(3, encomenda.getQnt());
        preparedstatement.setDouble(4, encomenda.getValor());
        preparedstatement.setDate(5, encomenda.getData());
        
        preparedstatement.execute();
        
        this.conexao.close();
        
		return encomenda;
	}
	@Override
	public ArrayList<Encomenda> dataEncomendas() throws SQLException {
		ArrayList<Encomenda>data = new ArrayList<>();
		
		this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRES);
		
		this.statement = conexao.createStatement();
		this.rs = statement.executeQuery(SQLUtil.Encomendas.SELECT_ALL);
		
		while (rs.next()) {
			int id = rs.getInt("id");
			int id_produto = rs.getInt("id_produto");
			String fornecedor_string = rs.getString("fornecedor");
			int qnt = rs.getInt("qnt");
			double valor = rs.getDouble("valor");
			Date d = rs.getDate("data");
			
			Fornecedor fornecedor = (Fornecedor) App.fachada.buscarUsuarioLogin(fornecedor_string);
			
			
			Encomenda e = new Encomenda(fornecedor, id_produto, qnt, valor, d);
			e.setId(id);
			data.add(e);	
		}
		
		this.conexao.close();
		
		return data;
	}
	@Override
	public ArrayList<Encomenda> dataEncomendasFornecedor(Fornecedor fornecedor) throws SQLException {
		ArrayList<Encomenda>data = new ArrayList<>();
		
		this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRES);
		
		this.preparedstatement = conexao.prepareStatement(SQLUtil.Encomendas.SELECT_FORNECEDOR);
		
		this.preparedstatement.setString(1, fornecedor.getLogin());
		
		this.rs = preparedstatement.executeQuery();
		
		while (rs.next()) {
			int id = rs.getInt("id");
			int id_produto = rs.getInt("id_produto");
			int qnt = rs.getInt("qnt");
			double valor = rs.getDouble("valor");
			Date d = rs.getDate("data");
			
			
			Encomenda e = new Encomenda(fornecedor, id_produto, qnt, valor, d);
			e.setId(id);
			data.add(e);	
		}
		
		this.conexao.close();
		
		return data;
	}
	@Override
	public void deletarEncomendaFornecedor(String fornecedor) throws SQLException {
		
		this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRES);
        this.preparedstatement = conexao.prepareStatement(SQLUtil.Encomendas.DELETE_ENCOMENDA_FORNECEDOR);
        
        preparedstatement.setString(1, fornecedor);
        
        preparedstatement.execute();
        
        this.conexao.close();
		
	}
	@Override
	public void deletarEncomendaProduto(int id_produto) throws SQLException {
		
		this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRES);
        this.preparedstatement = conexao.prepareStatement(SQLUtil.Encomendas.DELETE_ENCOMENDA_PRODUTO);
        
        preparedstatement.setInt(1, id_produto);
        
        preparedstatement.execute();
        
        this.conexao.close();
		
	}


	@Override
	public ArrayList<Encomenda> dataEncomendasBusca(String busca) throws SQLException {
		ArrayList<Encomenda>data = new ArrayList<>();
		
		this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRES);
		
		try {
			
			this.preparedstatement = conexao.prepareStatement(SQLUtil.Encomendas.BUSCAR_ENCOMENDA_INT);
			preparedstatement.setInt(1, Integer.parseInt(busca));
			preparedstatement.setInt(2, Integer.parseInt(busca));
			
			
		}catch(Exception e) {
			this.preparedstatement = conexao.prepareStatement(SQLUtil.Encomendas.BUSCAR_ENCOMENDA_STRING);
			preparedstatement.setString(1, busca);
		}
		
		
		rs = preparedstatement.executeQuery();
		
		while (rs.next()) {
			int id = rs.getInt("id");
			int id_produto = rs.getInt("id_produto");
			String fornecedor_string = rs.getString("fornecedor");
			int qnt = rs.getInt("qnt");
			double valor = rs.getDouble("valor");
			Date d = rs.getDate("data");
			
			Fornecedor fornecedor = (Fornecedor) App.fachada.buscarUsuarioLogin(fornecedor_string);
			
			
			Encomenda e = new Encomenda(fornecedor, id_produto, qnt, valor, d);
			e.setId(id);
			data.add(e);	
		}
		
		this.conexao.close();
		
		return data;
	}
	
	
	
}
