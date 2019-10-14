package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.TelaAdministrador;
import view.TelaCadastrarProduto;
import view.TelaEstoque;

public class ControllerTelaAdministrador {
	
	public ControllerTelaAdministrador(TelaAdministrador ta) {
		
		ta.getBtnDeslogar().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ta.dispose();
				ta.getTl().setVisible(true);
			}
		});
		
		ta.getBtnVisualizarEstoque().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				TelaEstoque te = new TelaEstoque();
				
			}
		});
		
		ta.getBtnCadastrarProduto().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				TelaCadastrarProduto tcp = new TelaCadastrarProduto();
				ControllerCadastrarProduto ccp = new ControllerCadastrarProduto(tcp);
			}
		});
		
	}
	
}
