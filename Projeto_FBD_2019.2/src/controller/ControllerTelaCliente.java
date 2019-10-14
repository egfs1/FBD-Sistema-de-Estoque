package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.BaseDados;
import view.TelaCliente;
import view.TelaTable;
import view.TelaRealizarPedido;

public class ControllerTelaCliente {
	
	private TelaTable te, tp;
	private TelaRealizarPedido trp;
	private ControllerTelaPedido ctp;
	
	
	
	public ControllerTelaCliente(TelaCliente tcl) {
		
		te = new TelaTable(BaseDados.dadosEstoque(), BaseDados.colunasEstoque(), "Estoque");
		tp = new TelaTable(tcl.getCliente().dadosPedidos(), BaseDados.colunasPedido(), "Pedidos");
		
		trp = new TelaRealizarPedido(tcl.getCliente());
		ctp = new ControllerTelaPedido(trp);
		
		
		tcl.getBtnDeslogar().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				tcl.dispose();
				tcl.getTl().setVisible(true);
				tcl.getCliente().setLogado(false);
			}
		});
		
		tcl.getBtnVisualizarEstoque().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				te.dispose();
				te = new TelaTable(BaseDados.dadosEstoque(), BaseDados.colunasEstoque(), "Estoque");
				te.setVisible(true);
			}
		});
		
		tcl.getBtnRealizarPedido().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				trp.dispose();
				trp = new TelaRealizarPedido(tcl.getCliente());
				ctp = new ControllerTelaPedido(trp);
				trp.setVisible(true);
			}
		});
		
		tcl.getBtnVisualizarPedidos().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				tp.dispose();
				tp = new TelaTable(tcl.getCliente().dadosPedidos(), BaseDados.colunasPedido(), "Pedidos");
				tp.setVisible(true);
			}
		});
		
	}
	
}
