package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.BaseDados;
import model.Cliente;
import model.Pedido;
import view.TelaMensagem;
import view.TelaRealizarPedido;

public class ControllerTelaPedido {
	
	
	public ControllerTelaPedido(TelaRealizarPedido trp) {
		
		trp.getBtnComprar().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String id = trp.getFieldId().getText().intern();
				String qnt = trp.getFieldQnt().getText().intern();
				Cliente cliente = trp.getCliente();
				
				if (validarPedido(id, qnt)) {
					Pedido pedido = new Pedido(Integer.parseInt(id), Integer.parseInt(qnt), cliente);
					pedido.setCliente(cliente);
					
					if (BaseDados.addPedido(pedido))
						cliente.addPedidos(pedido);
					
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
