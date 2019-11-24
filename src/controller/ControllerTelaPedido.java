package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import fachada.Fachada;
import model.Cliente;
import model.Pedido;
import model.Produto;
import view.TelaMensagem;
import view.TelaPergunta;
import view.TelaRealizarPedido;

public class ControllerTelaPedido {
	
	
	public ControllerTelaPedido(TelaRealizarPedido trp) {
		
		trp.getBtnComprar().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String id_produto = trp.getFieldId().getText().intern();
				String qnt = trp.getFieldQnt().getText().intern();
				Cliente cliente = trp.getCliente();
				
				if (validarPedido(id_produto, qnt)) {
					
					Produto produto = Fachada.getInstance().buscarProdutoID(Integer.parseInt(id_produto));
					int valor = Integer.parseInt(qnt)*produto.getValor_venda();
					Date data = new Date(System.currentTimeMillis());
					
					if (TelaPergunta.pergunta("Deseja Encomendar x" + qnt + " " + produto.getNome() + " por R$ " + valor + "?")){
					Pedido pedido = new Pedido(cliente, Integer.parseInt(id_produto), Integer.parseInt(qnt), valor, data);
					Fachada.getInstance().addVendas(pedido);
					}
					
				}
			}
		});
		
		
	}
	
	public boolean validarPedido(String id, String qnt) {
		
		if (id=="" || qnt=="") {
			TelaMensagem.mensagem("Preencha todos os campos!");
			return false;
		}
		
		try {
			
			Integer.parseInt(id);
			Integer.parseInt(qnt);
			
		}catch (Exception e) {
			return false;
		}
		return true;
	}
}
