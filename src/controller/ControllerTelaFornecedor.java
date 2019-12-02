package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import App.App;
import fachada.Fachada;
import view.PanelTable;
import view.TelaFornecedor;

public class ControllerTelaFornecedor {
	
	private static PanelTable te, ten;
	private static TelaFornecedor tf;
	
	
	public ControllerTelaFornecedor(TelaFornecedor telafornecedor) {
		tf = telafornecedor;
		
		te = new PanelTable(Fachada.getInstance().dataEstoque(), Fachada.getInstance().colunasEstoque(), "Estoque");
		ten = new PanelTable(tf.getFornecedor().dadosEncomendas(), Fachada.getInstance().colunasEncomenda(), "Encomendas");
		
		tf.setPanelTable(te);
		te.setVisible(true);
		
		tf.getMntmDeslogar().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				tf.dispose();
				tf.getTl().setVisible(true);
			}
		});
		
		tf.getBtnVisualizarEstoque().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				atualizarEstoque();
			}
		});
		
		tf.getBtnVisualizarEncomendas().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				atualizarEncomendas();
			}
		});
		
		
		
	}
	
	public static void atualizarEstoque() {
		if (tf!=null) {
		te=null;
		te = new PanelTable(App.fachada.dataEstoque(), App.fachada.colunasEstoque(), "Estoque");
		tf.setPanelTable(te);
		te.setVisible(true);
		}
	}
	
	public static void atualizarEncomendas() {
		if (tf!=null) {
		te=null;
		ten = new PanelTable(tf.getFornecedor().dadosEncomendas(), App.fachada.colunasEncomenda(), "Encomendas");
		tf.setPanelTable(ten);
		ten.setVisible(true);
		}
	}
	
	
}
