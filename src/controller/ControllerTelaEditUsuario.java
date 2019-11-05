package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.BaseDados;
import model.Produto;
import model.Usuario;
import view.TelaEditarProduto;
import view.TelaEditarUsuario;
import view.TelaMensagem;

public class ControllerTelaEditUsuario {
	
	public ControllerTelaEditUsuario(TelaEditarUsuario teu) {
		
		teu.getBtnBuscar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = teu.getIdField().getText().intern();
				
				if (validarId(id)) {
					Usuario u= BaseDados.buscarUsuario_id(Integer.parseInt(id));
					if (u!=null) {
						teu.getLoginField().setEnabled(true);
						teu.getLoginField().setText(u.getLogin());
						teu.getSenhaField().setEnabled(true);
						teu.getSenhaField().setText(u.getSenha());
						teu.getBtnSalvar().setEnabled(true);
						teu.getBtnDeletar().setEnabled(true);
						teu.setUsuario(u);
						
					}
					else {
						TelaMensagem.mensagem("Não existe nenhum usuario com esse ID!");
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
					BaseDados.editarUsuario(teu.getUsuario(), login, senha);
					
			}
		});
		
		teu.getBtnDeletar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				BaseDados.deletarUsuario(teu.getUsuario());
				
			}
		});
		
		
	}
	
	public static boolean validarId(String id) {
		if (id=="") {
			TelaMensagem.mensagem("Preencha os espaços corretamente!");
			return false;
		}
		
		try {
			
			Integer.parseInt(id);
			return true;
			
		}
		catch (Exception e) {
			TelaMensagem.mensagem("Preencha os espaços corretamente!");
			return false;
		}	
	}
	
	public static boolean validarLoginSenha(String login, String senha) {
		if (login=="" || senha=="") {
			TelaMensagem.mensagem("Preencha os espaços corretamente!");
			return false;
		}
		return true;
	}
	
}
