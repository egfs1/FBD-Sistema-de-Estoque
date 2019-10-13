package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.BaseDados;
import model.Usuario;
import view.TelaLogin;
import view.TelaMensagem;

public class ControllerTelaLogin implements ActionListener {

	public ControllerTelaLogin(TelaLogin tl) {
		
		tl.getBtnEntrar().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Usuario user;
				user = BaseDados.buscarUsuario_login_senha(tl.getFieldLogin().getText(), tl.getFieldSenha().getText());
				if (user!=null) {
					
					if (user.getTipo().equalsIgnoreCase("ADM")) {
						TelaMensagem.mensagem("Logado com sucesso!");
					}
					
//					if (user.getTipo().equalsIgnoreCase("Cliente")) {
//						TelaMensagem.mensagem("Logado com sucesso!");
//					}
					
					if (user.getTipo().equalsIgnoreCase("Caixa")) {
						TelaMensagem.mensagem("Logado com sucesso!");
					}
					
				}
			}
		});
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	
	
}
