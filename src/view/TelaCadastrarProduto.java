package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastrarProduto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField fieldNomeProduto;
	private JLabel lblNomeProduto, lblCadastrarProdutos;
	private JButton btnCadastrar, btnCancelar;
	private JLabel lblValorEncomenda;
	private JTextField fieldValorEncomenda;
	private JTextField fieldValorVenda;
	
	public TelaCadastrarProduto() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 351, 333);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		
		lblNomeProduto = new JLabel("Nome");
		lblNomeProduto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNomeProduto.setBounds(10, 60, 47, 14);
		contentPane.add(lblNomeProduto);
		
		lblCadastrarProdutos = new JLabel("Cadastrar Produtos");
		lblCadastrarProdutos.setForeground(Color.WHITE);
		lblCadastrarProdutos.setOpaque(true);
		lblCadastrarProdutos.setBackground(new Color(100, 149, 237));
		lblCadastrarProdutos.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarProdutos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCadastrarProdutos.setBounds(0, 0, 344, 35);
		contentPane.add(lblCadastrarProdutos);
		
		fieldNomeProduto = new JTextField();
		fieldNomeProduto.setBounds(143, 56, 191, 27);
		contentPane.add(fieldNomeProduto);
		fieldNomeProduto.setColumns(10);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCadastrar.setBackground(Color.WHITE);
		btnCadastrar.setBounds(50, 252, 105, 41);
		contentPane.add(btnCadastrar);
		
		getContentPane().add(contentPane);
		
		lblValorEncomenda = new JLabel("Valor (Encomenda)");
		lblValorEncomenda.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblValorEncomenda.setBounds(10, 120, 137, 23);
		contentPane.add(lblValorEncomenda);
		
		fieldValorEncomenda = new JTextField();
		fieldValorEncomenda.setBounds(144, 120, 191, 27);
		contentPane.add(fieldValorEncomenda);
		fieldValorEncomenda.setColumns(10);
		
		JLabel lblValorvenda = new JLabel("Valor (Venda)");
		lblValorvenda.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblValorvenda.setBounds(10, 180, 125, 27);
		contentPane.add(lblValorvenda);
		
		fieldValorVenda = new JTextField();
		fieldValorVenda.setBounds(143, 185, 191, 27);
		contentPane.add(fieldValorVenda);
		fieldValorVenda.setColumns(10);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setBounds(189, 252, 105, 41);
		contentPane.add(btnCancelar);
		setVisible(false);
	}

	public JTextField getFieldNomeProduto() {
		return fieldNomeProduto;
	}

	public void setFieldNomeProduto(JTextField fieldNome) {
		this.fieldNomeProduto = fieldNome;
	}

	public JButton getBtnCadastrar() {
		return btnCadastrar;
	}

	public void setBtnCadastrar(JButton btnCadastrar) {
		this.btnCadastrar = btnCadastrar;
	}

	public JTextField getFieldValorEncomenda() {
		return fieldValorEncomenda;
	}

	public void setFieldValorEncomenda(JTextField fieldValorEncomenda) {
		this.fieldValorEncomenda = fieldValorEncomenda;
	}

	public JTextField getFieldValorVenda() {
		return fieldValorVenda;
	}

	public void setFieldValorVenda(JTextField fieldValorVenda) {
		this.fieldValorVenda = fieldValorVenda;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}
	
	
}
