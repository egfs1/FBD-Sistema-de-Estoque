package business;

import java.sql.SQLException;
import java.util.ArrayList;

import controller.ControllerTelaAdministrador;
import dao.DaoEstoque;
import fachada.Fachada;
import model.Produto;
import view.TelaMensagem;

public class BusinessEstoque implements IBusinessEstoque {
	
	private static DaoEstoque dao;
	
	public BusinessEstoque() {
		
		dao = new DaoEstoque();
		
	}
	
	@Override
	public Produto buscarProdutoID(int id) throws SQLException {
		Produto p = dao.buscarProdutoID(id);
		return p;
	}

	@Override
	public void cadastrarProduto(Produto produto) throws SQLException {
		dao.salvar(produto);
		
		ControllerTelaAdministrador.atualizarEstoque();;
		ControllerTelaAdministrador.atualizarTelaCadastrarProduto();;
		TelaMensagem.mensagem("Produto cadastrado com sucesso!");
	}

	@Override
	public void editarProduto(Produto produto, String login, double valor_encomenda, double valor_venda) throws SQLException {
		dao.edit(produto, login, valor_encomenda, valor_venda);
		ControllerTelaAdministrador.atualizarEstoque();
		ControllerTelaAdministrador.atualizarTelaEditProduto();
		TelaMensagem.mensagem("Modificação Salva com sucesso!");
		
	}

	@Override
	public void deletarProduto(Produto produto) throws SQLException {
		dao.delete(produto);
		Fachada.getInstance().getDaoVendas().deletarPedidoProduto(produto.getId());
		Fachada.getInstance().getDaoEncomendas().deletarEncomendaProduto(produto.getId());
		
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

	@Override
	public String[][] dataEstoqueBusca(String busca) throws SQLException {
		ArrayList<Produto>data = dao.dataEstoqueBusca(busca);
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

}
