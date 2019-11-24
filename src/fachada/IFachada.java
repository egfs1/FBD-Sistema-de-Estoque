package fachada;


import model.Encomenda;
import model.Pedido;
import model.Produto;
import model.Usuario;

public interface IFachada {
	
	//Usuarios
	public Usuario verificarLogin(String login, String senha);
	
	public Usuario buscarUsuarioLogin(String login);
	
	public Usuario buscarUsuarioID(int id);
	
	public boolean cadastrarUsuario(Usuario usuario);
	
	public boolean existeUsuario(String login);
	
	public void editarUsuario(Usuario usuario, String login, String senha);
	
	public void deletarUsuario(Usuario usuario);
	
	public String[][] dataUsuarios();
	
	public String[] colunasUsuarios();
	
	//Estoque
	public Produto buscarProdutoID(int id);
	
	public boolean cadastrarProduto(Produto produto) ;
	
	public boolean existeProduto(int id);
	
	public void editarProduto(Produto produto, String login);
	
	public void deletarProduto(Produto produto) ;
	
	public String[][] dataEstoque() ;
	
	public String[] colunasEstoque();
	
	//Encomendas
	public boolean encomendarProduto(Encomenda encomenda);
	
	public String[][] dataEncomendas();
	
	public String[] colunasEncomenda();
	
	//Vendas
	public boolean addVendas(Pedido pedido);
	
	public String[][] dataVendas();
	
	public String[] colunasVendas();
	
	
}
