package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Cliente;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaRealizarPedido extends JFrame {

	private JPanel contentPane;
	private JTextField fieldId;
	private JTextField fieldQnt;
	private JButton btnComprar;
	private Cliente cliente;

	public TelaRealizarPedido(Cliente cliente) {
		this.cliente = cliente;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 225, 215);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRealizarPedido = new JLabel("Realizar Pedido");
		lblRealizarPedido.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRealizarPedido.setBounds(58, 11, 118, 14);
		contentPane.add(lblRealizarPedido);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblId.setBounds(10, 59, 46, 14);
		contentPane.add(lblId);
		
		JLabel lblQnt = new JLabel("Qnt");
		lblQnt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQnt.setBounds(10, 84, 46, 25);
		contentPane.add(lblQnt);
		
		fieldId = new JTextField();
		fieldId.setBounds(48, 58, 46, 20);
		contentPane.add(fieldId);
		fieldId.setColumns(10);
		
		fieldQnt = new JTextField();
		fieldQnt.setBounds(48, 88, 46, 20);
		contentPane.add(fieldQnt);
		fieldQnt.setColumns(10);
		
		btnComprar = new JButton("Comprar");
		btnComprar.setBounds(58, 152, 89, 23);
		contentPane.add(btnComprar);
		setLocationRelativeTo(null);
		setResizable(false);
		
	}


	public JTextField getFieldId() {
		return fieldId;
	}


	public void setFieldId(JTextField fieldId) {
		this.fieldId = fieldId;
	}


	public JTextField getFieldQnt() {
		return fieldQnt;
	}


	public void setFieldQnt(JTextField fieldQnt) {
		this.fieldQnt = fieldQnt;
	}


	public JButton getBtnComprar() {
		return btnComprar;
	}


	public void setBtnComprar(JButton btnComprar) {
		this.btnComprar = btnComprar;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	

}
