package model;

import java.awt.List;
import java.util.ArrayList;

import controller.ControllerTelaAdministrador;
import view.TelaMensagem;

public class BaseDados {
	
	public static ArrayList<Usuario>usuarios = new ArrayList<>();
	public static boolean existe_adm=false;
	public static ArrayList<Produto>estoque = new ArrayList<>();
	public static ArrayList<Compra>compras = new ArrayList<>();
	public static ArrayList<Pedido>pedidos = new ArrayList<>();
	
	public static boolean addUsuario(Usuario usuario) {
		
		if (usuario.getTipo().equalsIgnoreCase("ADM")) {
			if (existe_adm) {
				TelaMensagem.mensagem("Já existe um Administrador!");
				return false;
			}
			else existe_adm = true;
		}
		if (!existeUsuario(usuario)) {
			usuarios.add(usuario);
			TelaMensagem.mensagem("Usuario cadastrado com sucesso!");
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
	
	public static String[][] dadosEstoque() {
		String[][] s = new String[estoque.size()][3];
		
		int contador = 0;
		for (Produto p: estoque) {
			s[estoque.indexOf(p)][contador] = p.getNome();
			contador++;
			s[estoque.indexOf(p)][contador] = String.valueOf(p.getId());
			contador++;
			s[estoque.indexOf(p)][contador] = String.valueOf(p.getQnt());
			contador=0;
			
		}
		
		return s;
	}
	
	public static String[] colunasEstoque() {
		String []s = {"Nome", "ID", "Qnt"};
		return s;
	}
	
	public static String [][] dadosCompras() {
		String[][] s = new String[compras.size()][3];
		
		int contador = 0;
		for (Compra c: compras) {
			s[compras.indexOf(c)][contador] = String.valueOf(c.getId());
			contador++;
			s[compras.indexOf(c)][contador] = String.valueOf(c.getQnt());
			contador++;
			s[compras.indexOf(c)][contador] = String.valueOf(c.getFornecedor().getLogin());
			contador=0;
		}
		
		return s;
		
	}
	
	public static String[] colunasCompra() {
		String []s = {"ID", "Qnt", "Fornecedor"};
		return s;
	}
	
	public static String[][] dadosPedidos() {
		String[][] s = new String[pedidos.size()][3];
		
		int contador = 0;
		for (Pedido p: pedidos) {
			s[pedidos.indexOf(p)][contador] = String.valueOf(p.getId());
			contador++;
			s[pedidos.indexOf(p)][contador] = String.valueOf(p.getQnt());
			contador++;
			s[pedidos.indexOf(p)][contador] = String.valueOf(p.getCliente().getLogin());
			contador=0;
		}
		
		return s;
		
	}
	
	public static String[] colunasPedido() {
		String []s = {"ID", "Qnt", "Cliente"};
		return s;
	}
	
	
	public static boolean cadastrarProduto(String nome, int id) {
		for (Produto produto: estoque) {
			if (produto.getNome().equalsIgnoreCase(nome)){
				TelaMensagem.mensagem("Já existe um produto com esse nome!");
				return false;
			}
			if (produto.getId()==id) {
				TelaMensagem.mensagem("Já existe um produto com o mesmo ID!");
				return false;
			}
		}
		
		Produto p = new Produto(nome, id);
		estoque.add(p);
		TelaMensagem.mensagem("Produto cadastrado com sucesso!");
//		ControllerTelaAdministrador.atualizarTelaEstoque();
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
	
	public static boolean addProduto(int id, int qnt) {
		if (existeProduto(id)) {
			for (Produto p: estoque) {
				if (p.getId()==id) {
					p.addQnt(qnt);
					TelaMensagem.mensagem("Compra realizada com sucesso!");
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
	
	public static void addCompra(Compra compra) {
		compras.add(compra);
	}
	
	public static boolean addPedido(Pedido pedido) {
		if (!existeProduto(pedido.getId())) {
			TelaMensagem.mensagem("Esse produto não existe!");
			return false;
		}
		
		for (Produto p: estoque) {
			if (p.getId()==pedido.getId()) {
				if (p.getQnt() - pedido.getQnt() < 0) {
					TelaMensagem.mensagem("Não existe essa quantidade no estoque!");
					return false;
				}
				else {
					p.setQnt(p.getQnt()-pedido.getQnt());
					pedidos.add(pedido);
					TelaMensagem.mensagem("Pedido Realizado com sucesso!");
					return true;
				}
			}
			
		}
		return false;
	}
	
}
