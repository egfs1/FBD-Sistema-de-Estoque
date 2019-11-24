package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fachada.Fachada;
import model.Administrador;
import model.Cliente;
import model.Usuario;
import view.TelaAdministrador;
import view.TelaCliente;
import view.TelaLogin;
import view.TelaMensagem;

public class ControllerTelaLogin{

	public ControllerTelaLogin(TelaLogin tl) {
		
		tl.getBtnSair().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		tl.getBtnEntrar().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Usuario user;
				user = Fachada.getInstance().verificarLogin(tl.getFieldLogin().getText(), tl.getFieldSenha().getText());
				
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
						
						if (user.getTipo().equalsIgnoreCase("Fornecedor")) {
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
