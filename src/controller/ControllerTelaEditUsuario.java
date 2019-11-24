package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fachada.Fachada;
import model.Usuario;
import view.TelaEditarUsuario;
import view.TelaMensagem;

public class ControllerTelaEditUsuario {
	
	public ControllerTelaEditUsuario(TelaEditarUsuario teu) {
		
		teu.getBtnBuscar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = teu.getIdField().getText().intern();
				
				if (validarId(id)) {
					Usuario u;
					
					u = Fachada.getInstance().buscarUsuarioID(Integer.parseInt(id));
					
					if (u!=null) {
						teu.getLoginField().setEnabled(true);
						teu.getLoginField().setText(u.getLogin());
						teu.getSenhaField().setEnabled(true);
						teu.getSenhaField().setText(u.getSenha());
						teu.getBtnSalvar().setEnabled(true);
						teu.getBtnDeletar().setEnabled(true);
						teu.setUsuario(u);
				
					}
				}
				
			}
		});
		
		teu.getBtnSalvar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String login = teu.getNomeField().getText().intern();
				String senha = teu.getSenhaField().getText().intern();
				
				if (validarLoginSenha(login, senha))
					Fachada.getInstance().editarUsuario(teu.getUsuario(),login, senha);
					
			}
		});
		
		teu.getBtnDeletar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Fachada.getInstance().deletarUsuario(teu.getUsuario());;
				
			}
		});
		
		
	}
	
	public static boolean validarId(String id) {
		if (id=="") {
			TelaMensagem.mensagem("Preencha os espa�os corretamente!");
			return false;
		}
		
		try {
			
			Integer.parseInt(id);
			return true;
			
		}
		catch (Exception e) {
			TelaMensagem.mensagem("Preencha os espa�os corretamente!");
			return false;
		}	
	}
	
	public static boolean validarLoginSenha(String login, String senha) {
		if (login=="" || senha=="") {
			TelaMensagem.mensagem("Preencha os espa�os corretamente!");
			return false;
		}
		return true;
	}
	
}
