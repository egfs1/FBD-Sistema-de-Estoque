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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastrarUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField fieldUsuario;
	private JTextField fieldSenha;
	private JLabel lblCadastroDeUsuario, lblUsuario, lblSenha;
	private JRadioButton rdbtnCliente;
	private JButton btnCadastrar;
	private JRadioButton rdbtnFornecedor;
	private JLabel lblEmail;
	private JTextField fieldEmail;
	private JLabel lblPais;
	private JLabel lblEstado;
	private JLabel lblCidade;
	private JLabel lblBairro;
	private JLabel lblRua;
	private JLabel lblNumero;
	private JTextField paisField;
	private JTextField estadoField;
	private JTextField cidadeField;
	private JTextField bairroField;
	private JTextField ruaField;
	private JTextField numeroField;

	public TelaCadastrarUsuario() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 500);
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
		lblCadastroDeUsuario.setBounds(0, 0, 394, 38);
		contentPane.add(lblCadastroDeUsuario);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsuario.setBounds(10, 89, 105, 19);
		contentPane.add(lblUsuario);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSenha.setBounds(10, 134, 52, 19);
		contentPane.add(lblSenha);
		
		fieldUsuario = new JTextField();
		fieldUsuario.setBounds(72, 87, 312, 27);
		contentPane.add(fieldUsuario);
		fieldUsuario.setColumns(10);
		
		fieldSenha = new JTextField();
		fieldSenha.setBounds(72, 132, 312, 27);
		contentPane.add(fieldSenha);
		fieldSenha.setColumns(10);
		
		rdbtnCliente = new JRadioButton("Cliente", true);
		rdbtnCliente.setBackground(Color.WHITE);
		rdbtnCliente.setBounds(73, 45, 81, 23);
		contentPane.add(rdbtnCliente);
		
		rdbtnFornecedor = new JRadioButton("Fornecedor");
		rdbtnFornecedor.setBackground(Color.WHITE);
		rdbtnFornecedor.setBounds(156, 45, 109, 23);
		contentPane.add(rdbtnFornecedor);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnCliente);
		bg.add(rdbtnFornecedor);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCadastrar.setBackground(Color.WHITE);
		btnCadastrar.setBounds(141, 421, 105, 39);
		contentPane.add(btnCadastrar);
		
		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail.setBounds(10, 186, 46, 14);
		contentPane.add(lblEmail);
		
		fieldEmail = new JTextField();
		fieldEmail.setBounds(72, 182, 312, 27);
		contentPane.add(fieldEmail);
		fieldEmail.setColumns(10);
		
		lblPais = new JLabel("Pais");
		lblPais.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPais.setBounds(10, 257, 46, 14);
		contentPane.add(lblPais);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEstado.setBounds(200, 257, 46, 14);
		contentPane.add(lblEstado);
		
		lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCidade.setBounds(10, 307, 46, 14);
		contentPane.add(lblCidade);
		
		lblBairro = new JLabel("Bairro");
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBairro.setBounds(200, 307, 46, 14);
		contentPane.add(lblBairro);
		
		lblRua = new JLabel("Rua");
		lblRua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRua.setBounds(10, 357, 46, 14);
		contentPane.add(lblRua);
		
		lblNumero = new JLabel("Numero");
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNumero.setBounds(200, 357, 60, 14);
		contentPane.add(lblNumero);
		
		paisField = new JTextField();
		paisField.setBounds(72, 253, 100, 27);
		contentPane.add(paisField);
		paisField.setColumns(10);
		
		estadoField = new JTextField();
		estadoField.setBounds(284, 253, 100, 27);
		contentPane.add(estadoField);
		estadoField.setColumns(10);
		
		cidadeField = new JTextField();
		cidadeField.setBounds(72, 303, 100, 27);
		contentPane.add(cidadeField);
		cidadeField.setColumns(10);
		
		bairroField = new JTextField();
		bairroField.setBounds(284, 303, 100, 27);
		contentPane.add(bairroField);
		bairroField.setColumns(10);
		
		ruaField = new JTextField();
		ruaField.setBounds(72, 356, 100, 27);
		contentPane.add(ruaField);
		ruaField.setColumns(10);
		
		numeroField = new JTextField();
		numeroField.setBounds(284, 356, 96, 27);
		contentPane.add(numeroField);
		numeroField.setColumns(10);
		
		
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

	public JTextField getFieldEmail() {
		return fieldEmail;
	}

	public void setFieldEmail(JTextField fieldEmail) {
		this.fieldEmail = fieldEmail;
	}

	public JTextField getPaisField() {
		return paisField;
	}

	public void setPaisField(JTextField paisField) {
		this.paisField = paisField;
	}

	public JTextField getEstadoField() {
		return estadoField;
	}

	public void setEstadoField(JTextField estadoField) {
		this.estadoField = estadoField;
	}

	public JTextField getCidadeField() {
		return cidadeField;
	}

	public void setCidadeField(JTextField cidadeField) {
		this.cidadeField = cidadeField;
	}

	public JTextField getBairroField() {
		return bairroField;
	}

	public void setBairroField(JTextField bairroField) {
		this.bairroField = bairroField;
	}

	public JTextField getRuaField() {
		return ruaField;
	}

	public void setRuaField(JTextField ruaField) {
		this.ruaField = ruaField;
	}

	public JTextField getNumeroField() {
		return numeroField;
	}

	public void setNumeroField(JTextField numeroField) {
		this.numeroField = numeroField;
	}
	
	
	
	
}
