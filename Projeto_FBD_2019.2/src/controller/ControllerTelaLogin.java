package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Administrador;
import model.BaseDados;
import model.Cliente;
import model.Usuario;
import view.TelaAdministrador;
import view.TelaCliente;
import view.TelaLogin;
import view.TelaMensagem;

public class ControllerTelaLogin{

	public ControllerTelaLogin(TelaLogin tl) {
		
		tl.getBtnEntrar().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Usuario user;
				user = BaseDados.buscarUsuario_login_senha(tl.getFieldLogin().getText(), tl.getFieldSenha().getText());
				if (user!=null) {
					
					if (!user.isLogado()) {
						if (user.getTipo().equalsIgnoreCase("ADM")) {
							TelaMensagem.mensagem("Logado com sucesso!");
							TelaAdministrador ta = new TelaAdministrador(tl, (Administrador) user);
							ControllerTelaAdministrador cta = new ControllerTelaAdministrador(ta);
							user.setLogado(true);
							
						}
						
						if (user.getTipo().equalsIgnoreCase("Cliente")) {
							TelaMensagem.mensagem("Logado com sucesso!");
							TelaCliente tcl = new TelaCliente(tl, (Cliente) user);
							ControllerTelaCliente ctc = new ControllerTelaCliente(tcl);
							user.setLogado(true);
						}
						
						if (user.getTipo().equalsIgnoreCase("Caixa")) {
							TelaMensagem.mensagem("Logado com sucesso!");
							user.setLogado(true);
						}
					}
					else {
						TelaMensagem.mensagem("Usuario já está logado!");
					}
				}
			}
		});
		
	}
	
	
}
