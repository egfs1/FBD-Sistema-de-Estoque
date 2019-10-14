package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Administrador;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class TelaAdministrador extends JFrame {
	

	private static final long serialVersionUID = 1L;
	private TelaLogin tl;
	private Administrador adm;
	private JPanel contentPane;
	private JLabel label, lblUsuario;
	private JButton btnVisualizarEstoque, btnVisualizarPedidos, btnComprarProduto,
					btnCadastrarProduto, btnCadastrarCliente, btnDeslogar;
	private JButton btnVisualizarCompras;


	public TelaAdministrador(TelaLogin tl,Administrador adm) {
		this.tl = tl;
		this.adm = adm;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 179, 402);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		label = new JLabel(adm.getLogin());
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(66, 11, 87, 25);
		contentPane.add(label);
		
		lblUsuario = new JLabel("Usuario: ");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsuario.setBounds(10, 11, 68, 25);
		contentPane.add(lblUsuario);
		
		btnVisualizarEstoque = new JButton("Visualizar Estoque");
		btnVisualizarEstoque.setBackground(Color.WHITE);
		btnVisualizarEstoque.setBounds(10, 61, 153, 23);
		contentPane.add(btnVisualizarEstoque);
		
		btnCadastrarProduto = new JButton("Cadastrar Produto");
		btnCadastrarProduto.setBackground(Color.WHITE);
		btnCadastrarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCadastrarProduto.setBounds(10, 240, 153, 23);
		contentPane.add(btnCadastrarProduto);
		
		btnCadastrarCliente = new JButton("Cadastrar Usuario");
		btnCadastrarCliente.setBackground(Color.WHITE);
		btnCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadastrarCliente.setBounds(10, 274, 153, 23);
		contentPane.add(btnCadastrarCliente);
		
		btnVisualizarPedidos = new JButton("Visualizar Pedidos");
		btnVisualizarPedidos.setBackground(Color.WHITE);
		btnVisualizarPedidos.setBounds(10, 91, 153, 23);
		contentPane.add(btnVisualizarPedidos);
		
		btnComprarProduto = new JButton("Comprar Produto");
		btnComprarProduto.setBackground(Color.WHITE);
		btnComprarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnComprarProduto.setBounds(10, 185, 153, 23);
		contentPane.add(btnComprarProduto);
		
		btnDeslogar = new JButton("Deslogar");
		btnDeslogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnDeslogar.setBackground(Color.WHITE);
		btnDeslogar.setBounds(41, 339, 89, 23);
		contentPane.add(btnDeslogar);
		
		btnVisualizarCompras = new JButton("Visualizar Compras");
		btnVisualizarCompras.setBackground(Color.WHITE);
		btnVisualizarCompras.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnVisualizarCompras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVisualizarCompras.setBounds(10, 122, 153, 23);
		contentPane.add(btnVisualizarCompras);
		
		setVisible(true);
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
		return btnVisualizarPedidos;
	}


	public void setBtnVisualizarPedidos(JButton btnVisualizarPedidos) {
		this.btnVisualizarPedidos = btnVisualizarPedidos;
	}


	public JButton getBtnComprarProduto() {
		return btnComprarProduto;
	}


	public void setBtnComprarProduto(JButton btnComprarProduto) {
		this.btnComprarProduto = btnComprarProduto;
	}


	public JButton getBtnCadastrarProduto() {
		return btnCadastrarProduto;
	}


	public void setBtnCadastrarProduto(JButton btnCadastrarProduto) {
		this.btnCadastrarProduto = btnCadastrarProduto;
	}


	public JButton getBtnCadastrarCliente() {
		return btnCadastrarCliente;
	}


	public void setBtnCadastrarCliente(JButton btnCadastrarCliente) {
		this.btnCadastrarCliente = btnCadastrarCliente;
	}


	public JButton getBtnDeslogar() {
		return btnDeslogar;
	}


	public void setBtnDeslogar(JButton btnDeslogar) {
		this.btnDeslogar = btnDeslogar;
	}


	public JButton getBtnVisualizarCompras() {
		return btnVisualizarCompras;
	}


	public void setBtnVisualizarCompras(JButton btnVisualizarCompras) {
		this.btnVisualizarCompras = btnVisualizarCompras;
	}
}
