package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Relatorio;

import java.awt.TextArea;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class TelaRelatorio extends JFrame {

	private JPanel contentPane;
	private TextArea textArea;
	private JLabel lblValorDasVendas, lblValorDasEncomendas, lblLucro;
	
	public TelaRelatorio() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 483);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		textArea = new TextArea();
		textArea.setText(Relatorio.getRelatorioEncomendas() + Relatorio.getRelatorioVendas());
		textArea.setEditable(false);
		textArea.setBounds(10, 45, 414, 250);
		contentPane.add(textArea);
		
		JLabel lblRelatrio = new JLabel("Relat\u00F3rio");
		lblRelatrio.setOpaque(true);
		lblRelatrio.setBackground(new Color(100, 149, 237));
		lblRelatrio.setHorizontalAlignment(SwingConstants.CENTER);
		lblRelatrio.setForeground(Color.WHITE);
		lblRelatrio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRelatrio.setBounds(0, 0, 429, 39);
		contentPane.add(lblRelatrio);
		
		lblValorDasVendas = new JLabel("Valor das Vendas: R$" + Relatorio.getValorTotalVendas());
		lblValorDasVendas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblValorDasVendas.setBounds(10, 308, 414, 14);
		contentPane.add(lblValorDasVendas);
		
		lblValorDasEncomendas = new JLabel("Valor das Encomendas: R$" + Relatorio.getValorTotalEncomendas());
		lblValorDasEncomendas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblValorDasEncomendas.setBounds(10, 348, 414, 14);
		contentPane.add(lblValorDasEncomendas);
		
		lblLucro = new JLabel("Lucro: R$" + Relatorio.getLucro());
		lblLucro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLucro.setBounds(10, 386, 414, 14);
		contentPane.add(lblLucro);
		
		getContentPane().add(contentPane);
		
		setVisible(false);
	}
	
	public void atualizarTextArea() {
		textArea.setText(Relatorio.getRelatorioEncomendas() + Relatorio.getRelatorioVendas());
	}
	
	public void atualizarLblValorDasVendas() {
		lblValorDasVendas.setText("Valor das Vendas: R$" + Relatorio.getValorTotalVendas());
	}
	
	public void atualizarLblValorDasEncomendas() {
		lblValorDasEncomendas.setText("Valor das Encomendas: R$" + Relatorio.getValorTotalEncomendas());
	}
	
	public void atualizarLblLucro() {
		lblLucro.setText("Lucro: R$" + Relatorio.getLucro());
	}
	
	
}
