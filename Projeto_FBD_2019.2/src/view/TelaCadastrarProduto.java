package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.BaseDados;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaCadastrarProduto extends JFrame {

	private JPanel contentPane;
	private JTextField fieldNome;
	private JTextField fieldId;
	private JLabel lblNome, lblId, lblCadastrarProdutos;
	private JButton btnCadastrar;
	
	public TelaCadastrarProduto() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 225, 215);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		
		lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNome.setBounds(10, 51, 46, 14);
		contentPane.add(lblNome);
		
		lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblId.setBounds(23, 90, 30, 14);
		contentPane.add(lblId);
		
		lblCadastrarProdutos = new JLabel("Cadastrar Produtos");
		lblCadastrarProdutos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCadastrarProdutos.setBounds(45, 11, 132, 14);
		contentPane.add(lblCadastrarProdutos);
		
		fieldNome = new JTextField();
		fieldNome.setBounds(66, 50, 105, 20);
		contentPane.add(fieldNome);
		fieldNome.setColumns(10);
		
		fieldId = new JTextField();
		fieldId.setBounds(66, 89, 30, 20);
		contentPane.add(fieldId);
		fieldId.setColumns(10);
		String s = "" + (BaseDados.estoque.size()+1);
		fieldId.setText(s);
		
		btnCadastrar = new JButton("Cadastrar");
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
