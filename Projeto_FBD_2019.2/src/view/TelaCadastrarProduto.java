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

public class TelaCadastrarProduto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField fieldNome;
	private JTextField fieldId;
	private JLabel lblNome, lblId, lblCadastrarProdutos;
	private JButton btnCadastrar;
	
	public TelaCadastrarProduto() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 225, 215);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		
		lblNome = new JLabel("Nome do Produto");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNome.setBounds(10, 51, 132, 14);
		contentPane.add(lblNome);
		
		lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblId.setBounds(10, 95, 30, 14);
		contentPane.add(lblId);
		
		lblCadastrarProdutos = new JLabel("Cadastrar Produtos");
		lblCadastrarProdutos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCadastrarProdutos.setBounds(45, 11, 132, 14);
		contentPane.add(lblCadastrarProdutos);
		
		fieldNome = new JTextField();
		fieldNome.setBounds(10, 68, 199, 27);
		contentPane.add(fieldNome);
		fieldNome.setColumns(10);
		
		fieldId = new JTextField();
		fieldId.setBounds(10, 112, 199, 27);
		contentPane.add(fieldId);
		fieldId.setColumns(10);
		String s = "" + (BaseDados.estoque.size()+1);
		fieldId.setText(s);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBackground(Color.WHITE);
		btnCadastrar.setBounds(55, 152, 105, 23);
		contentPane.add(btnCadastrar);
		
		setVisible(false);
	}

	public JTextField getFieldNome() {
		return fieldNome;
	}

	public void setFieldNome(JTextField fieldNome) {
		this.fieldNome = fieldNome;
	}

	public JTextField getFieldId() {
		return fieldId;
	}

	public void setFieldId(JTextField fieldId) {
		this.fieldId = fieldId;
	}

	public JButton getBtnCadastrar() {
		return btnCadastrar;
	}

	public void setBtnCadastrar(JButton btnCadastrar) {
		this.btnCadastrar = btnCadastrar;
	}
	
	
	

}
