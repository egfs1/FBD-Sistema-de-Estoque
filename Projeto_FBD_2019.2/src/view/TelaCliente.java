package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Cliente;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private TelaLogin tl;
	private Cliente cliente;
	private JPanel contentPane;
	private JLabel label, lblUsuario;
	private JButton btnDeslogar;
	private JButton btnVisualizarEstoque;
	private JButton btnRealizarPedido;
	private JButton btnVisualizarPedidos;


	public TelaCliente(TelaLogin tl,Cliente cliente) {
		this.tl = tl;
		this.cliente = cliente;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 179, 306);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		label = new JLabel(cliente.getLogin());
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(66, 11, 87, 25);
		contentPane.add(label);
		
		lblUsuario = new JLabel("Usuario: ");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsuario.setBounds(10, 11, 68, 25);
		contentPane.add(lblUsuario);
		
		btnDeslogar = new JButton("Deslogar");
		btnDeslogar.setBounds(41, 243, 89, 23);
		contentPane.add(btnDeslogar);
		
		btnVisualizarEstoque = new JButton("Visualizar Estoque");
		btnVisualizarEstoque.setBounds(20, 58, 133, 23);
		contentPane.add(btnVisualizarEstoque);
		
		btnRealizarPedido = new JButton("Realizar Pedido");
		btnRealizarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRealizarPedido.setBounds(20, 153, 133, 23);
		contentPane.add(btnRealizarPedido);
		
		btnVisualizarPedidos = new JButton("Visualizar Pedidos");
		btnVisualizarPedidos.setBounds(20, 92, 133, 23);
		contentPane.add(btnVisualizarPedidos);
		
		setVisible(true);
	}


	public TelaLogin getTl() {
		return tl;
	}


	public void setTl(TelaLogin tl) {
		this.tl = tl;
	}


	public JButton getBtnDeslogar() {
		return btnDeslogar;
	}


	public void setBtnDeslogar(JButton btnDeslogar) {
		this.btnDeslogar = btnDeslogar;
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


	public JButton getBtnRealizarPedido() {
		return btnRealizarPedido;
	}


	public void setBtnRealizarPedido(JButton btnRealizarPedido) {
		this.btnRealizarPedido = btnRealizarPedido;
	}


	public JButton getBtnVisualizarPedidos() {
		return btnVisualizarPedidos;
	}


	public void setBtnVisualizarPedidos(JButton btnVisualizarPedidos) {
		this.btnVisualizarPedidos = btnVisualizarPedidos;
	}
	
	

}
