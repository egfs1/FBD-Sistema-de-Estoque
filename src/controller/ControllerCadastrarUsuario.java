package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import model.BaseDados;
import model.Caixa;
import model.Cliente;
import model.Fornecedor;
import view.TelaCadastrarUsuario;
import view.TelaMensagem;

public class ControllerCadastrarUsuario {
	
	
	public ControllerCadastrarUsuario(TelaCadastrarUsuario tcu) {
		
		tcu.getBtnCadastrar().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String nome = tcu.getFieldUsuario().getText().intern();
				String senha = tcu.getFieldSenha().getText().intern();
				
				if (validarUsuario(nome, senha)) {
					if (tcu.getRdbtnCliente().isSelected()) {
						Cliente user = new Cliente(nome, senha);
						try {
							BaseDados.cadastrarUsuario(user);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						return;
					}
					
					if (tcu.getRdbtnCaixa().isSelected()) {
						Caixa user = new Caixa(nome, senha);
						try {
							BaseDados.cadastrarUsuario(user);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						return;
					}
					
					if (tcu.getRdbtnFornecedor().isSelected()) {
						Fornecedor user = new Fornecedor(nome, senha);
						try {
							BaseDados.cadastrarUsuario(user);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						return;
					};
				}
				
				
			}
		});
		
	}
	
	public boolean validarUsuario(String nome, String senha) {
		
		if (nome=="" || senha=="") {
			TelaMensagem.mensagem("Preencha todos os campos!");
			return false;
		}
		return true;
		
	}
}
