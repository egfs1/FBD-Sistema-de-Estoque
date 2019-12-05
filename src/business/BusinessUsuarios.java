package business;

import java.sql.SQLException;
import java.util.ArrayList;

import App.App;
import controller.ControllerTelaAdministrador;
import dao.DaoUsuarios;
import fachada.Fachada;
import model.Endereco;
import model.Usuario;
import view.TelaMensagem;

public class BusinessUsuarios implements IBusinessUsuarios {
	
	private DaoUsuarios dao;
	
	public BusinessUsuarios() {
		dao = new DaoUsuarios();
	}
	
	public Usuario verificarLogin(String login, String senha) throws SQLException {
		Usuario u = dao.buscarUsuarioLoginSenha(login, senha);
		return u;
	}

	public Usuario buscarUsuarioLogin(String login) throws SQLException {
		Usuario u = dao.buscarUsuarioLogin(login);
		return u;
	}

	public Usuario buscarUsuarioID(int id) throws SQLException {
		Usuario u = dao.buscarUsuarioID(id);
		return u;
	}

	public void cadastrarUsuario(Usuario usuario) throws SQLException {
		dao.salvar(usuario);
	}

	public void editarUsuario(Usuario usuario, String login, String senha, String email) throws SQLException{
		dao.edit(usuario, login, senha, email);
		
		ControllerTelaAdministrador.atualizarUsuarios();;
		ControllerTelaAdministrador.atualizarTelaEditUsuario();
		TelaMensagem.mensagem("Modificação Salva com sucesso!");
	}

	public void deletarUsuario(Usuario usuario) throws SQLException {
		dao.deletar(usuario);
		App.fachada.getDaoVendas().deletarPedidoCliente(usuario.getLogin());
		App.fachada.getDaoEncomendas().deletarEncomendaFornecedor(usuario.getLogin());
		App.fachada.getDaoEndereco().delete(usuario.getEndereco());
		
		ControllerTelaAdministrador.atualizarUsuarios();;
		ControllerTelaAdministrador.atualizarTelaEditUsuario();
		TelaMensagem.mensagem("Usuario Deletado com sucesso!");
	}

	public String[][] dataUsuarios() throws SQLException {
		ArrayList<Usuario>data = dao.dataUsuarios();
		String[][] s = new String[data.size()][6];
		
		int contador = 0;
		for (Usuario u: data) {
			s[data.indexOf(u)][contador] = String.valueOf(u.getId());
			contador++;
			s[data.indexOf(u)][contador] = String.valueOf(u.getLogin());
			contador++;
			s[data.indexOf(u)][contador] = String.valueOf(u.getSenha());
			contador++;
			s[data.indexOf(u)][contador] = String.valueOf(u.getEmail());
			contador++;
			s[data.indexOf(u)][contador] = String.valueOf(u.getEndereco());
			contador++;
			s[data.indexOf(u)][contador] = String.valueOf(u.getTipo());
			contador=0;
		}

		return s;
	}
	
	@Override
	public String[][] dataUsuariosBusca(String busca) throws SQLException {
		ArrayList<Usuario>data = dao.dataUsuariosBusca(busca);
		String[][] s = new String[data.size()][6];
		
		int contador = 0;
		for (Usuario u: data) {
			s[data.indexOf(u)][contador] = String.valueOf(u.getId());
			contador++;
			s[data.indexOf(u)][contador] = String.valueOf(u.getLogin());
			contador++;
			s[data.indexOf(u)][contador] = String.valueOf(u.getSenha());
			contador++;
			s[data.indexOf(u)][contador] = String.valueOf(u.getEmail());
			contador++;
			s[data.indexOf(u)][contador] = String.valueOf(u.getEndereco());
			contador++;
			s[data.indexOf(u)][contador] = String.valueOf(u.getTipo());
			contador=0;
		}

		return s;
	}

	@Override
	public String[] colunasUsuarios() {
		String []s = {"ID", "Login", "Senha", "Email", "ID Endereco", "Tipo"};
		return s;
	}
	
	public DaoUsuarios getDao() {
		return dao;
	}

	@Override
	public void setEndereco(Usuario usuario, Endereco endereco) throws SQLException {
		dao.setEndereco(usuario, endereco);
		
		ControllerTelaAdministrador.atualizarUsuarios();
		ControllerTelaAdministrador.atualizarTelaCadastrarUsuario();
		
	}

}
