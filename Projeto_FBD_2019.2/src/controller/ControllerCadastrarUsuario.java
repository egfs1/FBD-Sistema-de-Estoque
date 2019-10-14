package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.BaseDados;
import model.Usuario;
import view.TelaCadastrarUsuario;

public class ControllerCadastrarUsuario {
	
	
	public ControllerCadastrarUsuario(TelaCadastrarUsuario tcu) {
		
		tcu.getBtnCadastrar().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String tipo="Cliente";
				if (tcu.getRdbtnCaixa().isEnabled()) {
					tipo="Caixa";
				}
					
				
				Usuario user = new Usuario(tcu.getFieldLogin().getText(), tcu.getFieldSenha().getText(), tipo);
				BaseDados.addUsuario(user);
				
				
			}
		});
		
	}
}
