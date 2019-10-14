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

public class TelaCadastrarUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField fieldLogin;
	private JTextField fieldSenha;
	private JLabel lblCadastroDeUsuario, lblLogin, lblSenha;
	private JRadioButton rdbtnCliente, rdbtnCaixa;
	private JButton btnCadastrar;

	public TelaCadastrarUsuario() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 225, 215);
		contentPane = new JPanel();
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
		lblLogin.setBounds(10, 45, 105, 19);
		contentPane.add(lblLogin);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSenha.setBounds(10, 85, 52, 14);
		contentPane.add(lblSenha);
		
		fieldLogin = new JTextField();
		fieldLogin.setBounds(58, 46, 119, 20);
		contentPane.add(fieldLogin);
		fieldLogin.setColumns(10);
		
		fieldSenha = new JTextField();
		fieldSenha.setBounds(58, 84, 119, 20);
		contentPane.add(fieldSenha);
		fieldSenha.setColumns(10);
		
		rdbtnCliente = new JRadioButton("Cliente", true);
		rdbtnCliente.setBounds(10, 119, 81, 23);
		contentPane.add(rdbtnCliente);
		
		rdbtnCaixa = new JRadioButton("Caixa");
		rdbtnCaixa.setBounds(94, 119, 109, 23);
		contentPane.add(rdbtnCaixa);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnCaixa);
		bg.add(rdbtnCliente);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(58, 149, 97, 23);
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
	
	
}
