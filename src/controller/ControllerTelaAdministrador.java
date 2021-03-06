package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import App.App;
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
	
	private static PanelTable te, tc, tp, tu, ted;
	private static ControllerPanelTable cpt;
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
		
		tr = new TelaRelatorio();
		
		cpt = new ControllerPanelTable();
		atualizarEstoque();
		
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
		
		ta.getBtnVisualizarEndereco().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				atualizarEnderecos();
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
		te = new PanelTable(App.fachada.dataEstoque(),App.fachada.colunasEstoque(), "Estoque");
		
		cpt.setPaneltable(te);
		
		ta.setPanelTable(te);
		te.setVisible(true);
		}
	}
	
	public static void atualizarEstoqueBusca(String[][]data) {
		if (ta!=null) {
		te=null;
		te = new PanelTable(data, App.fachada.colunasEstoque(), "Estoque");
		
		cpt.setPaneltable(te);
		
		ta.setPanelTable(te);
		te.setVisible(true);
		}
	}
	
	public static void atualizarEncomendas() {
		if (ta!=null) {
		tc=null;
		tc = new PanelTable(App.fachada.dataEncomendas(), App.fachada.colunasEncomenda(), "Encomendas");
		
		cpt.setPaneltable(tc);
		
		ta.setPanelTable(tc);
		tc.setVisible(true);
		}
	}
	
	public static void atualizarEncomendasBusca(String[][]data) {
		if (ta!=null) {
		tc=null;
		tc = new PanelTable(data, App.fachada.colunasEncomenda(), "Encomendas");
		
		cpt.setPaneltable(tc);
		
		ta.setPanelTable(tc);
		tc.setVisible(true);
		}
	}
	
	public static void atualizarVendas() {
		if (ta!=null) {
		tp=null;
		tp = new PanelTable(App.fachada.dataVendas(), App.fachada.colunasVendas(), "Vendas");
		
		cpt.setPaneltable(tp);
		
		ta.setPanelTable(tp);
		tp.setVisible(true);
		}
	}
	
	public static void atualizarVendasBusca(String[][]data) {
		if (ta!=null) {
		tp=null;
		tp = new PanelTable(data, App.fachada.colunasVendas(), "Vendas");
		
		cpt.setPaneltable(tp);
		
		ta.setPanelTable(tp);
		tp.setVisible(true);
		}
	}
	
	public static void atualizarUsuarios() {
		if (ta!=null) {
		tu=null;
		tu = new PanelTable(App.fachada.dataUsuarios(), App.fachada.colunasUsuarios(), "Usuarios");
		
		cpt.setPaneltable(tu);
		
		ta.setPanelTable(tu);
		tu.setVisible(true);
		}
	}
	
	public static void atualizarUsuariosBusca(String [][]data) {
		if (ta!=null) {
		tu=null;
		tu = new PanelTable(data, App.fachada.colunasUsuarios(), "Usuarios");
		
		cpt.setPaneltable(tu);
		
		ta.setPanelTable(tu);
		tu.setVisible(true);
		}
	}
	
	public static void atualizarEnderecos() {
		if (ta!=null) {
		ted=null;
		ted = new PanelTable(App.fachada.dataEndereco(), App.fachada.colunasEndereco(), "Enderešos");
		
		cpt.setPaneltable(ted);
		
		ta.setPanelTable(ted);
		ted.setVisible(true);
		}
	}
	
	public static void atualizarEnderecosBusca(String [][]data) {
		if (ta!=null) {
		ted=null;
		ted = new PanelTable(data, App.fachada.colunasEndereco(), "Enderešos");
		
		cpt.setPaneltable(ted);
		
		ta.setPanelTable(ted);
		ted.setVisible(true);
		}
	}
	
	public static void atualizarTelaCadastrarProduto() {
		if (tcp!=null) tcp.dispose();
		tcp = new TelaCadastrarProduto();
		ccp = new ControllerCadastrarProduto(tcp);
		tcp.setVisible(true);
	}
	
	public static void atualizarTelaCadastrarUsuario() {
		if (tcu!=null)	tcu.dispose();
		tcu = new TelaCadastrarUsuario();
		ccu = new ControllerCadastrarUsuario(tcu);
		tcu.setVisible(true);

	}
	
	public static void atualizarTelaEncomendarProduto() {
		if (tcop!=null) tcop.dispose();
		tcop = new TelaEncomendarProduto();
		ccop = new ControllerComprarProduto(tcop);
		tcop.setVisible(true);
	}
	
	public static void atualizarTelaEditProduto() {
		if (tep!=null) 	tep.dispose();
		tep = new TelaEditarProduto();
		ctep = new ControllerTelaEditProduto(tep);
		tep.setVisible(true);
	}
	
	public static void atualizarTelaEditUsuario() {
		if (teu!=null) 	teu.dispose();
		teu = new TelaEditarUsuario();
		cteu = new ControllerTelaEditUsuario(teu);
		teu.setVisible(true);
	}

	public static PanelTable getTe() {
		return te;
	}

	public static void setTe(PanelTable te) {
		ControllerTelaAdministrador.te = te;
	}

	public static PanelTable getTc() {
		return tc;
	}

	public static void setTc(PanelTable tc) {
		ControllerTelaAdministrador.tc = tc;
	}

	public static PanelTable getTp() {
		return tp;
	}

	public static void setTp(PanelTable tp) {
		ControllerTelaAdministrador.tp = tp;
	}

	public static PanelTable getTu() {
		return tu;
	}

	public static void setTu(PanelTable tu) {
		ControllerTelaAdministrador.tu = tu;
	}
	
	
}
