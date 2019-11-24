package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Produto;
import model.Usuario;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class TelaEditarUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField loginField;
	private JLabel lblIdDoUsuario, lblLogin, lblEditarUsuario;
	private JButton btnBuscar, btnSalvar, btnDeletar;
	private Usuario usuario;
	private JTextField senhaField, idField;
	private JLabel lblSenha;
	
	public TelaEditarUsuario() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		idField = new JTextField();
		idField.setBounds(10, 60, 100, 27);
		contentPane.add(idField);
		idField.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(120, 59, 89, 28);
		contentPane.add(btnBuscar);
		
		lblIdDoUsuario = new JLabel("ID do Usuario");
		lblIdDoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIdDoUsuario.setBounds(10, 40, 122, 20);
		contentPane.add(lblIdDoUsuario);
		
		loginField = new JTextField();
		loginField.setEnabled(false);
		loginField.setBounds(10, 116, 414, 27);
		contentPane.add(loginField);
		loginField.setColumns(10);
		
		lblLogin = new JLabel("Nome");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLogin.setBounds(10, 97, 111, 20);
		contentPane.add(lblLogin);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setEnabled(false);
		btnSalvar.setBackground(Color.WHITE);
		btnSalvar.setBounds(80, 215, 89, 35);
		contentPane.add(btnSalvar);
		
		btnDeletar = new JButton("Deletar");
		btnDeletar.setEnabled(false);
		btnDeletar.setBackground(Color.WHITE);
		btnDeletar.setBounds(265, 215, 89, 35);
		contentPane.add(btnDeletar);
		
		lblEditarUsuario = new JLabel("Editar Usuario");
		lblEditarUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditarUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEditarUsuario.setBounds(0, 0, 434, 25);
		contentPane.add(lblEditarUsuario);
		
		senhaField = new JTextField();
		senhaField.setEnabled(false);
		senhaField.setBounds(10, 176, 414, 27);
		contentPane.add(senhaField);
		senhaField.setColumns(10);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSenha.setBounds(10, 163, 83, 11);
		contentPane.add(lblSenha);
		
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
	
	
}