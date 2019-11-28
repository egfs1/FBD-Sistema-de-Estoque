package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fachada.Fachada;
import model.Produto;
import view.TelaCadastrarProduto;
import view.TelaMensagem;

public class ControllerCadastrarProduto {
	
	public ControllerCadastrarProduto(TelaCadastrarProduto tcp) {
		
		tcp.getBtnCancelar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tcp.setVisible(false);
			}
		});
		
		tcp.getBtnCadastrar().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String nome = tcp.getFieldNomeProduto().getText().intern();
				String valor_encomenda = tcp.getFieldValorEncomenda().getText().intern();
				String valor_venda = tcp.getFieldValorVenda().getText().intern();
				
				if (validarProduto(nome, valor_encomenda, valor_venda)) {
					Produto p = new Produto(nome, Integer.parseInt(valor_encomenda), Integer.parseInt(valor_venda));
					Fachada.getInstance().cadastrarProduto(p);
				}
			}
		});
		
	}
	
	public boolean validarProduto(String nome, String valor_encomenda, String valor_venda) {
		
		if (nome=="" || valor_encomenda=="" || valor_venda=="") {
			TelaMensagem.mensagem("Preencha todos os campos corretamente!");
			return false;
		}
		
		try {
			
			Integer.parseInt(valor_encomenda);
			Integer.parseInt(valor_venda);
			
			
		} catch (Exception e) {
			TelaMensagem.mensagem("Preencha todos os campos corretamente!");
			return false;
		}
				
		return true;
	}
	
}
