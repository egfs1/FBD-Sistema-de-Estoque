package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.BaseDados;
import model.Encomenda;
import model.Fornecedor;
import model.Usuario;
import view.TelaEncomendarProduto;
import view.TelaMensagem;

public class ControllerComprarProduto {
	
	public ControllerComprarProduto(TelaEncomendarProduto tcop) {
		
		tcop.getBtnComprar().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String id_produto = tcop.getFieldId().getText().intern();
				String qnt = tcop.getFieldQnt().getText().intern();
				String forn = tcop.getFieldFornecedor().getText().intern();
				Fornecedor fornecedor;
				
				if (validarProduto(id_produto, qnt, forn)) {
					
					fornecedor =  (Fornecedor) BaseDados.buscarUsuario_login(forn);
					Encomenda encomenda = new Encomenda(Integer.parseInt(id_produto),Integer.parseInt(qnt), fornecedor);
					
					BaseDados.encomendarProduto(encomenda);
				}
			}
		});
		
	}
	
	public boolean validarProduto(String id, String qnt, String usuario) {
		if (id=="" || qnt=="" || usuario=="" ) {
			TelaMensagem.mensagem("Preencha todos os campos corretamente!");
			return false;
		}
		
		try {
			Integer.parseInt(id);
			Integer.parseInt(qnt);
			BaseDados.existeUsuario(usuario);
			Usuario u = BaseDados.buscarUsuario_login(usuario);
			if (!u.getTipo().equalsIgnoreCase("Fornecedor")) {
				TelaMensagem.mensagem("Esse usuario não é um fornecedor!");
				return false;
			}
			
		}catch(Exception e) {
			TelaMensagem.mensagem("Preencha todos os campos corretamente!");
			return false;
		}
		return true;
	}
	
}
