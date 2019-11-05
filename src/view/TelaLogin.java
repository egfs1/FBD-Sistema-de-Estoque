package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
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
	private JTextField fieldSenha;
	private JLabel lblLogin, lblSenha;
	private JButton btnEntrar;

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
		lblLogin.setBounds(10, 82, 87, 22);
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblLogin);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setBounds(10, 148, 87, 22);
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblSenha);
		
		fieldLogin = new JTextField();
		fieldLogin.setBounds(10, 104, 434, 27);
		contentPane.add(fieldLogin);
		fieldLogin.setColumns(10);
		
		fieldSenha = new JTextField();
		fieldSenha.setBounds(10, 170, 434, 27);
		contentPane.add(fieldSenha);
		fieldSenha.setColumns(10);
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEntrar.setBounds(157, 216, 137, 44);
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEntrar.setBackground(Color.WHITE);
		contentPane.add(btnEntrar);
		
		JLabel lblLogin_1 = new JLabel("Login");
		lblLogin_1.setLabelFor(contentPane);
		lblLogin_1.setForeground(Color.BLACK);
		lblLogin_1.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblLogin_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin_1.setBackground(Color.GRAY);
		lblLogin_1.setBounds(0, 0, 454, 44);
		contentPane.add(lblLogin_1);
		
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

	public void setFieldSenha(JTextField fieldSenha) {
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
}
