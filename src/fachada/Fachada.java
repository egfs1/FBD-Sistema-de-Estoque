package fachada;

import java.sql.SQLException;

import business.BusinessEncomendas;
import business.BusinessEstoque;
import business.BusinessUsuarios;
import business.BusinessVendas;
import dao.DaoEncomendas;
import dao.DaoEstoque;
import dao.DaoUsuarios;
import dao.DaoVendas;
import model.Encomenda;
import model.Pedido;
import model.Produto;
import model.Usuario;

public class Fachada implements IFachada {
	
	private BusinessUsuarios businessUsuarios;
	private BusinessEstoque businessEstoque;
	private BusinessEncomendas businessEncomendas;
	private BusinessVendas businessVendas;
	
	
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
		
		businessUsuarios.getDao().criarTabela();
		businessEstoque.getDao().criarTabela();
		businessEncomendas.getDao().criarTabela();
		businessVendas.getDaoVendas().criarTabela();
		
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
	public boolean cadastrarUsuario(Usuario usuario)  {
		try {
			return this.businessUsuarios.cadastrarUsuario(usuario);
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public boolean existeUsuario(String login) {
		try {
			return this.businessUsuarios.existeUsuario(login);
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public void editarUsuario(Usuario usuario, String login, String senha) {
		this.businessUsuarios.editarUsuario(usuario, login, senha);
	}

	@Override
	public void deletarUsuario(Usuario usuario) {
		this.businessUsuarios.deletarUsuario(usuario);
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
	public boolean cadastrarProduto(Produto produto) {
		try {
			return this.businessEstoque.cadastrarProduto(produto);
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public boolean existeProduto(int id) {
		try {
			return this.businessEstoque.existeProduto(id);
		} catch (SQLException e) {
			return false;
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
	public boolean encomendarProduto(Encomenda encomenda) {
		try {
			return this.businessEncomendas.encomendarProduto(encomenda);
		} catch (SQLException e) {
			return false;
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
	
	
	//Vendas =====================================================================================================================================
	
	
	@Override
	public boolean addVendas(Pedido pedido) {
		try {
			return this.businessVendas.addVendas(pedido);
		} catch (SQLException e) {
			return false;
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
}
