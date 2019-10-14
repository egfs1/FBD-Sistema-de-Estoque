package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;

public class TelaCadastrarUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField fieldLogin;
	private JTextField fieldSenha;
	private JLabel lblCadastroDeUsuario, lblLogin, lblSenha;
	private JRadioButton rdbtnCliente, rdbtnCaixa;
	private JButton btnCadastrar;
	private JRadioButton rdbtnFornecedor;

	public TelaCadastrarUsuario() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 225, 296);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		
		lblCadastroDeUsuario = new JLabel("Cadastro de Usuario");
		lblCadastroDeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCadastroDeUsuario.setBounds(36, 11, 141, 14);
		contentPane.add(lblCadastroDeUsuario);
		
		lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLogin.setBounds(10, 36, 105, 19);
		contentPane.add(lblLogin);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSenha.setBounds(10, 85, 52, 14);
		contentPane.add(lblSenha);
		
		fieldLogin = new JTextField();
		fieldLogin.setBounds(10, 55, 199, 27);
		contentPane.add(fieldLogin);
		fieldLogin.setColumns(10);
		
		fieldSenha = new JTextField();
		fieldSenha.setBounds(10, 100, 199, 27);
		contentPane.add(fieldSenha);
		fieldSenha.setColumns(10);
		
		rdbtnCliente = new JRadioButton("Cliente", true);
		rdbtnCliente.setBackground(Color.WHITE);
		rdbtnCliente.setBounds(10, 127, 81, 23);
		contentPane.add(rdbtnCliente);
		
		rdbtnCaixa = new JRadioButton("Caixa");
		rdbtnCaixa.setBackground(Color.WHITE);
		rdbtnCaixa.setBounds(12, 163, 109, 23);
		contentPane.add(rdbtnCaixa);
		
		rdbtnFornecedor = new JRadioButton("Fornecedor");
		rdbtnFornecedor.setBackground(Color.WHITE);
		rdbtnFornecedor.setBounds(12, 200, 109, 23);
		contentPane.add(rdbtnFornecedor);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnCaixa);
		bg.add(rdbtnCliente);
		bg.add(rdbtnFornecedor);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBackground(Color.WHITE);
		btnCadastrar.setBounds(59, 232, 97, 23);
		contentPane.add(btnCadastrar);
		
		
		setVisible(false);
	}

	public JTextField getFieldLogin() {
		return fieldLogin;
	}

	public void setFieldLogin(JTextField fieldLogin) {
		this.fieldLogin = fieldLogin;
	}

	public JTextField getFieldSenha() {
		return fieldSenha;
	}

	public void setFieldSenha(JTextField fieldSenha) {
		this.fieldSenha = fieldSenha;
	}

	public JRadioButton getRdbtnCliente() {
		return rdbtnCliente;
	}

	public void setRdbtnCliente(JRadioButton rdbtnCliente) {
		this.rdbtnCliente = rdbtnCliente;
	}

	public JRadioButton getRdbtnCaixa() {
		return rdbtnCaixa;
	}

	public void setRdbtnCaixa(JRadioButton rdbtnCaixa) {
		this.rdbtnCaixa = rdbtnCaixa;
	}

	public JButton getBtnCadastrar() {
		return btnCadastrar;
	}

	public void setBtnCadastrar(JButton btnCadastrar) {
		this.btnCadastrar = btnCadastrar;
	}

	public JRadioButton getRdbtnFornecedor() {
		return rdbtnFornecedor;
	}

	public void setRdbtnFornecedor(JRadioButton rdbtnFornecedor) {
		this.rdbtnFornecedor = rdbtnFornecedor;
	}
	
	
}
