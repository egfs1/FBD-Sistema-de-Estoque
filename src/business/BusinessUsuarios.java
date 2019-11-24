package business;

import java.sql.SQLException;
import java.util.ArrayList;

import controller.ControllerTelaAdministrador;
import dao.DaoUsuarios;
import model.Usuario;
import view.TelaMensagem;

public class BusinessUsuarios implements IBusinessUsuarios {
	
	private DaoUsuarios dao;
	
	public BusinessUsuarios() {
		dao = new DaoUsuarios();
	}
	
	public Usuario verificarLogin(String login, String senha) throws SQLException {
		for (Usuario u: dao.dataUsuarios()) {
			if (u.getLogin().equals(login) && u.getSenha().equals(senha)){
				return u;
			}
		}
		TelaMensagem.mensagem("Login ou senha incorretos!");
		return null;
	}

	public Usuario buscarUsuarioLogin(String login) throws SQLException {
		for (Usuario u: dao.dataUsuarios()) {
			if (u.getLogin().equals(login)) {
				return u;
			}
		}
		return null;
	}

	public Usuario buscarUsuarioID(int id) throws SQLException {
		for (Usuario u: dao.dataUsuarios()) {
			if (u.getId()==id) {
				return u;
			}
		}
		return null;
	}

	public boolean cadastrarUsuario(Usuario usuario) throws SQLException {
		
		if (!existeUsuario(usuario.getLogin())) {
			dao.salvar(usuario);
			
			ControllerTelaAdministrador.atualizarUsuarios();
			ControllerTelaAdministrador.atualizarTelaCadastrarUsuario();
			TelaMensagem.mensagem("Usuario cadastrado com sucesso!");
			return true;
		}
		TelaMensagem.mensagem("Esse Usuario já existe!");
		return false;
	}

	public boolean existeUsuario(String login) throws SQLException {
		for (Usuario u: dao.dataUsuarios()) {
			if (u.getLogin().equalsIgnoreCase(login))
				return true;
		}
		return false;
	}
	
	public void editarUsuario(Usuario usuario, String login, String senha){
		try {
			dao.edit(usuario, login, senha);
			
			ControllerTelaAdministrador.atualizarUsuarios();;
			ControllerTelaAdministrador.atualizarTelaEditUsuario();
			TelaMensagem.mensagem("Modificação Salva com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deletarUsuario(Usuario usuario) {
		try {
			dao.deletar(usuario);
			
			ControllerTelaAdministrador.atualizarUsuarios();;
			ControllerTelaAdministrador.atualizarTelaEditUsuario();
			TelaMensagem.mensagem("Usuario Deletado com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String[][] dataUsuarios() throws SQLException {
		ArrayList<Usuario>data = dao.dataUsuarios();
		String[][] s = new String[data.size()][4];
		
		int contador = 0;
		for (Usuario u: data) {
			s[data.indexOf(u)][contador] = String.valueOf(u.getId());
			contador++;
			s[data.indexOf(u)][contador] = String.valueOf(u.getLogin());
			contador++;
			s[data.indexOf(u)][contador] = String.valueOf(u.getSenha());
			contador++;
			s[data.indexOf(u)][contador] = String.valueOf(u.getTipo());
			contador=0;
		}

		return s;
	}

	@Override
	public String[] colunasUsuarios() {
		String []s = {"ID", "Login", "Senha", "Tipo"};
		return s;
	}
	
	public DaoUsuarios getDao() {
		return dao;
	}

}
