package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.BaseDados;
import model.Caixa;
import model.Cliente;
import model.Fornecedor;
import model.Usuario;
import view.TelaCadastrarUsuario;

public class ControllerCadastrarUsuario {
	
	
	public ControllerCadastrarUsuario(TelaCadastrarUsuario tcu) {
		
		tcu.getBtnCadastrar().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if (tcu.getRdbtnCliente().isSelected()) {
					Cliente user = new Cliente(tcu.getFieldLogin().getText(), tcu.getFieldSenha().getText());
					BaseDados.addUsuario(user);
					return;
				}
				
				if (tcu.getRdbtnCaixa().isSelected()) {
					Caixa user = new Caixa(tcu.getFieldLogin().getText(), tcu.getFieldSenha().getText());
					BaseDados.addUsuario(user);
					return;
				}
				
				if (tcu.getRdbtnFornecedor().isSelected()) {
					Fornecedor user = new Fornecedor(tcu.getFieldLogin().getText(), tcu.getFieldSenha().getText());
					BaseDados.addUsuario(user);
					return;
				};
				
				
			}
		});
		
	}
}
