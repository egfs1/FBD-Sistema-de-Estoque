package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Produto;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class TelaEditarProduto extends JFrame {

	private JPanel contentPane;
	private JTextField idField;
	private JTextField nomeField;
	private JLabel lblIdDoProduto, lblNome, lblEditarProduto;
	private JButton btnBuscar, btnSalvar, btnDeletar;
	private Produto produto;
	
	public TelaEditarProduto() {
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
		
		lblIdDoProduto = new JLabel("ID do Produto");
		lblIdDoProduto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIdDoProduto.setBounds(10, 40, 122, 20);
		contentPane.add(lblIdDoProduto);
		
		nomeField = new JTextField();
		nomeField.setEnabled(false);
		nomeField.setBounds(10, 116, 414, 27);
		contentPane.add(nomeField);
		nomeField.setColumns(10);
		
		lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNome.setBounds(10, 97, 111, 20);
		contentPane.add(lblNome);
		
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
		
		lblEditarProduto = new JLabel("Editar Produto");
		lblEditarProduto.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditarProduto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEditarProduto.setBounds(0, 0, 434, 25);
		contentPane.add(lblEditarProduto);
		
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

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public JTextField getIdField() {
		return idField;
	}

	public void setIdField(JTextField idField) {
		this.idField = idField;
	}

	public JTextField getNomeField() {
		return nomeField;
	}

	public void setNomeField(JTextField nomeField) {
		this.nomeField = nomeField;
	}
	
}
