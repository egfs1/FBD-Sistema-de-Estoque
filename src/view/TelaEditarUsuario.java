package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Usuario;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaEditarUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField loginField;
	private JLabel lblIdDoUsuario, lblLogin, lblEditarUsuario;
	private JButton btnBuscar, btnSalvar, btnDeletar;
	private Usuario usuario;
	private JTextField senhaField, idField;
	private JLabel lblSenha;
	private JTextField emailField;
	
	public TelaEditarUsuario() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 397);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		idField = new JTextField();
		idField.setBounds(107, 60, 111, 27);
		contentPane.add(idField);
		idField.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(Color.WHITE);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBuscar.setBounds(228, 59, 89, 28);
		contentPane.add(btnBuscar);
		
		lblIdDoUsuario = new JLabel("ID do Usuario");
		lblIdDoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIdDoUsuario.setBounds(10, 61, 122, 20);
		contentPane.add(lblIdDoUsuario);
		
		loginField = new JTextField();
		loginField.setEnabled(false);
		loginField.setBounds(64, 116, 360, 27);
		contentPane.add(loginField);
		loginField.setColumns(10);
		
		lblLogin = new JLabel("Nome");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLogin.setBounds(10, 117, 111, 20);
		contentPane.add(lblLogin);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setEnabled(false);
		btnSalvar.setBackground(Color.WHITE);
		btnSalvar.setBounds(78, 306, 89, 35);
		contentPane.add(btnSalvar);
		
		btnDeletar = new JButton("Deletar");
		btnDeletar.setEnabled(false);
		btnDeletar.setBackground(Color.WHITE);
		btnDeletar.setBounds(262, 306, 89, 35);
		contentPane.add(btnDeletar);
		
		lblEditarUsuario = new JLabel("Editar Usuario");
		lblEditarUsuario.setOpaque(true);
		lblEditarUsuario.setBackground(new Color(100, 149, 237));
		lblEditarUsuario.setForeground(Color.WHITE);
		lblEditarUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditarUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEditarUsuario.setBounds(0, 0, 434, 35);
		contentPane.add(lblEditarUsuario);
		
		senhaField = new JTextField();
		senhaField.setEnabled(false);
		senhaField.setBounds(64, 176, 360, 27);
		contentPane.add(senhaField);
		senhaField.setColumns(10);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSenha.setBounds(10, 182, 83, 11);
		contentPane.add(lblSenha);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail.setBounds(10, 240, 46, 14);
		contentPane.add(lblEmail);
		
		emailField = new JTextField();
		emailField.setEnabled(false);
		emailField.setBounds(64, 236, 360, 27);
		contentPane.add(emailField);
		emailField.setColumns(10);
		
		setVisible(false);
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}

	public JButton getBtnSalvar() {
		return btnSalvar;
	}

	public void setBtnSalvar(JButton btnSalvar) {
		this.btnSalvar = btnSalvar;
	}

	public JButton getBtnDeletar() {
		return btnDeletar;
	}

	public void setBtnDeletar(JButton btnDeletar) {
		this.btnDeletar = btnDeletar;
	}

	public JTextField getNomeField() {
		return loginField;
	}

	public void setNomeField(JTextField nomeField) {
		this.loginField = nomeField;
	}

	public JTextField getLoginField() {
		return loginField;
	}

	public void setLoginField(JTextField loginField) {
		this.loginField = loginField;
	}

	public JTextField getSenhaField() {
		return senhaField;
	}

	public void setSenhaField(JTextField senhaField) {
		this.senhaField = senhaField;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public JTextField getIdField() {
		return idField;
	}

	public void setIdField(JTextField idField) {
		this.idField = idField;
	}

	public JTextField getEmailField() {
		return emailField;
	}

	public void setEmailField(JTextField emailField) {
		this.emailField = emailField;
	}
	
	
}