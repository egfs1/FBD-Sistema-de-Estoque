package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import App.App;
import fachada.Fachada;
import view.TelaCliente;
import view.PanelTable;
import view.TelaRealizarPedido;

public class ControllerTelaCliente {
	
	private static PanelTable te, tp;
	private static TelaRealizarPedido trp;
	private static ControllerTelaPedido ctp;
	private static TelaCliente tcl;
	
	
	public ControllerTelaCliente(TelaCliente telacliente) {
		tcl = telacliente;
		
		te = new PanelTable(Fachada.getInstance().dataEstoque(), Fachada.getInstance().colunasEstoque(), "Estoque");
		tp = new PanelTable(tcl.getCliente().dadosPedidos(), Fachada.getInstance().colunasVendas(), "Pedidos");
		
		trp = new TelaRealizarPedido(tcl.getCliente());
		ctp = new ControllerTelaPedido(trp);
		
		tcl.setPanelTable(te);
		te.setVisible(true);
		
		tcl.getMntmDeslogar().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				tcl.dispose();
				tcl.getTl().setVisible(true);
			}
		});
		
		tcl.getBtnVisualizarEstoque().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				atualizarEstoque();
			}
		});
		
		tcl.getMntmRealizarPedido().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				trp.dispose();
				trp = new TelaRealizarPedido(tcl.getCliente());
				ctp = new ControllerTelaPedido(trp);
				trp.setVisible(true);
			}
		});
		
		tcl.getBtnVisualizarPedidos().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				atualizarPedidos();
			}
		});
		
		
		
	}
	
	public static void atualizarEstoque() {
		if (tcl!=null) {
		te=null;
		te = new PanelTable(App.fachada.dataEstoque(), App.fachada.colunasEstoque(), "Estoque");
		tcl.setPanelTable(te);
		te.setVisible(true);
		}
	}
	
	public static void atualizarPedidos() {
		if (tcl!=null) {
		tp=null;
		tp = new PanelTable(tcl.getCliente().dadosPedidos(), App.fachada.colunasVendas(), "Pedidos");
		tcl.setPanelTable(tp);
		tp.setVisible(true);
		}
	}
	
	public static void atualizarTelaRealizarPedido() {
		if (trp!=null) {
		trp.dispose();
		trp = new TelaRealizarPedido(tcl.getCliente());
		ctp = new ControllerTelaPedido(trp);
		trp.setVisible(true);
		}
	}
	
	
}
