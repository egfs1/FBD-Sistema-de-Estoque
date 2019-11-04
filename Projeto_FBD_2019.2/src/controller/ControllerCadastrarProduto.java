package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.BaseDados;
import model.Produto;
import view.TelaCadastrarProduto;
import view.TelaMensagem;

public class ControllerCadastrarProduto {
	
	public ControllerCadastrarProduto(TelaCadastrarProduto tcp) {
		
		tcp.getBtnCadastrar().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String nome = tcp.getFieldNomeProduto().getText().intern();
				if (validarProduto(nome)) {
					Produto p = new Produto(nome);
					BaseDados.cadastrarProduto(p);
				}
			}
		});
		
	}
	
	public boolean validarProduto(String nome) {
		
		if (nome=="") {
			TelaMensagem.mensagem("Preencha todos os campos corretamente!");
			return false;
		}
				
		return true;
	}
	
}
