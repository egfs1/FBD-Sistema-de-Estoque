package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.BaseDados;
import view.TelaCadastrarProduto;

public class ControllerCadastrarProduto {
	
	public ControllerCadastrarProduto(TelaCadastrarProduto tcp) {
		
		tcp.getBtnCadastrar().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				BaseDados.cadastrarProduto(tcp.getFieldNome().getText(), Integer.parseInt(tcp.getFieldId().getText()));
			}
		});
		
	}
	
}
