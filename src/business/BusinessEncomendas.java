package business;

import java.sql.SQLException;
import java.util.ArrayList;

import controller.ControllerTelaAdministrador;
import dao.DaoEncomendas;
import dao.IDaoEncomendas;
import fachada.Fachada;
import model.Encomenda;
import model.Produto;
import view.TelaMensagem;

public class BusinessEncomendas implements IBusinessEncomenda {
	
	private static IDaoEncomendas dao;
	
	public BusinessEncomendas() {
		dao = new DaoEncomendas();
	}

	@Override
	public boolean encomendarProduto(Encomenda encomenda) throws SQLException {
		if (Fachada.getInstance().existeProduto(encomenda.getId_produto())) {
			for (Produto p: Fachada.getInstance().getDaoEstoque().dataEstoque()) {
				if (p.getId()==encomenda.getId_produto()) {
					TelaMensagem.mensagem("Compra realizada com sucesso!");
					
					try {
						Fachada.getInstance().getDaoEstoque().adicionarQnt(p, encomenda.getQnt());
						dao.salvar(encomenda);
						
						ControllerTelaAdministrador.atualizarEncomendas();
						ControllerTelaAdministrador.atualizarTelaEncomendarProduto();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					
					return true;
				}
				
			}
			return false;
		}
		else {
			TelaMensagem.mensagem("Esse produto não existe!");
			return false;
		}
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
	
	
	
}
