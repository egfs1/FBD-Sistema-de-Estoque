package fachada;

import java.sql.SQLException;

import App.App;
import business.BusinessEncomendas;
import business.BusinessEndereco;
import business.BusinessEstoque;
import business.BusinessUsuarios;
import business.BusinessVendas;
import dao.DaoEncomendas;
import dao.DaoEndereco;
import dao.DaoEstoque;
import dao.DaoUsuarios;
import dao.DaoVendas;
import model.Encomenda;
import model.Endereco;
import model.Pedido;
import model.Produto;
import model.Usuario;

public class Fachada implements IFachada {
	
	private BusinessUsuarios businessUsuarios;
	private BusinessEstoque businessEstoque;
	private BusinessEncomendas businessEncomendas;
	private BusinessVendas businessVendas;
	private BusinessEndereco businessEndereco;
	
	
	private static Fachada fachada;
	
	public static Fachada getInstance() {
		
		if (fachada==null) {
			fachada = new Fachada();
		}
		
		return fachada;
	}
	
	private Fachada() {
		
		businessUsuarios = new BusinessUsuarios();
		businessEstoque = new BusinessEstoque();
		businessEncomendas = new BusinessEncomendas();
		businessVendas = new BusinessVendas();
		businessEndereco = new BusinessEndereco();
		
		businessUsuarios.getDao().criarTabela();
		businessEstoque.getDao().criarTabela();
		businessEncomendas.getDao().criarTabela();
		businessVendas.getDaoVendas().criarTabela();
		businessEndereco.getDao().criarTabela();
		
	}
	
	
	//Usuarios =====================================================================================================================================
	
	
	@Override
	public Usuario verificarLogin(String login, String senha){
		try {
			return this.businessUsuarios.verificarLogin(login, senha);
		} catch (SQLException e) {
			System.out.println("ERRO AO VERIFICAR O LOGIN");
			return null;
		}
	}

	@Override
	public Usuario buscarUsuarioLogin(String login) {
		try {
			return this.businessUsuarios.buscarUsuarioLogin(login);
		} catch (SQLException e) {
			System.out.println("ERRO AO BUSCAR USUARIO PELO LOGIN");
			return null;
		}
	}

	@Override
	public Usuario buscarUsuarioID(int id)  {
		try {
			return this.businessUsuarios.buscarUsuarioID(id);
		} catch (SQLException e) {
			System.out.println("ERRO AO BUSCAR USUARIO PELO ID");
			return null;
		}
	}

	@Override
	public void cadastrarUsuario(Usuario usuario, Endereco endereco)  {
		try {
			this.businessUsuarios.cadastrarUsuario(usuario);
			cadastrarEndereco(endereco);
			Usuario user = buscarUsuarioLogin(usuario.getLogin());
			setEndereco(user, App.fachada.buscarEndereco(user.getLogin()));
			
		} catch (SQLException e) {
		}
	}


	@Override
	public void editarUsuario(Usuario usuario, String login, String senha, String email) {
		try {
			this.businessUsuarios.editarUsuario(usuario, login, senha, email);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void setEndereco(Usuario usuario, Endereco endereco) {
		try {
			this.businessUsuarios.setEndereco(usuario, endereco);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void deletarUsuario(Usuario usuario) {
		try {
			this.businessUsuarios.deletarUsuario(usuario);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String[][] dataUsuarios() {
		try {
			return this.businessUsuarios.dataUsuarios();
		} catch (SQLException e) {
			return null;
		}
	}
	
	@Override
	public String[][] dataUsuariosBusca(String busca) {
		try {
			return this.businessUsuarios.dataUsuariosBusca(busca);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public String[] colunasUsuarios() {
		return this.businessUsuarios.colunasUsuarios();
	}
	
	public DaoUsuarios getDaoUsuarios() {
		return this.businessUsuarios.getDao();
	}

	
	//Estoque =====================================================================================================================================
	
	
	@Override
	public Produto buscarProdutoID(int id) {
		try {
			return this.businessEstoque.buscarProdutoID(id);
		} catch (SQLException e) {
			return null;
		}
	}

	@Override
	public void cadastrarProduto(Produto produto) {
		try {
			this.businessEstoque.cadastrarProduto(produto);
		} catch (SQLException e) {
		}
	}


	@Override
	public void editarProduto(Produto produto, String login, double valor_encomenda, double valor_venda) {
		try {
			this.businessEstoque.editarProduto(produto, login, valor_encomenda, valor_venda);
		} catch (SQLException e) {
		}
		
	}

	@Override
	public void deletarProduto(Produto produto) {
		try {
			this.businessEstoque.deletarProduto(produto);
		} catch (SQLException e) {
		}
		
	}

	@Override
	public String[][] dataEstoque() {
		try {
			return this.businessEstoque.dataEstoque();
		} catch (SQLException e) {
			return null;
		}
	}
	
	@Override
	public String[][] dataEstoqueBusca(String busca) {
		try {
			return this.businessEstoque.dataEstoqueBusca(busca);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public String[] colunasEstoque() {
		return this.businessEstoque.colunasEstoque();
	}
	
	public DaoEstoque getDaoEstoque() {
		return this.businessEstoque.getDao();
	}
	
	
	//Encomendas =====================================================================================================================================
	
	
	@Override
	public void encomendarProduto(Encomenda encomenda) {
		try {
			this.businessEncomendas.encomendarProduto(encomenda);
		} catch (SQLException e) {
		}
	}

	@Override
	public String[][] dataEncomendas()  {
		try {
			return this.businessEncomendas.dataEncomendas();
		} catch (SQLException e) {
			return null;
		}
	}

	@Override
	public String[] colunasEncomenda() {
		return this.businessEncomendas.colunasEncomenda();
	}
	
	@Override
	public String relatorioEncomendas(){
		try {
			return this.businessEncomendas.relatorioEncomendas();
		} catch (SQLException e) {
			return null;
		}
	}
	
	public DaoEncomendas getDaoEncomendas() {
		return businessEncomendas.getDao();
	}

	@Override
	public double valorTotalEncomendas() {
		try {
			return this.businessEncomendas.valorTotalEncomendas();
		} catch (SQLException e) {
			return 0;
		}
	}
	
	@Override
	public String[][] dataEncomendasBusca(String busca) {
		try {
			return businessEncomendas.dataEncomendasBusca(busca);
		} catch (SQLException e) {
			return null;
		}
	}
	
	@Override
	public void updateFornecedor(String login_novo, String login_antigo) {
		try {
			this.businessEncomendas.updateFornecedor(login_novo, login_antigo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	//Vendas =====================================================================================================================================
	
	
	@Override
	public void addVendas(Pedido pedido) {
		try {
			this.businessVendas.addVendas(pedido);
		} catch (SQLException e) {
		}
	}

	@Override
	public String[][] dataVendas() {
		try {
			return this.businessVendas.dataVendas();
		} catch (SQLException e) {
			return null;
		}
	}
	
	@Override
	public String[][] dataVendasBusca(String busca) {
		try {
			return this.businessVendas.dataVendasBusca(busca);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String[] colunasVendas() {
		return this.businessVendas.colunasVendas();
	}
	
	public DaoVendas getDaoVendas() {
		return this.businessVendas.getDaoVendas();
	}

	@Override
	public String relatorioVendas(){
		try {
			return this.businessVendas.relatorioVendas();
		} catch (SQLException e) {
			return null;
		}
	}

	@Override
	public double valorTotalVendas(){
		try {
			return this.businessVendas.valorTotalVendas();
		} catch (SQLException e) {
			return 0;
		}
	}
	
	@Override
	public void updateCliente(String login_novo, String login_antigo) {
		try {
			this.businessVendas.updateCliente(login_novo, login_antigo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//Endereco =====================================================================================================================================

	@Override
	public void cadastrarEndereco(Endereco endereco) {
		try {
			this.businessEndereco.cadastrarEndereco(endereco);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Endereco buscarEndereco(String login_usuario) {
		try {
			return this.businessEndereco.buscarEndereco(login_usuario);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String[][] dataEndereco() {
		try {
			return this.businessEndereco.dataEndereco();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String[][] dataEnderecoBusca(String busca) {
		try {
			return this.businessEndereco.dataEnderecoBusca(busca);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String[] colunasEndereco() {
		return this.businessEndereco.colunasEndereco();
	}

	@Override
	public void deletarEndereco(int id) {
		try {
			this.businessEndereco.deletarEndereco(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public DaoEndereco getDaoEndereco() {
		return this.businessEndereco.getDao();
	}

	@Override
	public void updateUsuario(String login_usuario, int id) {
		try {
			this.businessEndereco.updateUsuario(login_usuario, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
