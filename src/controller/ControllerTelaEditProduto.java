package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import App.App;
import fachada.Fachada;
import model.Produto;
import view.TelaEditarProduto;
import view.TelaMensagem;

public class ControllerTelaEditProduto {
	
	public ControllerTelaEditProduto(TelaEditarProduto tep) {
		
		tep.getBtnBuscar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = tep.getIdField().getText().intern();
				
				if (validarId(id)) {
					Produto p= App.fachada.buscarProdutoID(Integer.parseInt(id));
					if (p!=null) {
						tep.getNomeField().setEnabled(true);
						tep.getNomeField().setText(p.getNome());
						
						tep.getFieldValorEncomenda().setEnabled(true);
						tep.getFieldValorEncomenda().setText(p.getValor_encomenda() + "");
						
						tep.getFieldValorVenda().setEnabled(true);
						tep.getFieldValorVenda().setText(p.getValor_venda() + "");
						
						tep.getBtnSalvar().setEnabled(true);
						tep.getBtnDeletar().setEnabled(true);
						tep.setProduto(p);
						
					}
					else {
						TelaMensagem.mensagem("Não existe nenhum produto com esse ID!");
					}
				
				}
				
			}
		});
		
		tep.getBtnSalvar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String nome = tep.getNomeField().getText().intern();
				String valor_encomenda = tep.getFieldValorEncomenda().getText().intern();
				String valor_venda = tep.getFieldValorVenda().getText().intern();
				
				System.out.println(valor_venda);
				System.out.println(valor_encomenda);
				if (validarDados(nome, valor_encomenda, valor_venda))
					App.fachada.editarProduto(tep.getProduto(), nome, Double.parseDouble(valor_encomenda), Double.parseDouble(valor_venda));
			}
		});
		
		tep.getBtnDeletar().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				App.fachada.deletarProduto(tep.getProduto());
				
			}
		});
		
		
	}
	
	public static boolean validarId(String id) {
		if (id=="") {
			TelaMensagem.mensagem("Preencha os espaços corretamente!");
			return false;
		}
		
		try {
			
			Integer.parseInt(id);
			return true;
			
		}
		catch (Exception e) {
			TelaMensagem.mensagem("Preencha os espaços corretamente!");
			return false;
		}	
	}
	
	public static boolean validarDados(String nome, String valor_encomenda, String valor_venda) {
		if (nome=="" || valor_encomenda == "" || valor_venda=="") {
			TelaMensagem.mensagem("Preencha os espaços corretamente!");
			return false;
		}
		
		try {
			
			Double.parseDouble(valor_encomenda);
			Double.parseDouble(valor_venda);
			
		}catch(Exception e) {
			TelaMensagem.mensagem("Preencha os espaços corretamente!");
			return false;
		}
		
		return true;
	}
	
}
