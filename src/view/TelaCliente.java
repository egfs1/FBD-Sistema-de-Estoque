package view;

import java.awt.Font;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Cliente;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class TelaCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private TelaLogin tl;
	private Cliente cliente;
	private JPanel panelAcoes, panelTable;
	private JLabel lblUsuario;
	private JButton btnVisualizarEstoque;
	private JButton btnVisualizarPedidos;
	private JMenuBar menuBar;
	private JMenu mnOpcoes;
	private JMenuItem mntmRealizarPedido, mntmDeslogar;
	

	public TelaCliente(TelaLogin tl,Cliente cliente) {
		this.tl = tl;
		this.cliente = cliente;
		
		try {
			cliente.atualizarDataPedidos();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		panelAcoes = new JPanel();
		panelAcoes.setBounds(0,24,176, 447);
		panelAcoes.setBackground(Color.WHITE);
		panelAcoes.setLayout(null);
		getContentPane().add(panelAcoes, BorderLayout.CENTER);
		
		lblUsuario = new JLabel("Usuario:	" + cliente.getLogin());
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsuario.setBounds(0, 0, 176, 36);
		panelAcoes.add(lblUsuario);
		
		btnVisualizarEstoque = new JButton("Visualizar Estoque");
		btnVisualizarEstoque.setBackground(Color.WHITE);
		btnVisualizarEstoque.setBounds(4, 60, 168, 50);
		panelAcoes.add(btnVisualizarEstoque);
		
		btnVisualizarPedidos = new JButton("Visualizar Pedidos");
		btnVisualizarPedidos.setBackground(Color.WHITE);
		btnVisualizarPedidos.setBounds(4, 160, 168, 50);
		panelAcoes.add(btnVisualizarPedidos);
		
		menuBar = new JMenuBar();
		menuBar.setMargin(new Insets(0, 0, 0, 450));
		menuBar.setBounds(0, 0, 694, 24);
		getContentPane().add(menuBar);
		
		mnOpcoes = new JMenu("Op\u00E7\u00F5es");
		menuBar.add(mnOpcoes);
		
		mntmRealizarPedido = new JMenuItem("Realizar Pedido");
		mnOpcoes.add(mntmRealizarPedido);
		
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


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public JButton getBtnVisualizarEstoque() {
		return btnVisualizarEstoque;
	}


	public void setBtnVisualizarEstoque(JButton btnVisualizarEstoque) {
		this.btnVisualizarEstoque = btnVisualizarEstoque;
	}


	public JButton getBtnVisualizarPedidos() {
		return btnVisualizarPedidos;
	}


	public void setBtnVisualizarPedidos(JButton btnVisualizarPedidos) {
		this.btnVisualizarPedidos = btnVisualizarPedidos;
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


	public JMenuItem getMntmRealizarPedido() {
		return mntmRealizarPedido;
	}


	public void setMntmRealizarPedido(JMenuItem mntmRealizarPedido) {
		this.mntmRealizarPedido = mntmRealizarPedido;
	}


	public JMenuItem getMntmDeslogar() {
		return mntmDeslogar;
	}


	public void setMntmDeslogar(JMenuItem mntmDeslogar) {
		this.mntmDeslogar = mntmDeslogar;
	}
	
	
	
}
