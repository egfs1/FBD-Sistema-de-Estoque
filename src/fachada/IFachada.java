package fachada;


import java.sql.SQLException;

import model.Encomenda;
import model.Endereco;
import model.Pedido;
import model.Produto;
import model.Usuario;

public interface IFachada {
	
	//Usuarios
	public Usuario verificarLogin(String login, String senha);
	
	public Usuario buscarUsuarioLogin(String login);
	
	public Usuario buscarUsuarioID(int id);
	
	public void cadastrarUsuario(Usuario usuario, Endereco endereco);
	
	public void editarUsuario(Usuario usuario, String login, String senha, String email);
	
	public void setEndereco(Usuario usuario, Endereco endereco);
	
	public void deletarUsuario(Usuario usuario);
	
	public String[][] dataUsuarios();
	
	public String[][] dataUsuariosBusca(String busca);
	
	public String[] colunasUsuarios();
	
	//Estoque
	public Produto buscarProdutoID(int id);
	
	public void cadastrarProduto(Produto produto) ;
	
	public void editarProduto(Produto produto, String login, double valor_encomenda, double valor_venda);
	
	public void deletarProduto(Produto produto) ;
	
	public String[][] dataEstoque() ;
	
	public String[][] dataEstoqueBusca(String busca);
	
	public String[] colunasEstoque();
	
	//Encomendas
	public void encomendarProduto(Encomenda encomenda);
	
	public void updateFornecedor(String login_novo, String login_antigo);
	
	public String[][] dataEncomendas();
	
	public String[] colunasEncomenda();
	
	public String relatorioEncomendas();
	
	public double valorTotalEncomendas();
	
	public String[][] dataEncomendasBusca(String busca);
	
	//Vendas
	public void addVendas(Pedido pedido);
	
	public void updateCliente(String login_novo, String login_antigo);
	
	public String[][] dataVendas();
	
	public String[][] dataVendasBusca(String busca);
	
	public String[] colunasVendas();
	
	public String relatorioVendas();
	
	public double valorTotalVendas();
	
	//Endereco
	public void cadastrarEndereco(Endereco endereco);
	
	public Endereco buscarEndereco(String login_usuario);
	
	public void updateUsuario(String login_usuario, int id);
	
	public String[][] dataEndereco();
	
	public String[][] dataEnderecoBusca(String busca);
	
	public String[] colunasEndereco();
	
	public void deletarEndereco(int id);
	
	
}
