package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.TelaAdministrador;
import view.TelaCadastrarProduto;
import view.TelaCadastrarUsuario;
import view.TelaComprarProduto;
import view.TelaEstoque;

public class ControllerTelaAdministrador {
	
	private static TelaEstoque te;
	private TelaCadastrarProduto tcp;
	private TelaCadastrarUsuario tcu;
	private TelaComprarProduto tcop;
	private ControllerCadastrarProduto ccp;
	private ControllerCadastrarUsuario ccu;
	private ControllerComprarProduto ccop;
	
	public ControllerTelaAdministrador(TelaAdministrador ta) {
		
		te = new TelaEstoque();
		
		tcp = new TelaCadastrarProduto();
		ccp = new ControllerCadastrarProduto(tcp);
		
		tcu = new TelaCadastrarUsuario();
		ccu = new ControllerCadastrarUsuario(tcu);
		
		tcop = new TelaComprarProduto();
		ccop = new ControllerComprarProduto(tcop);
		
		
		ta.getBtnDeslogar().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ta.dispose();
				ta.getTl().setVisible(true);
				ta.getUsuario().setLogado(false);
			}
		});
		
		ta.getBtnVisualizarEstoque().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				atualizarTelaEstoque();
			}
		});
		
		ta.getBtnCadastrarProduto().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				tcp.dispose();
				tcp = new TelaCadastrarProduto();
				ccp = new ControllerCadastrarProduto(tcp);
				tcp.setVisible(true);
			}
		});
		
		ta.getBtnCadastrarCliente().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				tcu.dispose();
				tcu = new TelaCadastrarUsuario();
				ccu = new ControllerCadastrarUsuario(tcu);
				tcu.setVisible(true);
			}
		});
		
		ta.getBtnComprarProduto().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				tcop.dispose();
				tcop = new TelaComprarProduto();
				ccop = new ControllerComprarProduto(tcop);
				tcop.setVisible(true);
			}
		});
	}
	
	public static void atualizarTelaEstoque() {
		te.dispose();
		te = new TelaEstoque();
		te.setVisible(true);
	}
	
}
