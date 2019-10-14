package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.BaseDados;
import view.TelaCadastrarProduto;
import view.TelaMensagem;

public class ControllerCadastrarProduto {
	
	public ControllerCadastrarProduto(TelaCadastrarProduto tcp) {
		
		tcp.getBtnCadastrar().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String nome = tcp.getFieldNome().getText().intern();
				String id = tcp.getFieldId().getText().intern();
				
				if (validarProduto(nome, id))
					BaseDados.cadastrarProduto(tcp.getFieldNome().getText(), Integer.parseInt(tcp.getFieldId().getText()));
			}
		});
		
	}
	
	public boolean validarProduto(String nome, String id) {
		
		if (nome=="" || id=="") {
			TelaMensagem.mensagem("Preencha todos os campos corretamente!");
			return false;
		}
		
		try {
			Integer.parseInt(id);
			
		} catch(Exception e) {
			TelaMensagem.mensagem("Preencha todos os campos corretamente!");
			return false;
		}
		
		return true;
	}
	
}
