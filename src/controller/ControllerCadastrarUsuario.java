package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import App.App;
import fachada.Fachada;
import model.Cliente;
import model.Endereco;
import model.Fornecedor;
import model.Usuario;
import view.TelaCadastrarUsuario;
import view.TelaMensagem;

public class ControllerCadastrarUsuario {
	
	
	public ControllerCadastrarUsuario(TelaCadastrarUsuario tcu) {
		
		tcu.getBtnCadastrar().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String nome = tcu.getFieldUsuario().getText().intern();
				String senha = tcu.getFieldSenha().getText().intern();
				String email = tcu.getFieldEmail().getText().intern();
				
				String pais = tcu.getPaisField().getText().intern();
				String estado = tcu.getEstadoField().getText().intern();
				String cidade = tcu.getCidadeField().getText().intern();
				String bairro = tcu.getBairroField().getText().intern();
				String rua = tcu.getRuaField().getText().intern();
				String numero = tcu.getNumeroField().getText().intern();

				
				
				if (validarDados(nome, senha, email, pais, estado, cidade, bairro, rua, numero) && Fachada.getInstance().buscarUsuarioLogin(nome)==null) {
					Endereco endereco = new Endereco(pais, estado, cidade, bairro, rua, Integer.parseInt(numero));
					
					if (tcu.getRdbtnCliente().isSelected()) {
						Cliente user = new Cliente(nome, senha, email);
						endereco.setUsuario(user);
						App.fachada.cadastrarUsuario(user, endereco);
						return;
					}
					
					if (tcu.getRdbtnFornecedor().isSelected()) {
						Fornecedor user = new Fornecedor(nome, senha, email);
						endereco.setUsuario(user);
						App.fachada.cadastrarUsuario(user, endereco);
						return;
					};
				}
				if (Fachada.getInstance().buscarUsuarioLogin(nome)!=null) {
					TelaMensagem.mensagem("Nome de usuario já cadastrado!");
				}
				
				
			}
		});
		
	}
	
	public boolean validarDados(String nome, String senha, String email, String pais,String estado, String cidade, String bairro, String rua, String numero) {
		
		if (nome=="" || senha=="" || email=="" || pais=="" || estado==""|| cidade ==""|| bairro==""|| rua=="" || numero=="") {
			TelaMensagem.mensagem("Preencha todos os campos apropriadamente!");
			return false;
		}
		try {
			Integer.parseInt(numero);
		} catch (Exception e) {
			TelaMensagem.mensagem("Preencha todos os campos apropriadamente!");
			return false;
		}
		
		
		return true;
		
	}
}
