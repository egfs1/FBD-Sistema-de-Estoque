package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.TelaCliente;
import view.TelaEstoque;
import view.TelaPedidos;
import view.TelaRealizarPedido;

public class ControllerTelaCliente {
	
	private TelaEstoque te;
	private TelaPedidos tp;
	private TelaRealizarPedido trp;
	private ControllerTelaPedido ctp;
	
	
	
	public ControllerTelaCliente(TelaCliente tcl) {
		
		te = new TelaEstoque();
		tp = new TelaPedidos(tcl.getCliente().dadosPedidos());
		
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
				te = new TelaEstoque();
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
				tp = new TelaPedidos(tcl.getCliente().dadosPedidos());
				tp.setVisible(true);
			}
		});
		
	}
	
}
