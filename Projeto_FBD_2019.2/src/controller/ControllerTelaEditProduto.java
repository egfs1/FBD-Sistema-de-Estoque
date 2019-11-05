package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.BaseDados;
import model.Produto;
import view.TelaEditarProduto;
import view.TelaMensagem;

public class ControllerTelaEditProduto {
	
	public ControllerTelaEditProduto(TelaEditarProduto tep) {
		
		tep.getBtnBuscar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = tep.getIdField().getText().intern();
				
				if (validarId(id)) {
					Produto p= BaseDados.buscarProduto_id(Integer.parseInt(id));
					if (p!=null) {
						tep.getNomeField().setEnabled(true);
						tep.getNomeField().setText(p.getNome());
						tep.getBtnSalvar().setEnabled(true);
						tep.getBtnDeletar().setEnabled(true);
						tep.setProduto(p);
						
					}
					else {
						TelaMensagem.mensagem("Não existe nenhum produto com esse ID!");
					}
				
				}
				
			}
		});
		
		tep.getBtnSalvar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String nome = tep.getNomeField().getText().intern();
				
				if (validarNome(nome))
				BaseDados.editarProduto(tep.getProduto(), nome);
			}
		});
		
		tep.getBtnDeletar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				BaseDados.deletarProduto(tep.getProduto());
				
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
	
	public static boolean validarNome(String nome) {
		if (nome=="") {
			TelaMensagem.mensagem("Preencha os espaços corretamente!");
			return false;
		}
		return true;
	}
	
}
