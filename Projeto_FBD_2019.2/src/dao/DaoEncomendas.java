package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.BaseDados;
import model.Encomenda;
import model.Fornecedor;
import sql.SQLConnection;
import sql.SQLUtil;

public class DaoEncomendas implements IDaoEncomendas {
	
	private Connection conexao;
	private PreparedStatement preparedstatement;
	private Statement statement;
	private ResultSet rs;
	
	
	
	@Override
	public Encomenda salvar(Encomenda encomenda) throws SQLException {
		
		this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRES);
        this.preparedstatement = conexao.prepareStatement(SQLUtil.Encomendas.INSERT_ALL);
		
        preparedstatement.setInt(1, encomenda.getId_produto());
        preparedstatement.setString(2, encomenda.getFornecedor().getLogin());
        preparedstatement.setInt(3, encomenda.getQnt());
        
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
			
			Fornecedor fornecedor = (Fornecedor) BaseDados.buscarUsuario_login(fornecedor_string);
			
			
			Encomenda e = new Encomenda(id_produto, qnt, fornecedor);
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
		
		this.statement = conexao.createStatement();
		this.rs = statement.executeQuery(SQLUtil.Encomendas.SELECT_ALL);
		
		while (rs.next()) {
			int id = rs.getInt("id");
			int id_produto = rs.getInt("id_produto");
			String fornecedor_string = rs.getString("fornecedor");
			int qnt = rs.getInt("qnt");
			
			Fornecedor f = (Fornecedor) BaseDados.buscarUsuario_login(fornecedor_string);
			
			if (fornecedor.equals(f)) {
				Encomenda e = new Encomenda(id_produto, qnt, fornecedor);
				e.setId(id);
				data.add(e);	
			}
		}
		
		this.conexao.close();
		
		return data;
	}
	
	
	
}
