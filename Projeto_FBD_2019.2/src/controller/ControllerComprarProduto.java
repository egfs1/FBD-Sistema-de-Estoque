package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.BaseDados;
import model.Compra;
import model.Fornecedor;
import model.Usuario;
import view.TelaComprarProduto;
import view.TelaMensagem;

public class ControllerComprarProduto {
	
	public ControllerComprarProduto(TelaComprarProduto tcop) {
		
		tcop.getBtnComprar().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String id = tcop.getFieldId().getText().intern();
				String qnt = tcop.getFieldQnt().getText().intern();
				String forn = tcop.getFieldFornecedor().getText().intern();
				Fornecedor fornecedor;
				
				if (validarProduto(id, qnt, forn)) {
					BaseDados.addProduto(Integer.parseInt(id), Integer.parseInt(qnt));
					
					fornecedor =  (Fornecedor) BaseDados.buscarUsuario_login(forn);
					Compra compra = new Compra(Integer.parseInt(id), Integer.parseInt(qnt), fornecedor);
					
					fornecedor.addCompras(compra);
					BaseDados.addCompra(compra);
					
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
