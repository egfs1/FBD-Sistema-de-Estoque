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
import javax.swing.SwingConstants;

public class TelaEncomendarProduto extends JFrame {

	private JPanel contentPane;
	private JTextField fieldQnt;
	private JTextField fieldId;
	private JTextField fieldFornecedor;
	private JButton btnComprar;

	public TelaEncomendarProduto() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 350, 250);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JLabel lblComprarProduto = new JLabel("Encomendar Produto");
		lblComprarProduto.setHorizontalAlignment(SwingConstants.CENTER);
		lblComprarProduto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblComprarProduto.setBounds(0, 0, 344, 23);
		contentPane.add(lblComprarProduto);
		
		JLabel lblId = new JLabel("ID do Produto");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblId.setBounds(14, 79, 147, 14);
		contentPane.add(lblId);
		
		JLabel lblQnt = new JLabel("Quantidade");
		lblQnt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQnt.setBounds(14, 125, 147, 23);
		contentPane.add(lblQnt);
		
		JLabel lblFornecedor = new JLabel("Fornecedor");
		lblFornecedor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFornecedor.setBounds(14, 23, 73, 14);
		contentPane.add(lblFornecedor);
		
		fieldQnt = new JTextField();
		fieldQnt.setBounds(14, 149, 320, 27);
		contentPane.add(fieldQnt);
		fieldQnt.setColumns(10);
		
		fieldId = new JTextField();
		fieldId.setBounds(14, 97, 320, 27);
		contentPane.add(fieldId);
		fieldId.setColumns(10);
		
		fieldFornecedor = new JTextField();
		fieldFornecedor.setBounds(14, 41, 320, 27);
		contentPane.add(fieldFornecedor);
		fieldFornecedor.setColumns(10);
		
		btnComprar = new JButton("Encomendar");
		btnComprar.setBackground(Color.WHITE);
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnComprar.setBounds(105, 187, 128, 30);
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
