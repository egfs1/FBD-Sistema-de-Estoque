package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import fachada.Fachada;
import java.sql.Date;
import model.Cliente;
import model.Pedido;
import sql.SQLConnection;
import sql.SQLUtil;

public class DaoVendas implements IDaoVendas {

	private Connection conexao;
	private PreparedStatement preparedstatement;
	private Statement statement;
	private ResultSet rs;
	
	public void criarTabela() {
		try {
			
			this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRES);
	        this.statement = conexao.createStatement();
	        
	        this.statement.executeQuery(SQLUtil.Vendas.CREATE_TABLE);
	        
	        this.conexao.close();
	        
			} catch(SQLException e) {
				
		}
	}
	
	@Override
	public Pedido salvar(Pedido pedido) throws SQLException {
		
		this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRES);
        this.preparedstatement = conexao.prepareStatement(SQLUtil.Vendas.INSERT_ALL);
        
        preparedstatement.setString(1, pedido.getCliente().getLogin());
        preparedstatement.setInt(2,pedido.getId_produto());
        preparedstatement.setInt(3, pedido.getQnt());
        preparedstatement.setDouble(4, pedido.getValor());
        preparedstatement.setDate(5, pedido.getData());
        
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
			double valor = rs.getDouble("valor");
			Date d = rs.getDate("data");
			
			Cliente cliente = (Cliente) Fachada.getInstance().buscarUsuarioLogin(cliente_string);
			
			Pedido p = new Pedido(cliente, id_produto, qnt, valor, d);
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
			double valor = rs.getDouble("valor");
			Date d = rs.getDate("data");
			
			Pedido p = new Pedido(cliente, id_produto, qnt, valor, d);
			p.setId(id);
			data.add(p);	
		}
		
		this.conexao.close();
		
		return data;
		

	}
	@Override
	public void deletarPedidoCliente(String cliente) throws SQLException {
		
		this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRES);
        this.preparedstatement = conexao.prepareStatement(SQLUtil.Vendas.DELETE_PEDIDO_CLIENTE);
        
        preparedstatement.setString(1, cliente);
        
        preparedstatement.execute();
        
        this.conexao.close();
	}
	
	@Override
	public void deletarPedidoProduto(int id_produto) throws SQLException {
		
		this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRES);
        this.preparedstatement = conexao.prepareStatement(SQLUtil.Vendas.DELETE_PEDIDO_PRODUTO);
        
        preparedstatement.setInt(1, id_produto);
        
        preparedstatement.execute();
        
        this.conexao.close();
	}

	@Override
	public ArrayList<Pedido> dataVendasBusca(String busca) throws SQLException {
		ArrayList<Pedido>data = new ArrayList<>();
		
		this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRES);
		
		try {
			
			this.preparedstatement = conexao.prepareStatement(SQLUtil.Vendas.BUSCAR_VENDA_INT);
			preparedstatement.setInt(1, Integer.parseInt(busca));
			preparedstatement.setInt(2, Integer.parseInt(busca));
			
			
		}catch(Exception e) {
			this.preparedstatement = conexao.prepareStatement(SQLUtil.Vendas.BUSCAR_VENDA_STRING);
			preparedstatement.setString(1, busca);
		}
		
		
		rs = preparedstatement.executeQuery();
	
		while (rs.next()) {
			int id = rs.getInt("id");
			int id_produto = rs.getInt("id_produto");
			String cliente_string = rs.getString("cliente");
			int qnt = rs.getInt("qnt");
			double valor = rs.getDouble("valor");
			Date d = rs.getDate("data");
			
			Cliente cliente = (Cliente) Fachada.getInstance().buscarUsuarioLogin(cliente_string);
			
			Pedido p = new Pedido(cliente, id_produto, qnt, valor, d);
			p.setId(id);
			data.add(p);	
		}
		
		this.conexao.close();
		
		return data;
	}
	
	
	
	
}
