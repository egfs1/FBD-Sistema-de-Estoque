package model;

import java.util.ArrayList;

import controller.ControllerTelaAdministrador;
import view.TelaMensagem;

public class BaseDados {
	
	public static ArrayList<Usuario>usuarios = new ArrayList<>();
	public static boolean existe_adm=false;
	public static ArrayList<Produto>estoque = new ArrayList<>();
	public static ArrayList<Compra>compras = new ArrayList<>();
	
	public static boolean addUsuario(Usuario usuario) {
		if (usuario.getTipo().equalsIgnoreCase("ADM")) {
			if (existe_adm) {
				TelaMensagem.mensagem("J� existe um Administrador!");
				return false;
			}
			else existe_adm = true;
		}
		if (!existeUsuario(usuario)) {
			usuarios.add(usuario);
			TelaMensagem.mensagem("Usuario cadastrado com sucesso!");
			return true;
		}
		TelaMensagem.mensagem("Esse Usuario j� existe!");
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
	
	public static String dadosEstoque() {
		String s ="  =-=-=-=-=-= Estoque =-=-=-=-=-=  \n";
		
		for (Produto p: estoque) {
			s += "ID: " + p.getId() + "\n" +
				 "Nome: " + p.getNome() + "\n" +
				 "Qnt: " + p.getQnt() + "\n\n";
		}
		
		if (s.equals("  =-=-=-=-=-= Estoque =-=-=-=-=-=  \n"))
			s = "  =-=-=-=-= Estoque Vazio =-=-=-=-=  ";
		
		return s;
	}
	
	public static boolean cadastrarProduto(String nome, int id) {
		for (Produto produto: estoque) {
			if (produto.getNome().equalsIgnoreCase(nome)){
				TelaMensagem.mensagem("J� existe um produto com esse nome!");
				return false;
			}
			if (produto.getId()==id) {
				TelaMensagem.mensagem("J� existe um produto com o mesmo ID!");
				return false;
			}
		}
		
		Produto p = new Produto(nome, id);
		estoque.add(p);
		TelaMensagem.mensagem("Produto cadastrado com sucesso!");
		ControllerTelaAdministrador.atualizarTelaEstoque();
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
			TelaMensagem.mensagem("Esse produto n�o existe!");
			return false;
		}
	}
	
	public static void addCompra(Compra compra) {
		compras.add(compra);
	}
	
}
