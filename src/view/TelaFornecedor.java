package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.Fornecedor;

public class TelaFornecedor extends JFrame {

	private static final long serialVersionUID = 1L;
	private TelaLogin tl;
	private Fornecedor fornecedor;
	private JPanel panelAcoes, panelTable;
	private JLabel lblUsuario;
	private JButton btnVisualizarEstoque;
	private JButton btnVisualizarEncomendas;
	private JMenuBar menuBar;
	private JMenu mnOpcoes;
	private JMenuItem mntmDeslogar;
	

	public TelaFornecedor(TelaLogin tl,Fornecedor fornecedor) {
		this.tl = tl;
		this.fornecedor = fornecedor;
		
		try {
			fornecedor.atualizarDataEncomendas();;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 900, 550);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		panelAcoes = new JPanel();
		panelAcoes.setBounds(0,24,176, 497);
		panelAcoes.setBackground(Color.WHITE);
		panelAcoes.setLayout(null);
		getContentPane().add(panelAcoes, BorderLayout.CENTER);
		
		lblUsuario = new JLabel("Usuario:	" + fornecedor.getLogin());
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsuario.setBounds(0, 0, 176, 36);
		panelAcoes.add(lblUsuario);
		
		btnVisualizarEstoque = new JButton("Visualizar Estoque");
		btnVisualizarEstoque.setBackground(Color.WHITE);
		btnVisualizarEstoque.setBounds(4, 60, 168, 50);
		panelAcoes.add(btnVisualizarEstoque);
		
		btnVisualizarEncomendas = new JButton("Visualizar Encomendas");
		btnVisualizarEncomendas.setBackground(Color.WHITE);
		btnVisualizarEncomendas.setBounds(4, 160, 168, 50);
		panelAcoes.add(btnVisualizarEncomendas);
		
		menuBar = new JMenuBar();
		menuBar.setMargin(new Insets(0, 0, 0, 450));
		menuBar.setBounds(0, 0, 894, 24);
		getContentPane().add(menuBar);
		
		mnOpcoes = new JMenu("Op\u00E7\u00F5es");
		menuBar.add(mnOpcoes);
		
		mntmDeslogar = new JMenuItem("Deslogar");
		mnOpcoes.add(mntmDeslogar);
		
		
		setVisible(true);
	}


	public TelaLogin getTl() {
		return tl;
	}


	public void setTl(TelaLogin tl) {
		this.tl = tl;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}


	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}


	public JButton getBtnVisualizarEstoque() {
		return btnVisualizarEstoque;
	}


	public void setBtnVisualizarEstoque(JButton btnVisualizarEstoque) {
		this.btnVisualizarEstoque = btnVisualizarEstoque;
	}


	public JPanel getPanelAcoes() {
		return panelAcoes;
	}


	public void setPanelAcoes(JPanel panelAcoes) {
		this.panelAcoes = panelAcoes;
	}


	public JPanel getPanelTable() {
		return panelTable;
	}


	public void setPanelTable(JPanel panelTable) {
		if (this.panelTable!=null)
			this.getContentPane().remove(this.panelTable);
		this.panelTable = panelTable;
		this.getContentPane().add(this.panelTable);
	}


	public JMenuItem getMntmDeslogar() {
		return mntmDeslogar;
	}


	public void setMntmDeslogar(JMenuItem mntmDeslogar) {
		this.mntmDeslogar = mntmDeslogar;
	}


	public JButton getBtnVisualizarEncomendas() {
		return btnVisualizarEncomendas;
	}


	public void setBtnVisualizarEncomendas(JButton btnVisualizarEncomendas) {
		this.btnVisualizarEncomendas = btnVisualizarEncomendas;
	}
	
	
	
	
}
