package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import fachada.Fachada;
import view.TelaAdministrador;
import view.TelaCadastrarProduto;
import view.TelaCadastrarUsuario;
import view.TelaEditarProduto;
import view.TelaEditarUsuario;
import view.TelaEncomendarProduto;
import view.TelaRelatorio;
import view.PanelTable;

public class ControllerTelaAdministrador {
	
	private static PanelTable te, tc, tp, tu;
	private static TelaAdministrador ta;
	private static TelaCadastrarProduto tcp;
	private static TelaCadastrarUsuario tcu;
	private static TelaEncomendarProduto tcop;
	private static TelaEditarProduto tep;
	private static TelaEditarUsuario teu;
	private static TelaRelatorio tr;
	private static ControllerCadastrarProduto ccp;
	private static ControllerCadastrarUsuario ccu;
	private static ControllerComprarProduto ccop;
	private static ControllerTelaEditProduto ctep;
	private static ControllerTelaEditUsuario cteu;
	
	public ControllerTelaAdministrador(TelaAdministrador ta) {
		this.ta = ta;
		
		te = new PanelTable(Fachada.getInstance().dataEstoque(), Fachada.getInstance().colunasEstoque(), "Estoque");
		tc = new PanelTable(Fachada.getInstance().dataEncomendas(), Fachada.getInstance().colunasEncomenda(), "Encomendas");
		tp = new PanelTable(Fachada.getInstance().dataVendas(), Fachada.getInstance().colunasVendas(), "Vendas");
		tu = new PanelTable(Fachada.getInstance().dataUsuarios(), Fachada.getInstance().colunasUsuarios(), "Usuarios");
		
		atualizarEstoque();
		
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
		
		tr = new TelaRelatorio();
		
		ta.getMntmDeslogar().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ta.dispose();
				ta.getTl().setVisible(true);
			}
		});
		
		ta.getMntmRelatrio().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				atualizarRelatorio();
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
	
	public static void atualizarRelatorio() {
		if (ta!=null) {
			tr.atualizarTextArea();
			tr.atualizarLblValorDasVendas();
			tr.atualizarLblValorDasEncomendas();
			tr.atualizarLblLucro();
			tr.setVisible(true);
		}
	}
	
	public static void atualizarEstoque() {
		if (ta!=null) {
		te=null;
		te = new PanelTable(Fachada.getInstance().dataEstoque(), Fachada.getInstance().colunasEstoque(), "Estoque");
		
		te.getBtnBuscar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (ta.getPanelTable().equals(te)) {
					String busca = ta.getPanelTable().getTextField().getText().intern();
					atualizarEstoqueBusca(Fachada.getInstance().dataEstoqueBusca(busca));
				}
			}
		});
		
		ta.setPanelTable(te);
		te.setVisible(true);
		}
	}
	
	public static void atualizarEstoqueBusca(String[][]data) {
		if (ta!=null) {
		te=null;
		te = new PanelTable(data, Fachada.getInstance().colunasEstoque(), "Estoque");
		
		te.getBtnBuscar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (ta.getPanelTable().equals(te)) {
					String busca = ta.getPanelTable().getTextField().getText().intern();
					atualizarEstoqueBusca(Fachada.getInstance().dataEstoqueBusca(busca));
				}
			}
		});
		
		ta.setPanelTable(te);
		te.setVisible(true);
		}
	}
	
	public static void atualizarEncomendas() {
		if (ta!=null) {
		tc=null;
		tc = new PanelTable(Fachada.getInstance().dataEncomendas(), Fachada.getInstance().colunasEncomenda(), "Encomendas");
		
		tc.getBtnBuscar().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if (ta.getPanelTable().equals(tc)) {
					String busca = ta.getPanelTable().getTextField().getText().intern();
					atualizarEncomendasBusca(Fachada.getInstance().dataEncomendasBusca(busca));
				}
			}
		});
		ta.setPanelTable(tc);
		tc.setVisible(true);
		}
	}
	
	public static void atualizarEncomendasBusca(String[][]data) {
		if (ta!=null) {
		tc=null;
		tc = new PanelTable(data, Fachada.getInstance().colunasEncomenda(), "Encomendas");
		
		tc.getBtnBuscar().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if (ta.getPanelTable().equals(tc)) {
					String busca = ta.getPanelTable().getTextField().getText().intern();
					atualizarEncomendasBusca(Fachada.getInstance().dataEncomendasBusca(busca));
				}
			}
		});
		
		ta.setPanelTable(tc);
		tc.setVisible(true);
		}
	}
	
	public static void atualizarVendas() {
		if (ta!=null) {
		tp=null;
		tp = new PanelTable(Fachada.getInstance().dataVendas(), Fachada.getInstance().colunasVendas(), "Vendas");
		
		tp.getBtnBuscar().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if (ta.getPanelTable().equals(tp)) {
					String busca = ta.getPanelTable().getTextField().getText().intern();
					atualizarVendasBusca(Fachada.getInstance().dataVendasBusca(busca));
				}
			}
		});
		
		ta.setPanelTable(tp);
		tp.setVisible(true);
		}
	}
	
	public static void atualizarVendasBusca(String[][]data) {
		if (ta!=null) {
		tp=null;
		tp = new PanelTable(data, Fachada.getInstance().colunasVendas(), "Vendas");
		
		tp.getBtnBuscar().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if (ta.getPanelTable().equals(tp)) {
					String busca = ta.getPanelTable().getTextField().getText().intern();
					atualizarVendasBusca(Fachada.getInstance().dataVendasBusca(busca));
				}
			}
		});
		
		ta.setPanelTable(tp);
		tp.setVisible(true);
		}
	}
	
	public static void atualizarUsuarios() {
		if (ta!=null) {
		tu=null;
		tu = new PanelTable(Fachada.getInstance().dataUsuarios(), Fachada.getInstance().colunasUsuarios(), "Usuarios");
		
		tu.getBtnBuscar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (ta.getPanelTable().equals(tu)) {
					String busca = ta.getPanelTable().getTextField().getText().intern();
					atualizarUsuariosBusca(Fachada.getInstance().dataUsuariosBusca(busca));
				}
			}
		});
		
		ta.setPanelTable(tu);
		tu.setVisible(true);
		}
	}
	
	public static void atualizarUsuariosBusca(String [][]data) {
		if (ta!=null) {
		tu=null;
		tu = new PanelTable(data, Fachada.getInstance().colunasUsuarios(), "Usuarios");
		
		tu.getBtnBuscar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (ta.getPanelTable().equals(tu)) {
					String busca = ta.getPanelTable().getTextField().getText().intern();
					atualizarUsuariosBusca(Fachada.getInstance().dataUsuariosBusca(busca));
				}
			}
		});
		
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
