package view;


import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Administrador;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets;

public class TelaAdministrador extends JFrame {
	

	private static final long serialVersionUID = 1L;
	private TelaLogin tl;
	private Administrador adm;
	private JPanel panelAcoes, panelTable;
	private JLabel lblUsuario;
	private JButton btnVisualizarEstoque, btnVisualizarVendas;
	private JButton btnVisualizarEncomendas;
	private JMenuBar menuBar;
	private JMenu mnCadastrar;
	private JMenu mnEncomendar;
	private JMenuItem mntmCadastrarProduto;
	private JMenuItem mntmCadastrarUsuario;
	private JMenuItem mntmEncomendarProduto;
	private JMenuItem mntmDeslogar;
	private JButton btnVisualizarUsuarios;


	public TelaAdministrador(TelaLogin tl,Administrador adm) {
		getContentPane().setBackground(Color.WHITE);
		this.tl = tl;
		this.adm = adm;
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		
		panelAcoes = new JPanel();
		panelAcoes.setSize(176, 447);
		panelAcoes.setBackground(Color.WHITE);
		panelAcoes.setLayout(null);
		panelAcoes.setLocation(0, 24);
		getContentPane().add(panelAcoes);
		
		lblUsuario = new JLabel("Usuario:  " + adm.getLogin());
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setBounds(0, 0, 176, 36);
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelAcoes.add(lblUsuario);
		
		btnVisualizarEstoque = new JButton("Visualizar Estoque");
		btnVisualizarEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnVisualizarEstoque.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVisualizarEstoque.setBounds(4, 60, 168, 50);
		btnVisualizarEstoque.setBackground(Color.WHITE);
		panelAcoes.add(btnVisualizarEstoque);
		
		btnVisualizarVendas = new JButton("Visualizar Vendas");
		btnVisualizarVendas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVisualizarVendas.setBounds(4, 160, 168, 50);
		btnVisualizarVendas.setBackground(Color.WHITE);
		panelAcoes.add(btnVisualizarVendas);
		getContentPane().setLayout(null);
		
		btnVisualizarEncomendas = new JButton("Visualizar Encomendas");
		btnVisualizarEncomendas.setBounds(4, 260, 168, 50);
		btnVisualizarEncomendas.setBackground(Color.WHITE);
		btnVisualizarEncomendas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelAcoes.add(btnVisualizarEncomendas);
		
		btnVisualizarUsuarios = new JButton("Visualizar Usuarios");
		btnVisualizarUsuarios.setBackground(Color.WHITE);
		btnVisualizarUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVisualizarUsuarios.setBounds(4, 360, 168, 50);
		panelAcoes.add(btnVisualizarUsuarios);

		
		menuBar = new JMenuBar();
		menuBar.setMargin(new Insets(0, 0, 0, 450));
		menuBar.setBounds(0, 0, 694, 24);
		getContentPane().add(menuBar);
		
		mnCadastrar = new JMenu("Cadastrar");
		menuBar.add(mnCadastrar);
		
		mntmCadastrarProduto = new JMenuItem("Cadastrar Produto");
		mntmCadastrarProduto.setHorizontalAlignment(SwingConstants.LEFT);
		mnCadastrar.add(mntmCadastrarProduto);
		
		mntmCadastrarUsuario = new JMenuItem("Cadastrar Usuario");
		mntmCadastrarUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		mnCadastrar.add(mntmCadastrarUsuario);
				
		mnEncomendar = new JMenu("Encomendar");
		menuBar.add(mnEncomendar);
		
		mntmEncomendarProduto = new JMenuItem("Encomendar Produto");
		mnEncomendar.add(mntmEncomendarProduto);
		
		mntmDeslogar = new JMenuItem("Deslogar");
		mntmDeslogar.setSize(20,24);
		menuBar.add(mntmDeslogar);

		setVisible(true);
	}




	public JMenuItem getMntmDeslogar() {
		return mntmDeslogar;
	}




	public void setMntmDeslogar(JMenuItem mntmDeslogar) {
		this.mntmDeslogar = mntmDeslogar;
	}




	public JMenuItem getMntmCadastrarProduto() {
		return mntmCadastrarProduto;
	}




	public void setMntmCadastrarProduto(JMenuItem mntmCadastrarProduto) {
		this.mntmCadastrarProduto = mntmCadastrarProduto;
	}




	public JMenuItem getMntmCadastrarUsuario() {
		return mntmCadastrarUsuario;
	}




	public void setMntmCadastrarUsuario(JMenuItem mntmCadastrarUsuario) {
		this.mntmCadastrarUsuario = mntmCadastrarUsuario;
	}




	public JMenuItem getMntmEncomendarProduto() {
		return mntmEncomendarProduto;
	}




	public void setMntmEncomendarProduto(JMenuItem mntmEncomendarProduto) {
		this.mntmEncomendarProduto = mntmEncomendarProduto;
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


	public JPanel getPanelAcoes() {
		return panelAcoes;
	}




	public void setPanelAcoes(JPanel panelAcoes) {
		this.panelAcoes = panelAcoes;
	}

	public TelaLogin getTl() {
		return tl;
	}


	public void setTl(TelaLogin tl) {
		this.tl = tl;
	}


	public Administrador getUsuario() {
		return adm;
	}


	public void setUsuario(Administrador adm) {
		this.adm = adm;
	}


	public JButton getBtnVisualizarEstoque() {
		return btnVisualizarEstoque;
	}


	public void setBtnVisualizarEstoque(JButton btnVisualizarEstoque) {
		this.btnVisualizarEstoque = btnVisualizarEstoque;
	}


	public JButton getBtnVisualizarPedidos() {
		return btnVisualizarVendas;
	}


	public void setBtnVisualizarPedidos(JButton btnVisualizarPedidos) {
		this.btnVisualizarVendas = btnVisualizarPedidos;
	}


	public JButton getBtnVisualizarCompras() {
		return btnVisualizarEncomendas;
	}


	public void setBtnVisualizarCompras(JButton btnVisualizarCompras) {
		this.btnVisualizarEncomendas = btnVisualizarCompras;
	}




	public JButton getBtnVisualizarUsuarios() {
		return btnVisualizarUsuarios;
	}




	public void setBtnVisualizarUsuarios(JButton btnVisualizarUsuarios) {
		this.btnVisualizarUsuarios = btnVisualizarUsuarios;
	}
	
	
}
