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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JLabel lblComprarProduto = new JLabel("Comprar Produto");
		lblComprarProduto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblComprarProduto.setBounds(44, 0, 111, 26);
		contentPane.add(lblComprarProduto);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblId.setBounds(10, 68, 33, 14);
		contentPane.add(lblId);
		
		JLabel lblQnt = new JLabel("Qnt");
		lblQnt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQnt.setBounds(10, 93, 46, 26);
		contentPane.add(lblQnt);
		
		JLabel lblFornecedor = new JLabel("Fornecedor");
		lblFornecedor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFornecedor.setBounds(10, 37, 73, 14);
		contentPane.add(lblFornecedor);
		
		fieldQnt = new JTextField();
		fieldQnt.setBounds(44, 98, 39, 20);
		contentPane.add(fieldQnt);
		fieldQnt.setColumns(10);
		
		fieldId = new JTextField();
		fieldId.setBounds(44, 67, 39, 20);
		contentPane.add(fieldId);
		fieldId.setColumns(10);
		
		fieldFornecedor = new JTextField();
		fieldFornecedor.setBounds(93, 37, 73, 20);
		contentPane.add(fieldFornecedor);
		fieldFornecedor.setColumns(10);
		
		btnComprar = new JButton("Comprar");
		btnComprar.setBounds(54, 142, 89, 23);
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
