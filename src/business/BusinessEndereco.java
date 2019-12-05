package business;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DaoEndereco;
import model.Endereco;
import model.Usuario;

public class BusinessEndereco implements IBusinessEndereco {
	
	private static DaoEndereco dao;
	
	public BusinessEndereco() {
		
		dao = new DaoEndereco();
		
	}
	
	@Override
	public void cadastrarEndereco(Endereco endereco) throws SQLException {
		dao.salvar(endereco);
		
	}

	@Override
	public String[][] dataEndereco() throws SQLException {
		ArrayList<Endereco>data = dao.dataEndereco();
		String[][] s = new String[data.size()][8];
		
		int contador = 0;
		for (Endereco p: data) {
			s[data.indexOf(p)][contador] = String.valueOf(p.getId());
			contador++;
			s[data.indexOf(p)][contador] = p.getUsuario().getLogin();
			contador++;
			s[data.indexOf(p)][contador] = p.getPais();
			contador++;
			s[data.indexOf(p)][contador] = p.getEstado();
			contador++;
			s[data.indexOf(p)][contador] = p.getCidade();
			contador++;
			s[data.indexOf(p)][contador] = p.getBairro();
			contador++;
			s[data.indexOf(p)][contador] = p.getRua();
			contador++;
			s[data.indexOf(p)][contador] = String.valueOf(p.getNumero());
			contador=0;
			
		}
		
		return s;
	}

	@Override
	public String[][] dataEnderecoBusca(String busca) throws SQLException {
		ArrayList<Endereco>data = dao.dataEnderecoBusca(busca);
		String[][] s = new String[data.size()][8];
		
		int contador = 0;
		for (Endereco p: data) {
			s[data.indexOf(p)][contador] = String.valueOf(p.getId());
			contador++;
			s[data.indexOf(p)][contador] = p.getUsuario().getLogin();
			contador++;
			s[data.indexOf(p)][contador] = p.getPais();
			contador++;
			s[data.indexOf(p)][contador] = p.getEstado();
			contador++;
			s[data.indexOf(p)][contador] = p.getCidade();
			contador++;
			s[data.indexOf(p)][contador] = p.getBairro();
			contador++;
			s[data.indexOf(p)][contador] = p.getRua();
			contador++;
			s[data.indexOf(p)][contador] = String.valueOf(p.getNumero());
			contador=0;
			
		}
		
		return s;
	}

	@Override
	public String[] colunasEndereco() {
		String[] u = {"ID", "Usuario", "Pa�s", "Estado", "Cidade", "Bairro", "Rua", "N�mero"};
		return u;
	}

	@Override
	public void deletarEndereco(int id) throws SQLException {
		dao.delete(id);
		
	}

	public Endereco buscarEndereco(String login_usuario) throws SQLException {
		return dao.buscarEnderecoUsuario(login_usuario);
	}

	public DaoEndereco getDao() {
		return dao;
	}
	
	public void updateUsuario(String login_usuario, int id) throws SQLException {
		dao.updateUsuario(login_usuario, id);
	}

}
