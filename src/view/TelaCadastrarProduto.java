package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.BaseDados;

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
	private JButton btnCadastrar;
	
	public TelaCadastrarProduto() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 350, 250);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		
		lblNomeProduto = new JLabel("Nome do Produto");
		lblNomeProduto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNomeProduto.setBounds(10, 89, 132, 14);
		contentPane.add(lblNomeProduto);
		
		lblCadastrarProdutos = new JLabel("Cadastrar Produtos");
		lblCadastrarProdutos.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarProdutos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCadastrarProdutos.setBounds(0, 0, 344, 25);
		contentPane.add(lblCadastrarProdutos);
		
		fieldNomeProduto = new JTextField();
		fieldNomeProduto.setBounds(10, 103, 324, 27);
		contentPane.add(fieldNomeProduto);
		fieldNomeProduto.setColumns(10);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCadastrar.setBackground(Color.WHITE);
		btnCadastrar.setBounds(110, 169, 105, 41);
		contentPane.add(btnCadastrar);
		
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
	
	
	

}
