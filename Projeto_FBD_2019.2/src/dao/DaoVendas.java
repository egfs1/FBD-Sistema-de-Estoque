package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.BaseDados;
import model.Cliente;
import model.Pedido;
import model.Produto;
import sql.SQLConnection;
import sql.SQLUtil;

public class DaoVendas implements IDaoVendas {

	private Connection conexao;
	private PreparedStatement preparedstatement;
	private Statement statement;
	private ResultSet rs;
	
	
	
	@Override
	public Pedido salvar(Pedido pedido) throws SQLException {
		
		this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRES);
        this.preparedstatement = conexao.prepareStatement(SQLUtil.Vendas.INSERT_ALL);
        
        preparedstatement.setInt(1, pedido.getId_produto());
        preparedstatement.setString(2,pedido.getCliente().getLogin());
        preparedstatement.setInt(3, pedido.getQnt());
        
        preparedstatement.execute();
        
        this.conexao.close();
        
		return pedido;
	}
	@Override
	public ArrayList<Pedido> dataVendas() throws SQLException {
		
		ArrayList<Pedido>data = new ArrayList<>();
		
		this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRES);
		
		this.statement = conexao.createStatement();
		this.rs = statement.executeQuery(SQLUtil.Vendas.SELECT_ALL);
		
		while (rs.next()) {
			int id = rs.getInt("id");
			int id_produto = rs.getInt("id_produto");
			String cliente_string = rs.getString("cliente");
			int qnt = rs.getInt("qnt");
			Cliente cliente = (Cliente) BaseDados.buscarUsuario_login(cliente_string);
			
			
			Pedido p = new Pedido(id_produto, qnt, cliente);
			p.setId(id);
			data.add(p);	
		}
		
		this.conexao.close();
		
		return data;
	}
	
	
	
	@Override
	public ArrayList<Pedido> dataVendasCliente(Cliente cliente) throws SQLException {
		ArrayList<Pedido>data = new ArrayList<>();
		
		this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRES);
		
		this.preparedstatement = conexao.prepareStatement(SQLUtil.Vendas.SELECT_CLIENTE);
		
		preparedstatement.setString(1, cliente.getLogin());
		
		this.rs = preparedstatement.executeQuery();
		
		while (rs.next()) {
			int id = rs.getInt("id");
			int id_produto = rs.getInt("id_produto");
			int qnt = rs.getInt("qnt");
			
			Pedido p = new Pedido(id_produto, qnt, cliente);
			p.setId(id);
			data.add(p);	
		}
		
		this.conexao.close();
		
		return data;
		

	}
	
	
	
	
}
