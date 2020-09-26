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
	private JButton btnCancelar;

	public TelaEncomendarProduto() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 350, 314);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JLabel lblComprarProduto = new JLabel("Encomendar Produto");
		lblComprarProduto.setOpaque(true);
		lblComprarProduto.setForeground(Color.WHITE);
		lblComprarProduto.setBackground(new Color(100, 149, 237));
		lblComprarProduto.setHorizontalAlignment(SwingConstants.CENTER);
		lblComprarProduto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblComprarProduto.setBounds(0, 0, 344, 32);
		contentPane.add(lblComprarProduto);
		
		JLabel lblId = new JLabel("ID do Produto");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblId.setBounds(10, 120, 147, 14);
		contentPane.add(lblId);
		
		JLabel lblQnt = new JLabel("Quantidade");
		lblQnt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQnt.setBounds(10, 180, 147, 23);
		contentPane.add(lblQnt);
		
		JLabel lblFornecedor = new JLabel("Fornecedor");
		lblFornecedor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFornecedor.setBounds(10, 60, 73, 14);
		contentPane.add(lblFornecedor);
		
		fieldQnt = new JTextField();
		fieldQnt.setBounds(118, 180, 216, 27);
		contentPane.add(fieldQnt);
		fieldQnt.setColumns(10);
		
		fieldId = new JTextField();
		fieldId.setBounds(118, 116, 216, 27);
		contentPane.add(fieldId);
		fieldId.setColumns(10);
		
		fieldFornecedor = new JTextField();
		fieldFornecedor.setBounds(118, 56, 216, 27);
		contentPane.add(fieldFornecedor);
		fieldFornecedor.setColumns(10);
		
		btnComprar = new JButton("Encomendar");
		btnComprar.setBackground(Color.WHITE);
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnComprar.setBounds(10, 230, 105, 44);
		contentPane.add(btnComprar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setBounds(229, 232, 105, 42);
		contentPane.add(btnCancelar);
		
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

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}
	
	

}
