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
		String[] u = {"ID", "Usuario", "País", "Estado", "Cidade", "Bairro", "Rua", "Número"};
		return u;
	}

	@Override
	public void deletarEndereco(int id) throws SQLException {
		dao.delete(id);
		
	}

	@Override
	public Endereco buscarEndereco(Usuario usuario) throws SQLException {
		ArrayList<Endereco> data = dao.dataEndereco();
		
		for (Endereco e: data) {
			
			if (e.getUsuario().getLogin().equals(usuario.getLogin()))
				return e;
			
		}
		return null;
	}

	public DaoEndereco getDao() {
		return dao;
	}

}
