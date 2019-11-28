package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fachada.Fachada;
import model.Administrador;
import model.Cliente;
import model.Fornecedor;
import model.Usuario;
import view.TelaAdministrador;
import view.TelaCliente;
import view.TelaFornecedor;
import view.TelaLogin;
import view.TelaMensagem;

public class ControllerTelaLogin {

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

				if (user != null) {

					if (user.getTipo().equalsIgnoreCase("ADM")) {
//						tl.setVisible(false);
						TelaMensagem.mensagem("Logado com sucesso!");
						TelaAdministrador ta = new TelaAdministrador(tl, (Administrador) user);
						ControllerTelaAdministrador cta = new ControllerTelaAdministrador(ta);

					}

					if (user.getTipo().equalsIgnoreCase("Cliente")) {
//						tl.setVisible(false);
						TelaMensagem.mensagem("Logado com sucesso!");
						TelaCliente tcl = new TelaCliente(tl, (Cliente) user);
						ControllerTelaCliente ctc = new ControllerTelaCliente(tcl);
					}

					if (user.getTipo().equalsIgnoreCase("Fornecedor")) {
//						tl.setVisible(false);
						TelaMensagem.mensagem("Logado com sucesso!");
						TelaFornecedor tf = new TelaFornecedor(tl, (Fornecedor) user);
						ControllerTelaFornecedor ctf = new ControllerTelaFornecedor(tf);
					}
				}
			}
		});

	}

}
