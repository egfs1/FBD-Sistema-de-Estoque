package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaLogin extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField fieldLogin;
	private JTextField fieldSenha;
	private JLabel lblLogin, lblSenha;
	private JButton btnEntrar;

	public TelaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 201, 164);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLogin.setBounds(10, 11, 46, 19);
		contentPane.add(lblLogin);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSenha.setBounds(10, 49, 46, 14);
		contentPane.add(lblSenha);
		
		fieldLogin = new JTextField();
		fieldLogin.setBounds(54, 12, 120, 20);
		contentPane.add(fieldLogin);
		fieldLogin.setColumns(10);
		
		fieldSenha = new JTextField();
		fieldSenha.setBounds(54, 48, 120, 20);
		contentPane.add(fieldSenha);
		fieldSenha.setColumns(10);
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEntrar.setBounds(50, 91, 89, 23);
		contentPane.add(btnEntrar);
		
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
