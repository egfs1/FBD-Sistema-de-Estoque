package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import fachada.Fachada;
import model.Encomenda;
import model.Fornecedor;
import model.Produto;
import model.Usuario;
import view.TelaEncomendarProduto;
import view.TelaMensagem;
import view.TelaPergunta;

public class ControllerComprarProduto {
	
	public ControllerComprarProduto(TelaEncomendarProduto tcop) {
		
		tcop.getBtnCancelar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tcop.setVisible(false);
			}
		});
		
		tcop.getBtnComprar().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String id_produto = tcop.getFieldId().getText().intern();
				String qnt = tcop.getFieldQnt().getText().intern();
				String forn = tcop.getFieldFornecedor().getText().intern();
				
				if (validarProduto(id_produto, qnt, forn)) {
					Fornecedor fornecedor;
					
					fornecedor = (Fornecedor) Fachada.getInstance().buscarUsuarioLogin(forn);
					Produto produto = Fachada.getInstance().buscarProdutoID(Integer.parseInt(id_produto));
					System.out.println(Integer.parseInt(qnt));
					System.out.println(produto.getValor_encomenda());
					int valor = Integer.parseInt(qnt) * produto.getValor_encomenda();
					Date data = new Date(System.currentTimeMillis());
					
					if (TelaPergunta.pergunta("Deseja Comprar x" + qnt + " " + produto.getNome() + " por R$ " + valor + "?")) {
						Encomenda encomenda = new Encomenda(fornecedor,Integer.parseInt(id_produto),Integer.parseInt(qnt),valor, data);
						Fachada.getInstance().encomendarProduto(encomenda);
					}
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
			Fachada.getInstance().existeUsuario(usuario);
			Usuario u = Fachada.getInstance().buscarUsuarioLogin(usuario);
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
