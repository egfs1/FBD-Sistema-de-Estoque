package model;

import java.sql.SQLException;
import java.util.ArrayList;


import controller.ControllerTelaAdministrador;
import dao.DaoEncomendas;
import dao.DaoEstoque;
import dao.DaoUsuarios;
import dao.DaoVendas;
import view.TelaAdministrador;
import view.TelaMensagem;

public class BaseDados {
	
	public static DaoEstoque daoEstoque = new DaoEstoque();
	public static DaoUsuarios daoUsuarios = new DaoUsuarios();
	public static DaoEncomendas daoEncomendas = new DaoEncomendas();
	public static DaoVendas daoVendas = new DaoVendas();
	
	private static ArrayList<Produto>estoque;
	private static ArrayList<Usuario>usuarios;
	private static ArrayList<Pedido>vendas;
	
	private static ArrayList<Encomenda>encomendas = new ArrayList<>();
	
	public static void atualizarDataEstoque() throws SQLException {
		estoque = daoEstoque.dataEstoque();
	}
	
	public static void atualizarDataUsuarios() throws SQLException {
		usuarios = daoUsuarios.dataUsuarios();
	}
	
	public static void atualizarDataEncomendas() throws SQLException {
		encomendas = daoEncomendas.dataEncomendas();
	}
	
	public static void atualizarDataVendas() throws SQLException {
		vendas = daoVendas.dataVendas();
	}
	
	
	
	public static Usuario buscarUsuario_login_senha(String login, String senha) {
		for (Usuario u: usuarios) {
			if (u.getLogin().equals(login) && u.getSenha().equals(senha)){
				return u;
			}
		}
		TelaMensagem.mensagem("Login ou senha incorretos!");
		return null;
		
	}
	
	public static Usuario buscarUsuario_login(String login) {
		for (Usuario u: usuarios) {
			if (u.getLogin().equals(login)) {
				return u;
			}
		}
		return null;
	}
	
	public static Usuario buscarUsuario_id(int id) {
		for (Usuario u: usuarios) {
			if (u.getId()==id) {
				return u;
			}
		}
		return null;
	}
	
	public static Produto buscarProduto_id(int id) {
		for(Produto p: estoque) {
			if (p.getId()==id) {
				return p;
			}
		}
		return null;
	}
	
	
	public static boolean cadastrarUsuario(Usuario usuario) throws SQLException {
		
		if (!existeUsuario(usuario)) {
			
			daoUsuarios.salvar(usuario);
			atualizarDataUsuarios();
			
			TelaMensagem.mensagem("Usuario cadastrado com sucesso!");
			ControllerTelaAdministrador.atualizarTelaCadastrarUsuario();
			return true;
		}
		TelaMensagem.mensagem("Esse Usuario já existe!");
		return false;
	}
	
	public static boolean existeUsuario(Usuario usuario) {
		for (Usuario u: usuarios) {
			if (u.getLogin().equalsIgnoreCase(usuario.getLogin()))
				return true;
		}
		return false;
	}
	
	public static boolean existeUsuario(String login) {
		for (Usuario u: usuarios) {
			if (u.getLogin().equalsIgnoreCase(login))
				return true;
		}
		return false;
	}
	
	public static boolean cadastrarProduto(Produto p) {
		for (Produto produto: estoque) {
			if (produto.getNome().equalsIgnoreCase(p.getNome())){
				TelaMensagem.mensagem("Já existe um produto com esse nome!");
				return false;
			}
		}
		TelaMensagem.mensagem("Produto cadastrado com sucesso!");
		try {
			daoEstoque.salvar(p);
			atualizarDataEstoque();
			ControllerTelaAdministrador.atualizarUsuarios();
			ControllerTelaAdministrador.atualizarTelaCadastrarUsuario();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
		
	}
	
	public static boolean existeProduto(int id) {
		for (Produto p: estoque) {
			if (p.getId()==id) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean encomendarProduto(Encomenda encomenda) {
		if (existeProduto(encomenda.getId_produto())) {
			for (Produto p: estoque) {
				if (p.getId()==encomenda.getId_produto()) {
					TelaMensagem.mensagem("Compra realizada com sucesso!");
					
					try {
						daoEstoque.adicionarQnt(p, encomenda.getQnt());
						daoEncomendas.salvar(encomenda);
						
						atualizarDataEstoque();
						atualizarDataEncomendas();
						
						ControllerTelaAdministrador.atualizarEncomendas();
						ControllerTelaAdministrador.atualizarTelaEncomendarProduto();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					
					return true;
				}
				
			}
			return false;
		}
		else {
			TelaMensagem.mensagem("Esse produto não existe!");
			return false;
		}
	}
	
	public static boolean addPedido(Pedido pedido) {
		if (!existeProduto(pedido.getId_produto())) {
			TelaMensagem.mensagem("Esse produto não existe!");
			return false;
		}
		
		for (Produto p: estoque) {
			if (p.getId()==pedido.getId_produto()) {
				if (p.getQnt() - pedido.getQnt() < 0) {
					TelaMensagem.mensagem("Não existe essa quantidade no estoque!");
					return false;
				}
				else {
					try {
						daoEstoque.removerQnt(p, pedido.getQnt());
						daoVendas.salvar(pedido);
						
						pedido.getCliente().atualizarDataPedidos();
						atualizarDataEstoque();
						atualizarDataVendas();
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
					
					TelaMensagem.mensagem("Pedido Realizado com sucesso!");
					return true;
				}
			}
			
		}
		return false;
	}
	
	public static void editarProduto(Produto produto, String login) {
		try {
			daoEstoque.edit(produto, login);
			atualizarDataEstoque();
			ControllerTelaAdministrador.atualizarEstoque();
			ControllerTelaAdministrador.atualizarTelaEditProduto();
			TelaMensagem.mensagem("Modificação Salva com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void deletarProduto(Produto produto) {
		try {
			daoEstoque.delete(produto);
			atualizarDataEstoque();
			ControllerTelaAdministrador.atualizarEstoque();
			ControllerTelaAdministrador.atualizarTelaEditProduto();
			TelaMensagem.mensagem("Produto Deletado com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void editarUsuario(Usuario usuario, String login, String senha) {
		try {
			daoUsuarios.edit(usuario, login, senha);
			atualizarDataUsuarios();
			ControllerTelaAdministrador.atualizarUsuarios();;
			ControllerTelaAdministrador.atualizarTelaEditUsuario();
			TelaMensagem.mensagem("Modificação Salva com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void deletarUsuario(Usuario usuario) {
		try {
			daoUsuarios.deletar(usuario);
			atualizarDataUsuarios();
			ControllerTelaAdministrador.atualizarUsuarios();;
			ControllerTelaAdministrador.atualizarTelaEditUsuario();
			TelaMensagem.mensagem("Usuario Deletado com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
//	==========================================================================================================================================
//	Dados das Tabelas
	
	
	public static String[][] dadosEstoque() {
		String[][] s = new String[estoque.size()][3];
		
		int contador = 0;
		for (Produto p: estoque) {
			s[estoque.indexOf(p)][contador] = String.valueOf(p.getId());
			contador++;
			s[estoque.indexOf(p)][contador] = p.getNome();
			contador++;
			s[estoque.indexOf(p)][contador] = String.valueOf(p.getQnt());
			contador=0;
			
		}
		
		return s;
	}
	
	public static String[] colunasEstoque() {
		String []s = {"ID", "Nome", "Qnt"};
		return s;
	}
	
	public static String [][] dadosEncomendas() {
		String[][] s = new String[encomendas.size()][4];
		
		int contador = 0;
		for (Encomenda c: encomendas) {
			s[encomendas.indexOf(c)][contador] = String.valueOf(c.getId());
			contador++;
			s[encomendas.indexOf(c)][contador] = String.valueOf(c.getId_produto());
			contador++;
			s[encomendas.indexOf(c)][contador] = String.valueOf(c.getFornecedor().getLogin());
			contador++;
			s[encomendas.indexOf(c)][contador] = String.valueOf(c.getQnt());
			contador=0;
		}
		
		return s;
		
	}
	
	public static String[] colunasEncomendas() {
		String []s = {"ID", "ID Produto", "Fornecedor", "Qnt"};
		return s;
	}
	
	public static String[][] dadosVendas() {
		String[][] s = new String[vendas.size()][4];
		
		int contador = 0;
		for (Pedido p: vendas) {
			s[vendas.indexOf(p)][contador] = String.valueOf(p.getId());
			contador++;
			s[vendas.indexOf(p)][contador] = String.valueOf(p.getId_produto());
			contador++;
			s[vendas.indexOf(p)][contador] = String.valueOf(p.getCliente().getLogin());
			contador++;
			s[vendas.indexOf(p)][contador] = String.valueOf(p.getQnt());
			contador=0;
		}

		return s;
		
	}
	
	public static String[] colunasVendas() {
		String []s = {"ID", "ID Produto", "Cliente", "Qnt"};
		return s;
	}
	
	public static String[][] dadosUsuarios() {
		String[][] s = new String[usuarios.size()][4];
		
		int contador = 0;
		for (Usuario u: usuarios) {
			s[usuarios.indexOf(u)][contador] = String.valueOf(u.getId());
			contador++;
			s[usuarios.indexOf(u)][contador] = String.valueOf(u.getLogin());
			contador++;
			s[usuarios.indexOf(u)][contador] = String.valueOf(u.getSenha());
			contador++;
			s[usuarios.indexOf(u)][contador] = String.valueOf(u.getTipo());
			contador=0;
		}

		return s;
		
	}
	
	public static String[] colunasUsuarios() {
		String []s = {"ID", "Login", "Senha", "Tipo"};
		return s;
	}
	
}
