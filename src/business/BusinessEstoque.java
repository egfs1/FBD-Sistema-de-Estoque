package business;

import java.sql.SQLException;
import java.util.ArrayList;

import controller.ControllerTelaAdministrador;
import dao.DaoEstoque;
import model.Produto;
import view.TelaMensagem;

public class BusinessEstoque implements IBusinessEstoque {
	
	private static DaoEstoque dao;
	
	public BusinessEstoque() {
		
		dao = new DaoEstoque();
		
	}

	@Override
	public Produto buscarProdutoID(int id) throws SQLException {
		for(Produto p: dao.dataEstoque()) {
			if (p.getId()==id) {
				return p;
			}
		}
		return null;
	}

	@Override
	public boolean cadastrarProduto(Produto produto) throws SQLException {
		for (Produto p: dao.dataEstoque()) {
			if (produto.getNome().equalsIgnoreCase(p.getNome())){
				TelaMensagem.mensagem("Já existe um produto com esse nome!");
				return false;
			}
		}
		try {
			dao.salvar(produto);
			
			ControllerTelaAdministrador.atualizarEstoque();;
			ControllerTelaAdministrador.atualizarTelaCadastrarProduto();;
			TelaMensagem.mensagem("Produto cadastrado com sucesso!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}

	@Override
	public boolean existeProduto(int id) throws SQLException {
		for (Produto p: dao.dataEstoque()) {
			if (p.getId()==id) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void editarProduto(Produto produto, String login) throws SQLException {
		dao.edit(produto, login);
		ControllerTelaAdministrador.atualizarEstoque();
		ControllerTelaAdministrador.atualizarTelaEditProduto();
		TelaMensagem.mensagem("Modificação Salva com sucesso!");
		
	}

	@Override
	public void deletarProduto(Produto produto) throws SQLException {
		dao.delete(produto);
		ControllerTelaAdministrador.atualizarEstoque();;
		ControllerTelaAdministrador.atualizarTelaEditProduto();
		TelaMensagem.mensagem("Produto Deletado com sucesso!");
		
	}

	@Override
	public String[][] dataEstoque() throws SQLException {
		ArrayList<Produto>data = dao.dataEstoque();
		String[][] s = new String[data.size()][5];
		
		int contador = 0;
		for (Produto p: data) {
			s[data.indexOf(p)][contador] = String.valueOf(p.getId());
			contador++;
			s[data.indexOf(p)][contador] = p.getNome();
			contador++;
			s[data.indexOf(p)][contador] = String.valueOf(p.getValor_encomenda());
			contador++;
			s[data.indexOf(p)][contador] = String.valueOf(p.getValor_venda());
			contador++;
			s[data.indexOf(p)][contador] = String.valueOf(p.getQnt());
			contador=0;
			
		}
		
		return s;
	}

	@Override
	public String[] colunasEstoque() {
		String []s = {"ID", "Nome", "Valor Encomenda", "Valor Venda", "Qnt Estoque"};
		return s;
	}
	
	public DaoEstoque getDao() {
		return dao;
	}

}
