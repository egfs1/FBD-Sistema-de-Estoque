package business;

import java.sql.SQLException;
import java.util.ArrayList;

import controller.ControllerTelaCliente;
import dao.DaoVendas;
import fachada.Fachada;
import model.Pedido;
import model.Produto;
import view.TelaMensagem;

public class BusinessVendas implements IBusinessVendas {
	
	private DaoVendas dao;
	
	public BusinessVendas() {
		dao = new DaoVendas();
		
	}

	@Override
	public void addVendas(Pedido pedido) throws SQLException {
		dao.salvar(pedido);
		Fachada.getInstance().getDaoEstoque().removerQnt(pedido.getId_produto(), pedido.getQnt());
		
		pedido.getCliente().atualizarDataPedidos();
		ControllerTelaCliente.atualizarPedidos();
		ControllerTelaCliente.atualizarTelaRealizarPedido();
	}

	@Override
	public String[][] dataVendas() throws SQLException {
		ArrayList<Pedido> data = dao.dataVendas();
		String[][] s = new String[data.size()][6];
		
		int contador = 0;
		for (Pedido p: data) {
			s[data.indexOf(p)][contador] = String.valueOf(p.getId());
			contador++;
			s[data.indexOf(p)][contador] = String.valueOf(p.getCliente().getLogin());
			contador++;
			s[data.indexOf(p)][contador] = String.valueOf(p.getId_produto());
			contador++;
			s[data.indexOf(p)][contador] = String.valueOf(p.getQnt());
			contador++;
			s[data.indexOf(p)][contador] = String.valueOf(p.getValor());
			contador++;
			s[data.indexOf(p)][contador] = String.valueOf(p.getData());
			contador=0;
		}

		return s;
	}
	
	public String[][] dataVendasBusca(String busca) throws SQLException {
		ArrayList<Pedido> data = dao.dataVendasBusca(busca);
		String[][] s = new String[data.size()][6];
		
		int contador = 0;
		for (Pedido p: data) {
			s[data.indexOf(p)][contador] = String.valueOf(p.getId());
			contador++;
			s[data.indexOf(p)][contador] = String.valueOf(p.getCliente().getLogin());
			contador++;
			s[data.indexOf(p)][contador] = String.valueOf(p.getId_produto());
			contador++;
			s[data.indexOf(p)][contador] = String.valueOf(p.getQnt());
			contador++;
			s[data.indexOf(p)][contador] = String.valueOf(p.getValor());
			contador++;
			s[data.indexOf(p)][contador] = String.valueOf(p.getData());
			contador=0;
		}

		return s;
	}

	@Override
	public String[] colunasVendas() {
		String []s = {"ID", "Cliente", "ID Produto", "Qnt", "Valor", "Data"};
		return s;
	}
	
	public String relatorioVendas() throws SQLException {
		ArrayList<Pedido> dados = dao.dataVendas();
		String s = "Relatório Total das Vendas \n\n";
		for (Pedido p: dados) {
			s += p.toString();
		}
		
		return s;
	}
	
	public double valorTotalVendas() throws SQLException {
		return dao.valorTotalVendas();
	}
	
	
	public DaoVendas getDaoVendas() {
		return dao;
	}

	@Override
	public void updateCliente(String login_novo, String login_antigo) throws SQLException {
		dao.updateCliente(login_novo, login_antigo);
		
	}

}
