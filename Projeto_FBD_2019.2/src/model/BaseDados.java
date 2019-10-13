package model;

import java.util.ArrayList;

import view.TelaMensagem;

public class BaseDados {
	
	public static ArrayList<Usuario>usuarios = new ArrayList<>();
	public static boolean existe_adm=false;
	
	
	public static boolean addUsuario(Usuario usuario) {
		if (usuario.getTipo().equalsIgnoreCase("ADM")) {
			if (existe_adm) {
				TelaMensagem.mensagem("Já existe um Administrador!");
				return false;
			}
			else existe_adm = true;
		}
		usuarios.add(usuario);
		return true;
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
	
}
