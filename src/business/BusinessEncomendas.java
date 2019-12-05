package business;

import java.sql.SQLException;
import java.util.ArrayList;

import controller.ControllerTelaAdministrador;
import dao.DaoEncomendas;
import fachada.Fachada;
import model.Encomenda;
import model.Produto;
import view.TelaMensagem;

public class BusinessEncomendas implements IBusinessEncomenda {
	
	private static DaoEncomendas dao;
	
	public BusinessEncomendas() {
		dao = new DaoEncomendas();
	}

	@Override
	public void encomendarProduto(Encomenda encomenda) throws SQLException {
		dao.salvar(encomenda);
		Fachada.getInstance().getDaoEstoque().adicionarQnt(encomenda.getId_produto(), encomenda.getQnt());
		
		ControllerTelaAdministrador.atualizarEncomendas();
		ControllerTelaAdministrador.atualizarTelaEncomendarProduto();
	}

	@Override
	public String[][] dataEncomendas() throws SQLException {
		ArrayList<Encomenda> data = dao.dataEncomendas();
		String[][] s = new String[data.size()][6];
		
		int contador = 0;
		for (Encomenda c: data) {
			s[data.indexOf(c)][contador] = String.valueOf(c.getId());
			contador++;
			s[data.indexOf(c)][contador] = String.valueOf(c.getFornecedor().getLogin());
			contador++;
			s[data.indexOf(c)][contador] = String.valueOf(c.getId_produto());
			contador++;
			s[data.indexOf(c)][contador] = String.valueOf(c.getQnt());
			contador++;
			s[data.indexOf(c)][contador] = String.valueOf(c.getValor());
			contador++;
			s[data.indexOf(c)][contador] = String.valueOf(c.getData());
			contador=0;
		}
		
		return s;
	}

	@Override
	public String[] colunasEncomenda() {
		String []s = {"ID", "Fornecedor", "ID Produto", "Qnt", "Valor", "Data"};
		return s;
	}
	
	public String relatorioEncomendas() throws SQLException {
		ArrayList<Encomenda> dados = dao.dataEncomendas();
		String s = "Relatório Total das Encomendas \n\n";
		for (Encomenda e: dados) {
			s += e.toString();
		}
		
		return s;
	}
	
	public double valorTotalEncomendas() throws SQLException {
		return dao.valorTotalEncomendas();
	}
	
	public DaoEncomendas getDao() {
		return dao;
	}

	@Override
	public String[][] dataEncomendasBusca(String busca) throws SQLException {
		ArrayList<Encomenda> data = dao.dataEncomendasBusca(busca);
		String[][] s = new String[data.size()][6];
		
		int contador = 0;
		for (Encomenda c: data) {
			s[data.indexOf(c)][contador] = String.valueOf(c.getId());
			contador++;
			s[data.indexOf(c)][contador] = String.valueOf(c.getFornecedor().getLogin());
			contador++;
			s[data.indexOf(c)][contador] = String.valueOf(c.getId_produto());
			contador++;
			s[data.indexOf(c)][contador] = String.valueOf(c.getQnt());
			contador++;
			s[data.indexOf(c)][contador] = String.valueOf(c.getValor());
			contador++;
			s[data.indexOf(c)][contador] = String.valueOf(c.getData());
			contador=0;
		}
		
		return s;
	}

	@Override
	public void updateFornecedor(String login_novo, String login_antigo) throws SQLException {
		dao.updateFornecedor(login_novo, login_antigo);
		
	}
	
	
	
}
