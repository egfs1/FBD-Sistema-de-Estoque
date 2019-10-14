package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class TelaComprarProduto extends JFrame {

	private JPanel contentPane;
	private JTextField fieldQnt;
	private JTextField fieldId;
	private JTextField fieldFornecedor;
	private JButton btnComprar;

	public TelaComprarProduto() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 225, 215);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JLabel lblComprarProduto = new JLabel("Comprar Produto");
		lblComprarProduto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblComprarProduto.setBounds(44, -3, 111, 26);
		contentPane.add(lblComprarProduto);
		
		JLabel lblId = new JLabel("ID do Produto");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblId.setBounds(4, 70, 147, 14);
		contentPane.add(lblId);
		
		JLabel lblQnt = new JLabel("Qnt");
		lblQnt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQnt.setBounds(4, 107, 46, 26);
		contentPane.add(lblQnt);
		
		JLabel lblFornecedor = new JLabel("Fornecedor");
		lblFornecedor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFornecedor.setBounds(4, 25, 73, 14);
		contentPane.add(lblFornecedor);
		
		fieldQnt = new JTextField();
		fieldQnt.setBounds(4, 131, 205, 27);
		contentPane.add(fieldQnt);
		fieldQnt.setColumns(10);
		
		fieldId = new JTextField();
		fieldId.setBounds(4, 85, 205, 27);
		contentPane.add(fieldId);
		fieldId.setColumns(10);
		
		fieldFornecedor = new JTextField();
		fieldFornecedor.setBounds(4, 41, 205, 27);
		contentPane.add(fieldFornecedor);
		fieldFornecedor.setColumns(10);
		
		btnComprar = new JButton("Comprar");
		btnComprar.setBackground(Color.WHITE);
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnComprar.setBounds(62, 160, 89, 23);
		contentPane.add(btnComprar);
		
		setVisible(false);
	}

	public JTextField getFieldQnt() {
		return fieldQnt;
	}

	public void setFieldQnt(JTextField fieldQnt) {
		this.fieldQnt = fieldQnt;
	}

	public JTextField getFieldId() {
		return fieldId;
	}

	public void setFieldId(JTextField fieldId) {
		this.fieldId = fieldId;
	}

	public JTextField getFieldFornecedor() {
		return fieldFornecedor;
	}

	public void setFieldFornecedor(JTextField fieldFornecedor) {
		this.fieldFornecedor = fieldFornecedor;
	}

	public JButton getBtnComprar() {
		return btnComprar;
	}

	public void setBtnComprar(JButton btnComprar) {
		this.btnComprar = btnComprar;
	}
	
	

}
