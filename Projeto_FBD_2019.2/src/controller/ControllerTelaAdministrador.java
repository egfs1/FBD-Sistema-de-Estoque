package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

import model.BaseDados;
import view.TelaAdministrador;
import view.TelaCadastrarProduto;
import view.TelaCadastrarUsuario;
import view.TelaEditarProduto;
import view.TelaEditarUsuario;
import view.TelaEncomendarProduto;
import view.PanelTable;

public class ControllerTelaAdministrador {
	
	private static PanelTable te, tc, tp, tu;
	private static TelaAdministrador ta;
	private static TelaCadastrarProduto tcp;
	private static TelaCadastrarUsuario tcu;
	private static TelaEncomendarProduto tcop;
	private static TelaEditarProduto tep;
	private static TelaEditarUsuario teu;
	private static ControllerCadastrarProduto ccp;
	private static ControllerCadastrarUsuario ccu;
	private static ControllerComprarProduto ccop;
	private static ControllerTelaEditProduto ctep;
	private static ControllerTelaEditUsuario cteu;
	
	public ControllerTelaAdministrador(TelaAdministrador ta) {
		ControllerTelaAdministrador.ta = ta;
		
		te = new PanelTable(BaseDados.dadosEstoque(), BaseDados.colunasEstoque(), "Estoque");
		tc = new PanelTable(BaseDados.dadosEncomendas(), BaseDados.colunasEncomendas(), "Encomendas");
		tp = new PanelTable(BaseDados.dadosVendas(), BaseDados.colunasVendas(), "Vendas");
		tu = new PanelTable(BaseDados.dadosUsuarios(), BaseDados.colunasUsuarios(), "Usuarios");
		
		ta.setPanelTable(te);
		te.setVisible(true);
		
		tcp = new TelaCadastrarProduto();
		ccp = new ControllerCadastrarProduto(tcp);
		
		tcu = new TelaCadastrarUsuario();
		ccu = new ControllerCadastrarUsuario(tcu);
		
		tcop = new TelaEncomendarProduto();
		ccop = new ControllerComprarProduto(tcop);
		
		tep = new TelaEditarProduto();
		ctep = new ControllerTelaEditProduto(tep);
		
		teu = new TelaEditarUsuario();
		cteu = new ControllerTelaEditUsuario(teu);
		
		ta.getMntmDeslogar().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ta.dispose();
				ta.getTl().setVisible(true);
				ta.getUsuario().setLogado(false);
			}
		});
		
		//====================================================================================================
		
		ta.getBtnVisualizarEstoque().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				atualizarEstoque();
			}
		});
		
		ta.getBtnVisualizarCompras().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				atualizarEncomendas();
			}
		});
		
		ta.getBtnVisualizarPedidos().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				atualizarVendas();		
			}
		});
		
		ta.getBtnVisualizarUsuarios().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				atualizarUsuarios();
			}
		});
		
		//====================================================================================================
		
		ta.getMntmCadastrarProduto().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				atualizarTelaCadastrarProduto();
			}
		});
		
		ta.getMntmCadastrarUsuario().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				atualizarTelaCadastrarUsuario();
			}
		});
		
		ta.getMntmEncomendarProduto().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				atualizarTelaEncomendarProduto();
			}
		});
		
		ta.getMntmEditarProduto().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				atualizarTelaEditProduto();
			}
		});
		
		ta.getMntmEditarUsuario().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				atualizarTelaEditUsuario();
			}
		});
		
	}
	
	public static void atualizarEstoque() {
		if (ta!=null) {
		te=null;
		te = new PanelTable(BaseDados.dadosEstoque(), BaseDados.colunasEstoque(), "Estoque");
		ta.setPanelTable(te);
		te.setVisible(true);
		}
	}
	
	public static void atualizarEncomendas() {
		if (ta!=null) {
		tc=null;
		tc = new PanelTable(BaseDados.dadosEncomendas(), BaseDados.colunasEncomendas(), "Encomendas");
		ta.setPanelTable(tc);
		tc.setVisible(true);
		}
	}
	
	public static void atualizarVendas() {
		if (ta!=null) {
		tp=null;
		tp = new PanelTable(BaseDados.dadosVendas(), BaseDados.colunasVendas(), "Vendas");
		ta.setPanelTable(tp);
		tp.setVisible(true);
		}
	}
	
	public static void atualizarUsuarios() {
		if (ta!=null) {
		tu=null;
		tu = new PanelTable(BaseDados.dadosUsuarios(), BaseDados.colunasUsuarios(), "Usuarios");
		ta.setPanelTable(tu);
		tu.setVisible(true);
		}
	}
	
	public static void atualizarTelaCadastrarProduto() {
		if (tcp!=null) {
		tcp.dispose();
		tcp = new TelaCadastrarProduto();
		ccp = new ControllerCadastrarProduto(tcp);
		tcp.setVisible(true);
		}
	}
	
	public static void atualizarTelaCadastrarUsuario() {
		if (tcu!=null) {
		tcu.dispose();
		tcu = new TelaCadastrarUsuario();
		ccu = new ControllerCadastrarUsuario(tcu);
		tcu.setVisible(true);
		}
	}
	
	public static void atualizarTelaEncomendarProduto() {
		if (tcop!=null) {
		tcop.dispose();
		tcop = new TelaEncomendarProduto();
		ccop = new ControllerComprarProduto(tcop);
		tcop.setVisible(true);
		}
	}
	
	public static void atualizarTelaEditProduto() {
		if (tep!=null) {
			tep.dispose();
			tep = new TelaEditarProduto();
			ctep = new ControllerTelaEditProduto(tep);
			tep.setVisible(true);
		}
	}
	
	public static void atualizarTelaEditUsuario() {
		if (teu!=null) {
			teu.dispose();
			teu = new TelaEditarUsuario();
			cteu = new ControllerTelaEditUsuario(teu);
			teu.setVisible(true);
		}
	}
}
