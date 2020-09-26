package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class TelaLogin extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField fieldLogin;
	private JPasswordField fieldSenha;
	private JLabel lblLogin, lblSenha;
	private JButton btnEntrar;
	private JButton btnSair;

	public TelaLogin() {
		setBackground(Color.GRAY);
		setForeground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(Color.WHITE);
		
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane.setLayout(null);
		
		lblLogin = new JLabel("Usuario");
		lblLogin.setBounds(10, 76, 87, 22);
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblLogin);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setBounds(10, 150, 87, 22);
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblSenha);
		
		fieldLogin = new JTextField();
		fieldLogin.setBounds(75, 77, 369, 27);
		contentPane.add(fieldLogin);
		fieldLogin.setColumns(10);
		
		fieldSenha = new JPasswordField();
		fieldSenha.setBounds(75, 151, 369, 27);
		contentPane.add(fieldSenha);
		fieldSenha.setColumns(10);
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEntrar.setBounds(50, 216, 137, 44);
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEntrar.setBackground(Color.WHITE);
		contentPane.add(btnEntrar);
		
		JLabel lblLogin_1 = new JLabel("Login");
		lblLogin_1.setOpaque(true);
		lblLogin_1.setLabelFor(contentPane);
		lblLogin_1.setForeground(Color.WHITE);
		lblLogin_1.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblLogin_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin_1.setBackground(new Color(100, 149, 237));
		lblLogin_1.setBounds(0, 0, 454, 44);
		contentPane.add(lblLogin_1);
		
		btnSair = new JButton("Sair");
		btnSair.setBackground(Color.WHITE);
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSair.setBounds(267, 216, 137, 44);
		contentPane.add(btnSair);
		
		setVisible(true);
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

	public void setFieldSenha(JPasswordField fieldSenha) {
		this.fieldSenha = fieldSenha;
	}

	public JLabel getLblLogin() {
		return lblLogin;
	}

	public void setLblLogin(JLabel lblLogin) {
		this.lblLogin = lblLogin;
	}

	public JLabel getLblSenha() {
		return lblSenha;
	}

	public void setLblSenha(JLabel lblSenha) {
		this.lblSenha = lblSenha;
	}

	public JButton getBtnEntrar() {
		return btnEntrar;
	}

	public void setBtnEntrar(JButton btnEntrar) {
		this.btnEntrar = btnEntrar;
	}

	public JButton getBtnSair() {
		return btnSair;
	}

	public void setBtnSair(JButton btnSair) {
		this.btnSair = btnSair;
	}
	
	
}
