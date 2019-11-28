package view;


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
import javax.swing.SwingConstants;

public class TelaCadastrarUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField fieldUsuario;
	private JTextField fieldSenha;
	private JLabel lblCadastroDeUsuario, lblUsuario, lblSenha;
	private JRadioButton rdbtnCliente;
	private JButton btnCadastrar;
	private JRadioButton rdbtnFornecedor;

	public TelaCadastrarUsuario() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 350, 322);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		
		lblCadastroDeUsuario = new JLabel("Cadastro de Usuario");
		lblCadastroDeUsuario.setOpaque(true);
		lblCadastroDeUsuario.setBackground(new Color(100, 149, 237));
		lblCadastroDeUsuario.setForeground(Color.WHITE);
		lblCadastroDeUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCadastroDeUsuario.setBounds(0, 0, 344, 38);
		contentPane.add(lblCadastroDeUsuario);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsuario.setBounds(10, 72, 105, 19);
		contentPane.add(lblUsuario);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSenha.setBounds(10, 117, 52, 19);
		contentPane.add(lblSenha);
		
		fieldUsuario = new JTextField();
		fieldUsuario.setBounds(72, 70, 263, 27);
		contentPane.add(fieldUsuario);
		fieldUsuario.setColumns(10);
		
		fieldSenha = new JTextField();
		fieldSenha.setBounds(72, 115, 263, 27);
		contentPane.add(fieldSenha);
		fieldSenha.setColumns(10);
		
		rdbtnCliente = new JRadioButton("Cliente", true);
		rdbtnCliente.setBackground(Color.WHITE);
		rdbtnCliente.setBounds(6, 164, 81, 23);
		contentPane.add(rdbtnCliente);
		
		rdbtnFornecedor = new JRadioButton("Fornecedor");
		rdbtnFornecedor.setBackground(Color.WHITE);
		rdbtnFornecedor.setBounds(6, 202, 109, 23);
		contentPane.add(rdbtnFornecedor);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnCliente);
		bg.add(rdbtnFornecedor);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBackground(Color.WHITE);
		btnCadastrar.setBounds(110, 243, 105, 39);
		contentPane.add(btnCadastrar);
		
		
		setVisible(false);
	}

	public JTextField getFieldUsuario() {
		return fieldUsuario;
	}

	public void setFieldUsuario(JTextField fieldLogin) {
		this.fieldUsuario = fieldLogin;
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
