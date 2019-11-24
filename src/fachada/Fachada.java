package fachada;

import java.sql.SQLException;

import business.BusinessEncomendas;
import business.BusinessEstoque;
import business.BusinessUsuarios;
import business.BusinessVendas;
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
		
		
	}
	
	
	//Usuarios =====================================================================================================================================
	
	
	@Override
	public Usuario verificarLogin(String login, String senha){
		try {
			return this.businessUsuarios.verificarLogin(login, senha);
		} catch (SQLException e) {
			return null;
		}
	}

	@Override
	public Usuario buscarUsuarioLogin(String login) {
		try {
			return this.businessUsuarios.buscarUsuarioLogin(login);
		} catch (SQLException e) {
			return null;
		}
	}

	@Override
	public Usuario buscarUsuarioID(int id)  {
		try {
			return this.businessUsuarios.buscarUsuarioID(id);
		} catch (SQLException e) {
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
	public void editarProduto(Produto produto, String login) {
		try {
			this.businessEstoque.editarProduto(produto, login);
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
	public String[] colunasVendas() {
		return this.businessVendas.colunasVendas();
	}
	
	public DaoVendas getDaoVendas() {
		return this.businessVendas.getDaoVendas();
	}
}
